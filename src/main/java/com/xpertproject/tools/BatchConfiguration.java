package com.xpertproject.tools;

import java.util.Date;
import java.util.concurrent.Flow.Subscription;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.PlatformTransactionManager;

import com.xpertproject.tools.domain.Customer;
import com.xpertproject.tools.domain.Data;
import com.xpertproject.tools.domain.TransformedData;
import com.xpertproject.tools.model.DataDto;
import com.xpertproject.tools.processor.DataItemProcessor;
import com.xpertproject.tools.processor.DataToCustomerItemProcessor;
import com.xpertproject.tools.processor.DataToSubscriptionProcessor;

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
	    return new FlatFileItemReaderBuilder<Data>().name("dataItemReader")
	      .resource(new ClassPathResource(fileInput))
	      .delimited().delimiter(";")
	      .names(new String[] {"lastName", "firstName", "address", "city", "phoneNumber","phoneNumber2","course","inscriptionDate","duration","endDate","amount","acount1","solde1", "account2", "solde2", "account3", "solde3","soldItems","email" })
	      .fieldSetMapper(new BeanWrapperFieldSetMapper<Data>() {{
	          setTargetType(Data.class);
	      }})
	      .build();
	}
	
	@Bean
	public JdbcCursorItemReader<DataDto> jdbcDataReader(){
		return new JdbcCursorItemReaderBuilder<DataDto>()
				.dataSource(dataSource())
				.sql("SELECT * FROM alldata")
				.rowMapper(new BeanPropertyRowMapper<DataDto>(DataDto.class))
				.name("alldatareader")
				.build();
	}
	
	@Bean
	public JdbcBatchItemWriter<TransformedData> writer(DataSource dataSource) {
	    return new JdbcBatchItemWriterBuilder<TransformedData>()
	      .itemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>())
	      .sql("INSERT INTO alldata (firstname, lastname, address, city, phonenumber, course, inscriptiondate, duration, amount, account1, solde1, account2, solde2, account3,solde3, email) VALUES (:firstName, :lastName, :address, :city, :phoneNumber, :course, :inscriptionDate, :duration, :amount, :account1, :solde1, :account2, :solde2, :account3, :solde3, :email)")
	      .dataSource(dataSource)
	      .build();
	}
	
	@Bean
	public CustomerWriter<Customer> jdbcCustomerWriter(DataSource dataSource) {
		
		CustomerWriter<Customer> writer = new CustomerWriter<Customer>();
		
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		writer.setSql("INSERT INTO customer (id, firstname, lastname, address, city, phonenumber, email) VALUES (:id, :firstname, :lastname, :address, :city, :phonenumber, :email)");
		writer.setDataSource(dataSource);
		return writer;
		
	}
	
	@Bean
	public SubscriptionWriter<Subscription> jdbcSubscriptionWriter(DataSource dataSource) {
		
		SubscriptionWriter<Subscription> writer = new SubscriptionWriter<Subscription>();
		
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		writer.setSql("INSERT INTO subscription (customer_id, duration, taekwondo, kickboxing, taekibodo, amount, subscription_date) VALUES (:customerId, :duration, :taekwondo, :kickboxing, :taekibodo, :amount, :inscriptionDate)");
		writer.setDataSource(dataSource);
		return writer;
		
	}
	
	@Bean
	public Job importUserJob(JobRepository jobRepository, JobCompletionNotificationListener listener, Step step1, Step step2, Step step3) {
	    return new JobBuilder("importUserJob", jobRepository)
	      .incrementer(new RunIdIncrementer())
	      .listener(listener)
	      .start(step1)
	      .next(step2)
	      .next(step3)
	      .build();
	}

	@Bean
	public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager, JdbcBatchItemWriter writer) {
	    return new StepBuilder("step1", jobRepository)
	      .<Data, TransformedData> chunk(10, transactionManager)
	      .reader(reader())
	      .processor(processor())
	      .writer(writer)
	      .build();
	}
	
	@Bean
	public Step step2(JobRepository jobRepository, PlatformTransactionManager transactionManager, CustomerWriter<Customer> writer) {
		return new StepBuilder("step2", jobRepository)
				.<DataDto, Customer> chunk(10, transactionManager)
				.reader(jdbcDataReader())
				.processor(dataToCustomerProcessor())
				.writer(writer)
				.build();
		
	}
	
	@Bean
	public Step step3(JobRepository jobRepository, PlatformTransactionManager transactionManager, SubscriptionWriter<Subscription> writer) {
		return new StepBuilder("step3", jobRepository)
				.<DataDto, Subscription> chunk(10, transactionManager)
				.reader(jdbcDataReader())
				.processor(dataToSubscriptionProcessor())
				.writer(writer)
				.build();
		
	}

	@Bean
	public DataItemProcessor processor() {
	    return new DataItemProcessor();
	}
	
	@Bean DataToCustomerItemProcessor dataToCustomerProcessor() {
		return new DataToCustomerItemProcessor();
	}
	
	@Bean DataToSubscriptionProcessor dataToSubscriptionProcessor() {
		return new DataToSubscriptionProcessor();
	}
	
	@Bean
	public JobCompletionNotificationListener jobCompletionNotificationListener() {
		return new JobCompletionNotificationListener();
	}

}
