package com.example.rest.entidades;

public class Producto {
	
	private int idProducto;
	private String Nombre;
	private String Serie;
	private String Precio;
	private String Stock;
	private int idMarca;
	private int idPais;
	private int idProveedor;
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getSerie() {
		return Serie;
	}
	public void setSerie(String serie) {
		Serie = serie;
	}
	public String getPrecio() {
		return Precio;
	}
	public void setPrecio(String precio) {
		Precio = precio;
	}
	public String getStock() {
		return Stock;
	}
	public void setStock(String stock) {
		Stock = stock;
	}
	public int getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(int idMarca) {
		this.idMarca = idMarca;
	}
	public int getIdPais() {
		return idPais;
	}
	public void setIdPais(int idPais) {
		this.idPais = idPais;
	}
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	
	
	
	
	

}
