package com.latam.alura.tienda.dao;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Cosas;

public class CosasDao {
	
	private EntityManager em;

	public CosasDao(EntityManager em) {
		this.em = em;
	}
	
	public void guardar(Cosas cosas) {
		this.em.persist(cosas);
	}
	
	

}
