package com.latam.alura.tienda.prueba;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;

import com.latam.alura.tienda.dao.CategoriaDao;
import com.latam.alura.tienda.dao.ProductoDao;
import com.latam.alura.tienda.modelo.Categoria;
import com.latam.alura.tienda.modelo.Producto;
import com.latam.alura.tienda.utils.JPAUtils;

public class RegistroDeProducto {

	public static void main(String[] args) {
		registrarProducto();
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDao productoDao = new ProductoDao(em);
		Producto producto = productoDao.consultaPorId(1L);
		Producto producto2 = productoDao.consultaPorId(2L);
		System.out.println(producto.getNombre());
		System.out.println(producto2.getNombre());
		
		
		List<Producto> productos = productoDao.consultaPorNombreDeCategoria("CELULARES");
		productos.forEach(prod-> System.out.println(prod.getDescripcion()));
		
		BigDecimal precio = productoDao.consultarPrecioPorNombreDeProducto("Xiaomi Redmi");
		System.out.println(precio);

	}

	private static void registrarProducto() {
		Categoria celulares = new Categoria("CELULARES");
		
		Producto celular = new Producto("Xiaomi Redmi","Muy Bueno",new BigDecimal("800"), celulares);
		Producto celular2 = new Producto("Iphone","Bueno",new BigDecimal("1200"), celulares);
		
		EntityManager em = JPAUtils.getEntityManager();
		ProductoDao productoDao = new ProductoDao(em);
		CategoriaDao categoriaDao = new CategoriaDao(em);
		
		em.getTransaction().begin();
		
		categoriaDao.guardar(celulares);
		productoDao.guardar(celular);
		productoDao.guardar(celular2);
		
		em.getTransaction().commit();
		em.close();
	}

}
