package com.example.migracaodados.writer;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.migracaodados.domain.Pessoa;

@Configuration
public class BancoPessoaWriterConfig {

	@Bean
	public JdbcBatchItemWriter<Pessoa> bancoPessoaWriter(@Qualifier("appDataSource") DataSource dataSource){
		return new JdbcBatchItemWriterBuilder<Pessoa>()
				.dataSource(dataSource)
				.sql("insert into pessoa (id, nome, email, data_nascimento, idade) values(?, ?, ?, ?, ?)")
				.itemPreparedStatementSetter(itemPreparedStatementSetter())
				.build();
		
	}

	private ItemPreparedStatementSetter<Pessoa> itemPreparedStatementSetter() {
		return new ItemPreparedStatementSetter<Pessoa>() {
			
			@Override
			public void setValues(Pessoa item, PreparedStatement ps) throws SQLException {
				ps.setInt(1, item.getId());
				ps.setString(2, item.getNome());
				ps.setString(3, item.getEmail());
				ps.setDate(4, new Date(item.getDataNascimento().getTime()));
				ps.setInt(5, item.getIdade());
				
			}
		};
	}
	
	
}
