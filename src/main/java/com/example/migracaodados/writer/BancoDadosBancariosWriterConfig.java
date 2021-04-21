package com.example.migracaodados.writer;


import javax.sql.DataSource;

import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.migracaodados.domain.DadosBancarios;

@Configuration
public class BancoDadosBancariosWriterConfig {

	@Bean
	public JdbcBatchItemWriter<DadosBancarios> bancoDadosBancariosWriter(@Qualifier("appDataSource") DataSource dataSource){
		return new JdbcBatchItemWriterBuilder<DadosBancarios>()
				.dataSource(dataSource)
				.sql("insert into dados_bancarios (id, pessoa_id, agencia, conta, banco) values(:id, :pessoa_id, :agencia, :conta, :banco)")
				.beanMapped()
				.build();
		
	}
	
	
}
