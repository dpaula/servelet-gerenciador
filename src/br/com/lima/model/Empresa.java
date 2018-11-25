package br.com.lima.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Empresa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer Id;
	private String nome;
	//usando anotacao para identificar o atributo como data na tabela
	@Temporal(TemporalType.DATE)
	private Date data;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return Id;
	}

	/**
	 * @param id the id to set
	 * @return 
	 */
	public Empresa setId(Integer id) {
		Id = id;
		return this;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * @param nome the nome to set
	 * @return
	 */
	public Empresa setNome(String nome) {
		this.nome = nome;
		return this;
	}

	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}

	/**
	 * @param data the data to set
	 * @return 
	 */
	public Empresa setData(Date data) {
		this.data = data;
		return this;
	}

}
