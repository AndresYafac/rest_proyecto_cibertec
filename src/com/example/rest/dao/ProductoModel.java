package com.example.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.entidades.Producto;
import com.example.rest.util.MySqlDBConexion;

public class ProductoModel {
private static final Log log = LogFactory.getLog(ProductoModel.class);
	
	public List<Producto>listarproductoTodos(){
		Connection conn = null;
		PreparedStatement pstm= null;
		ResultSet rs = null;
		
		List<Producto> lista= new ArrayList<Producto>();
		try {
			String sql = "select * from producto";
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			Producto bean = null;
			while(rs.next()) {
				bean = new Producto();
				bean.setIdProducto(rs.getInt(1));
				bean.setNombre(rs.getString(2));
				bean.setSerie(rs.getString(3));
				bean.setPrecio(rs.getString(4));
				bean.setStock(rs.getString(5));
				bean.setIdMarca(rs.getInt(6));
				bean.setIdPais(rs.getInt(7));
				bean.setIdProveedor(rs.getInt(8));
				lista.add(bean);
			}
		}catch(Exception e) {
			log.info(e);
		}finally {
			try {
				if(rs !=null)rs.close();
				if(pstm !=null)pstm.close();
				if(conn !=null)conn.close();
			}catch(SQLException e) {}
		}
		return lista;
		
		}
	public int insertaproducto(Producto obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into producto values(null,?,?,?,?,?,?,?)";
			conn= MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getSerie());
			pstm.setString(3, obj.getPrecio());
			pstm.setString(4, obj.getStock());
			pstm.setInt(5, obj.getIdMarca());
			pstm.setInt(6, obj.getIdPais());
			pstm.setInt(7, obj.getIdProveedor());
			log.info(pstm);
			salida = pstm.executeUpdate();
		}catch (Exception e) {
			log.info(e);
		}finally {
			try {
				if(pstm != null)pstm.close();			
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
		
	}
	public int actualizaproducto(Producto obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "update  cliente set nombre=?,serie=?,precio=?,stock=?,idmarca=?,idpais=?,idproveedor=? where idproducto=?";
			conn= MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, obj.getIdProducto());
			pstm.setString(1, obj.getNombre());
			pstm.setString(2, obj.getSerie());
			pstm.setString(3, obj.getPrecio());
			pstm.setString(4, obj.getStock());
			pstm.setInt(5, obj.getIdMarca());
			pstm.setInt(6, obj.getIdPais());
			pstm.setInt(7, obj.getIdProveedor());
			log.info(pstm);
			
			salida = pstm.executeUpdate();
		}catch (Exception e) {
			log.info(e);
		}finally {
			try {
				if(pstm != null)pstm.close();			
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
		
	}
	public int eliminaproducto(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "delete from producto where idproducto =?";
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			log.info(pstm);
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida; 
	}
}
