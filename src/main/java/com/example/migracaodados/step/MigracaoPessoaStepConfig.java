package com.example.migracaodados.step;


import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.migracaodados.domain.Pessoa;

@Configuration
public class MigracaoPessoaStepConfig {
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step migrarPessoaStep(ItemReader<Pessoa> arquivoPessoaReader, ItemWriter<Pessoa> bancoPessoaWriter) {
		return stepBuilderFactory
				.get("migrarPessoaStep")
				.<Pessoa, Pessoa>chunk(1)
				.reader(arquivoPessoaReader)
				.writer(bancoPessoaWriter)
				.build();
	}

}
