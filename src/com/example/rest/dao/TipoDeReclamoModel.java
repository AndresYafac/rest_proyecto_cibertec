package com.example.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;
import com.example.rest.entidades.TipoDeReclamo;
import com.example.rest.util.MySqlDBConexion;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class TipoDeReclamoModel {
	
	private static final Log log = LogFactory.getLog(TipoDeReclamoModel.class);

	public List<TipoDeReclamo>listartipoReclamoTodos(){
		Connection conn = null;
		PreparedStatement pstm= null;
		ResultSet rs = null;
		
		List<TipoDeReclamo> lista= new ArrayList<TipoDeReclamo>();
		try {
			String sql = "select *  from tiporeclamo";
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			TipoDeReclamo bean = null;
			while(rs.next()) {
				bean = new TipoDeReclamo();
				bean.setIdTipo(rs.getInt(1));
				bean.setDescripcion(rs.getString(2));
				bean.setEstado(rs.getString(3));
				bean.setFecha(rs.getString(4));
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
	
	public int insertatipoReclamo(TipoDeReclamo obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into tiporeclamo values(null,?,?,?)";
			conn= MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getDescripcion());
			pstm.setString(2, obj.getEstado());
			pstm.setString(3, obj.getFecha());
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

	public int actualizatipoReclamo(TipoDeReclamo obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "update tiporeclamo set descripcion =?, estado =?,fecha =? where idtipoReclamo =? ";
			conn = MySqlDBConexion.getConexion();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getDescripcion());
			pstm.setString(2, obj.getEstado());
			pstm.setString(3, obj.getFecha());
			pstm.setInt(4, obj.getIdTipo());
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
	
	public int eliminatipoReclamo(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "delete from tiporeclamo where idtipoReclamo =?";
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
	
	


