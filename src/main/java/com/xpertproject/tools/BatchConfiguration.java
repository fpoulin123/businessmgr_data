package com.xpertproject.tools;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

import com.xpertproject.tools.domain.Customer;
import com.xpertproject.tools.domain.TransformedCustomer;
import com.xpertproject.tools.processor.CustomerItemProcessor;

@Configuration
public class BatchConfiguration {
	
	@Value("${file.input}")
    private String fileInput;
	
	@Bean
	@ConfigurationProperties("app.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	
	@SuppressWarnings("rawtypes")
	@Bean
	public FlatFileItemReader reader() {
	    return new FlatFileItemReaderBuilder().name("customerItemReader")
	      .resource(new ClassPathResource(fileInput))
	      .delimited().delimiter(";")
	      .names(new String[] {"lastName", "firstName", "address", "city", "phoneNumber","phoneNumber2","course","inscriptionDate","duration","endDate","amount","acount1","solde1", "account2", "solde2", "account3", "solde3","soldItems","email" })
	      .fieldSetMapper(new BeanWrapperFieldSetMapper() {{
	          setTargetType(Customer.class);
	      }})
	      .build();
	}
	
	@Bean
	public JdbcBatchItemWriter<TransformedCustomer> writer(DataSource dataSource) {
	    return new JdbcBatchItemWriterBuilder<TransformedCustomer>()
	      .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
	      .sql("INSERT INTO alldata (firstname, lastname, address, city, phonenumber, course, inscriptiondate, duration, amount, account1, solde1, account2, solde2, account3,solde3, email) VALUES (:firstName, :lastName, :address, :city, :phoneNumber, :course, :inscriptionDate, :duration, :amount, :account1, :solde1, :account2, :solde2, :account3, :solde3, :email)")
	      .dataSource(dataSource)
	      .build();
	}
	
	@Bean
	public Job importUserJob(JobRepository jobRepository, JobCompletionNotificationListener listener, Step step1) {
	    return new JobBuilder("importUserJob", jobRepository)
	      .incrementer(new RunIdIncrementer())
	      .listener(listener)
	      .flow(step1)
	      .end()
	      .build();
	}

	@Bean
	public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager, JdbcBatchItemWriter writer) {
	    return new StepBuilder("step1", jobRepository)
	      .<Customer, TransformedCustomer> chunk(10, transactionManager)
	      .reader(reader())
	      .processor(processor())
	      .writer(writer)
	      .build();
	}

	@Bean
	public CustomerItemProcessor processor() {
	    return new CustomerItemProcessor();
	}
	
	@Bean
	public JobCompletionNotificationListener jobCompletionNotificationListener() {
		return new JobCompletionNotificationListener();
	}

}
