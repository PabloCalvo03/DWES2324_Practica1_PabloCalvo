package com.controller;

import java.io.IOException;

import com.dao.PokemonDAO;
import com.model.Pokemon;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdatePokemonController
 */
public class UpdatePokemonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePokemonController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer idParam = Integer.parseInt(request.getParameter("id"));
        
        PokemonDAO pokemonDao = new PokemonDAO();
        
        //Consigo el Pokemon en concreto
        Pokemon pokemon = pokemonDao.getPokemonById(idParam);
        
        if (idParam != null) {
            try {
                Integer pokemonId = pokemon.getId();
                
                String nombrePokemon = pokemon.getNombre(); 
                String tipo1Pokemon = pokemon.getTipo1(); 
                String tipo2Pokemon = pokemon.getTipo2(); 
                Float alturaPokemon = pokemon.getAltura(); 
                Float pesoPokemon = pokemon.getPeso(); 
                
                request.setAttribute("id", pokemonId);
                request.setAttribute("nombre", nombrePokemon);
                request.setAttribute("tipo1", tipo1Pokemon);
                request.setAttribute("tipo2", tipo2Pokemon);
                request.setAttribute("altura", alturaPokemon);
                request.setAttribute("peso", pesoPokemon);
                
                //Con esto consigo llevarme los datos a la URL para luego capturarlos con JavaScript en el html y poblar los campos.
                response.sendRedirect("edit.html?id=" + pokemonId +
                        "&nombre=" + nombrePokemon +
                        "&tipo1=" + tipo1Pokemon +
                        "&tipo2=" + tipo2Pokemon +
                        "&altura=" + alturaPokemon +
                        "&peso=" + pesoPokemon);
            } catch (NumberFormatException e) {
                response.getWriter().println("ID de Pokémon no válido.");
            }
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PokemonDAO pokemonDao = new PokemonDAO();
		
		Integer id = Integer.parseInt(request.getParameter("id"));
	    String nombre = request.getParameter("nombre");
	    String tipo1 = request.getParameter("tipo1");
	    String tipo2 = request.getParameter("tipo2");
	    Float altura = Float.parseFloat(request.getParameter("altura"));
	    Float peso = Float.parseFloat(request.getParameter("peso"));

	    Pokemon pokemon = new Pokemon(id, nombre, tipo1, tipo2, altura, peso);

	    //Actualizo el pokemon
	    pokemonDao.updatePokemon(pokemon);
	    
	    //Vuelvo a la ruta list
	    response.sendRedirect("./list");
	}

}
