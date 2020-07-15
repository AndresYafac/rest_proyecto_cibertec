package com.example.rest.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.entidades.Cliente;
import com.example.rest.entidades.TipoDeReclamo;
import com.example.rest.entidades.Marca;
import com.example.rest.entidades.Producto;
import com.example.rest.dao.TipoDeReclamoModel;
import com.example.rest.dao.MarcaModel;
import com.example.rest.dao.ClienteModel;
import com.example.rest.dao.ProductoModel;

@Path("/servicios")
@Produces({ MediaType.APPLICATION_JSON })
@Consumes({ MediaType.APPLICATION_JSON })
public class ServicioRest {
	private static final Log log = LogFactory.getLog(ServicioRest.class);

	private TipoDeReclamoModel daoTipo = new TipoDeReclamoModel();
	private ClienteModel daoCli = new ClienteModel();
	private ProductoModel daoPro = new ProductoModel();
	private MarcaModel daoMarca = new MarcaModel();


	// Crud de tipoReclamo
	@GET
	@Path("/tiporeclamo")
	public Response listartipoReclamoTodos() {
		log.info("listar tiporeclamo rest ");
		return Response.ok(daoTipo.listartipoReclamoTodos()).build();
	}

	@POST
	@Path("/tiporeclamo")
	public Response registratipoReclamo(TipoDeReclamo obj) {
		log.info("Registra tiporeclamo " + obj.getIdTipo());
		if (daoTipo.insertatipoReclamo(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@PUT
	@Path("/tiporeclamo")
	public Response atualizatipoReclamo(TipoDeReclamo obj) {
		log.info("Actualiza tiporeclamo " + obj.getIdTipo());
		if (daoTipo.actualizatipoReclamo(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@DELETE
	@Path("/tiporeclamo/{idTipo}")
	public Response eliminatipoReclamo(@PathParam("idTipo") int id) {
		log.info("Elimina tiporeclamo " + id);
		if (daoTipo.eliminatipoReclamo(id) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	
	// Crud de Cliente
	
	@GET
	@Path("/cliente")
	public Response listarclienteTodos() {
		log.info("listar cliente rest ");
		return Response.ok(daoCli.listarclienteTodos()).build();
	}
	@POST
	@Path("/cliente")
	public Response registraCliente(Cliente obj) {
		log.info("Registra cliente " + obj.getIdCliente());
		if (daoCli.insertacliente(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	@PUT
	@Path("/cliente")
	public Response atualizatipocliente(Cliente obj) {
		log.info("Actualiza cliente " + obj.getIdCliente());
		if (daoCli.actualizacliente(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}
	@DELETE
	@Path("/cliente/{idCliente}")
	public Response eliminacliente(@PathParam("idCliente") int id) {
		log.info("Elimina cliente " + id);
		if (daoCli.eliminacliente(id) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

// Crud de producto

@GET
@Path("/producto")
public Response listarproductoTodos() {
	log.info("listar producto rest ");
	return Response.ok(daoPro.listarproductoTodos()).build();
}
@POST
@Path("/producto")
public Response registraproducto(Producto obj) {
	log.info("Registra producto " + obj.getIdProducto());
	if (daoPro.insertaproducto(obj) > 0)
		return Response.ok().build();
	else
		return Response.notModified().build();
}
@PUT
@Path("/producto")
public Response atualizatipoproducto(Producto obj) {
	log.info("Actualiza producto " + obj.getIdProducto());
	if (daoPro.actualizaproducto(obj) > 0)
		return Response.ok().build();
	else
		return Response.notModified().build();
}
@DELETE
@Path("/producto/{idproducto}")
public Response eliminaproducto(@PathParam("idProducto") int id) {
	log.info("Elimina producto " + id);
	if (daoPro.eliminaproducto(id) > 0)
		return Response.ok().build();
	else
		return Response.notModified().build();
}
//Crud de Marca
	@GET
	@Path("/marca")
	public Response listarMarcaTodos() {
		log.info("listars marca rest ");
		return Response.ok(daoMarca.listarMarcaTodos()).build();
	}

	@POST
	@Path("/marca")
	public Response registraMarca(Marca obj) {
		log.info("Registra marca " + obj.getIdMarca());
		if (daoMarca.insertaMarca(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@PUT
	@Path("/marca")
	public Response atualizaMarca(Marca obj) {
		log.info("Actualiza marca " + obj.getIdMarca());
		if (daoMarca.actualizaMarca(obj) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

	@DELETE
	@Path("/marca/{idMarca}")
	public Response eliminaMarca(@PathParam("idMarca") int id) {
		log.info("Elimina usuario " + id);
		if (daoMarca.eliminaMarca(id) > 0)
			return Response.ok().build();
		else
			return Response.notModified().build();
	}

}