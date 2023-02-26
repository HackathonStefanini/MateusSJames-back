package com.stefanini.resources;

import com.stefanini.dto.JogadorDTO;
import com.stefanini.entity.Jogador;
import com.stefanini.handlers.BadRequestHandler;
import com.stefanini.service.JogadorService;

import java.util.Map;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/jogador")
public class JogadorResource {

    @Inject
    JogadorService jogadorService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response salvar(JogadorDTO jogador) throws BadRequestHandler {
    	try {
    		JogadorDTO jogadorDto = jogadorService.salvar(jogador);
    		return Response.status(Response.Status.CREATED).entity(jogadorDto).build();
    	} catch (BadRequestHandler e) {
    		 return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    	}
    }
    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(Map<String, ?> body) throws BadRequestHandler {
    	try {
    		JogadorDTO jogadorDto = jogadorService.login(body);
    		return Response.status(Response.Status.CREATED).entity(jogadorDto).build();
    	} catch (BadRequestHandler e) {
   		 	return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
    	}
    }
	
}
