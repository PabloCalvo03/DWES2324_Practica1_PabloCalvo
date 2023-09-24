package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import com.dao.PokemonDAO;
import com.model.Pokemon;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CreatePokemonServlet
 */
public class CreatePokemonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreatePokemonController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	    
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PokemonDAO pokemonDao = new PokemonDAO();
		
	    String nombre = request.getParameter("nombre");
	    String tipo1 = request.getParameter("tipo1");
	    String tipo2 = request.getParameter("tipo2");
	    Float altura = Float.parseFloat(request.getParameter("altura"));
	    Float peso = Float.parseFloat(request.getParameter("peso"));

	    Pokemon pokemon = new Pokemon(nombre, tipo1, tipo2, altura, peso);
	    
	    pokemonDao.createPokemon(pokemon);
	    
	    //Voy a la ruta list
	    response.sendRedirect("./list");
	}
	
	

}
