package com.example.migracaodados.domain;

import java.util.Date;

import org.apache.logging.log4j.util.Strings;

public class Pessoa {

	private int id;
	private String nome;
	private String email;
	private Date dataNascimento;
	private int idade;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", email=" + email + ", dataNascimento=" + dataNascimento
				+ ", idade=" + idade + ", getId()=" + getId() + ", getNome()=" + getNome() + ", getEmail()="
				+ getEmail() + ", getDataNascimento()=" + getDataNascimento() + ", getIdade()=" + getIdade()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	public boolean isValida() {
		// TODO Auto-generated method stub
		return !Strings.isBlank(nome) && !Strings.isBlank(email) && dataNascimento!=null;
	}
	
	
	
	
}
