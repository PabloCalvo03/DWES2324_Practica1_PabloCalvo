package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.dao.PokemonDAO;
import com.model.Pokemon;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormBBDDServlet
 */

public class ListPokemonsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ListPokemonsController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		PokemonDAO pokemonDao = new PokemonDAO();
		List<Pokemon> pokemons = pokemonDao.listPokemons();

		out.print("<!DOCTYPE html>");
		out.print("<html>");
		out.print("<head>");
		out.print("<meta charset='UTF-8'>");
		out.print("<title>Listar pokemons</title>");
		if(pokemons.size() == 0) {
			out.print("<h1>No hay ningun pokemon que mostrar</h1>");
		} else {
		for(Pokemon pokemon : pokemons) {
			out.print("<div>");
			out.print("<h1>Pokemon "+ pokemon.getId() +"</h1>");
			out.print(pokemon.getNombre() != null ? "<p>Nombre: " +pokemon.getNombre() + "</p>" : "");
			out.print(pokemon.getTipo1() != "" ? "<p>Tipo 1: " +pokemon.getTipo1() + "</p>" : "");
			out.print(pokemon.getTipo2() != "" ? "<p>Tipo 2: " +pokemon.getTipo2() + "</p>" : "");
			out.print(pokemon.getPeso() != null ? "<p>Peso: " +pokemon.getPeso() + "kg</p>" : "");
			out.print(pokemon.getAltura() != null ? "<p>Altura: " +pokemon.getAltura() + "m</p>" : "");
			out.println("<form action='delete' method='post'>");
			out.println("<input type='hidden' name='id' value='" + pokemon.getId() + "'>");
			out.println("<input type='submit' value='Eliminar Pokémon'>");
			out.println("</form> <br/>");
			
			out.println("<form action='update' method='get'>");
			out.println("<input type='hidden' name='id' value='" + pokemon.getId() + "'>");
			out.println("<input type='submit' value='Actualizar Pokémon'>");
			out.println("</form>");
			out.print("</div>");
			
		}}
		out.print("</body>");
		out.print("</html>");
		
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
