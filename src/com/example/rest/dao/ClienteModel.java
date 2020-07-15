package com.example.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.example.rest.entidades.Cliente;
import com.example.rest.util.MySqlDBConexion;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ClienteModel {
	
	private static final Log log = LogFactory.getLog(ClienteModel.class);
	
	public List<Cliente>listarclienteTodos(){
		Connection conn = null;
		PreparedStatement pstm= null;
		ResultSet rs = null;
		
		List<Cliente> lista= new ArrayList<Cliente>();
		try {
			String sql = "select * from cliente";
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			Cliente bean = null;
			while(rs.next()) {
				bean = new Cliente();
				bean.setIdCliente(rs.getInt(1));
				bean.setNombres(rs.getString(2));
				bean.setApellidos(rs.getString(3));
				bean.setDni(rs.getString(4));
				bean.setCorreo(rs.getString(5));
				bean.setFechaReg(rs.getString(6));
				bean.setLogin(rs.getString(7));
				bean.setPassword(rs.getString(8));
				bean.setDireccion(rs.getString(9));
				bean.setEstado(rs.getString(10));
				bean.setIdUbigeo(rs.getInt(11));
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
	public int insertacliente(Cliente obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into cliente values(null,?,?,?,?,?,?,?,?,?,?)";
			conn= MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNombres());
			pstm.setString(2, obj.getApellidos());
			pstm.setString(3, obj.getDni());
			pstm.setString(4, obj.getCorreo());
			pstm.setString(5, obj.getFechaReg());
			pstm.setString(6, obj.getLogin());
			pstm.setString(7, obj.getPassword());
			pstm.setString(8, obj.getDireccion());
			pstm.setString(9, obj.getEstado());
			pstm.setInt(10, obj.getIdUbigeo());
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
	public int actualizacliente(Cliente obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "update  cliente set nombres=?,apellidos=?,dni=?,correo=?,fecha=?,login=?,password=?,direccion=?,estado=?,idubigeo=? where idcliente=?";
			conn= MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, obj.getIdCliente());
			pstm.setString(2, obj.getNombres());
			pstm.setString(3, obj.getApellidos());
			pstm.setString(4, obj.getDni());
			pstm.setString(5, obj.getCorreo());
			pstm.setString(6, obj.getFechaReg());
			pstm.setString(7, obj.getLogin());
			pstm.setString(8, obj.getPassword());
			pstm.setString(9, obj.getDireccion());
			pstm.setString(10, obj.getEstado());
			pstm.setInt(11, obj.getIdUbigeo());
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
	public int eliminacliente(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "delete from cliente where idcliente =?";
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
