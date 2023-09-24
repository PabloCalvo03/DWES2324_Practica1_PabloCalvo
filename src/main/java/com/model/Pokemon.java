package com.model;

public class Pokemon {
	
    private Integer id;
    private String nombre;
    private String tipo1;
    private String tipo2;
    private Float altura;
    private Float peso;
    
	public Pokemon() {
		
	}

    public Pokemon(String nombre, String tipo1, String tipo2, Float altura, Float peso) {
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.altura = altura;
        this.peso = peso;
    }
    public Pokemon(Integer id, String nombre, String tipo1, String tipo2, Float altura, Float peso) {
    	this.id = id;
        this.nombre = nombre;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.altura = altura;
        this.peso = peso;
    }

    public Pokemon(String nombre, String tipo1, String tipo2) {
		this.nombre = nombre;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
	}
    
    public Pokemon(Integer id) {
		this.id = id;
	}
    

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }

    public Float getAltura() {
        return altura;
    }

    public void setAltura(Float altura) {
        this.altura = altura;
    }

    public Float getPeso() {
        return peso;
    }

    public void setPeso(Float peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Pokemon [id=" + id + ", nombre=" + nombre + ", tipo1=" + tipo1 + ", tipo2=" + tipo2 + ", altura=" + altura
                + ", peso=" + peso + "]";
    }
}

