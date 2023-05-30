package com.henrry.spring.models;

public class Jugador {
  private String nombre;
  private int numero;

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setNumero(int numero) {
    this.numero = numero;
  }

  public String getNombre() {
    return nombre;
  }

  public int getNumero() {
    return numero;
  }

  public Jugador(String nombre, int numero) {
    this.setNombre(nombre);
    this.setNumero(numero);
  }

}
