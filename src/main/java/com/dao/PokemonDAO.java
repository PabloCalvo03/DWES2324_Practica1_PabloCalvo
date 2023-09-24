package com.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Pokemon;

public class PokemonDAO {
	
	static String url = "jdbc:mysql://localhost:3306/pokemon";
    static String usuario = "root";
    static String contraseña = "";
    
    public Pokemon getPokemonById(Integer idPokemon) {
    	Pokemon pokemon = new Pokemon();

    	try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String consulta = "SELECT * FROM pokemon WHERE id = ?";

            try (PreparedStatement stmt = conexion.prepareStatement(consulta)) {
                stmt.setInt(1, idPokemon);

                try (ResultSet resultSet = stmt.executeQuery()) {
                    if (resultSet.next()) {
                        pokemon.setId(resultSet.getInt("id"));
                        pokemon.setNombre(resultSet.getString("nombre"));
                        pokemon.setTipo1(resultSet.getString("tipo1"));
                        pokemon.setTipo2(resultSet.getString("tipo2"));
                        pokemon.setAltura(resultSet.getFloat("altura"));
                        pokemon.setPeso(resultSet.getFloat("peso"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pokemon;
    }
	
    public List<Pokemon> listPokemons() {
        List<Pokemon> pokemons = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return pokemons; 
        }

        try (
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            PreparedStatement stmt = conexion.prepareStatement("SELECT * FROM pokemon");
            ResultSet rs = stmt.executeQuery()
        ) {
            while (rs.next()) {
                Integer id = rs.getInt("id");
                String nombre = rs.getString("nombre");
                String tipo1 = rs.getString("tipo1");
                String tipo2 = rs.getString("tipo2");
                Float altura = rs.getFloat("altura");
                Float peso = rs.getFloat("peso");
                Pokemon pokemon = new Pokemon(id, nombre, tipo1, tipo2, altura, peso);
                pokemons.add(pokemon);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pokemons;
    }
    
    public Boolean createPokemon(Pokemon pokemon) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false; 
        }

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String consulta = "INSERT INTO pokemon (nombre, tipo1, tipo2, altura, peso) VALUES (?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = conexion.prepareStatement(consulta)) {
                stmt.setString(1, pokemon.getNombre());
                stmt.setString(2, pokemon.getTipo1());
                stmt.setString(3, pokemon.getTipo2());
                stmt.setDouble(4, pokemon.getAltura());
                stmt.setDouble(5, pokemon.getPeso());

                int filasAfectadas = stmt.executeUpdate();
                return filasAfectadas > 0; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }
    
    public Boolean deletePokemon(Pokemon pokemon) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false; 
        }
        Integer id = pokemon.getId();

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String consulta = "DELETE FROM pokemon WHERE id = ?";

            try (PreparedStatement stmt = conexion.prepareStatement(consulta)) {
                stmt.setInt(1, pokemon.getId());
                

                int filasAfectadas = stmt.executeUpdate();
                return filasAfectadas > 0; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }
    
    public Boolean updatePokemon(Pokemon pokemon) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false; 
        }

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            String consulta = "UPDATE pokemon SET nombre = ?, tipo1 = ?, tipo2 = ?, altura = ?, peso = ? WHERE id = ?";

            try (PreparedStatement stmt = conexion.prepareStatement(consulta)) {
                stmt.setString(1, pokemon.getNombre());
                stmt.setString(2, pokemon.getTipo1());
                stmt.setString(3, pokemon.getTipo2());
                stmt.setDouble(4, pokemon.getAltura());
                stmt.setDouble(5, pokemon.getPeso());
                stmt.setInt(6, pokemon.getId());

                int filasAfectadas = stmt.executeUpdate();
                return filasAfectadas > 0; 
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
    }

}
