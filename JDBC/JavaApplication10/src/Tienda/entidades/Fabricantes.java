/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Tienda.entidades;

/**
 *
 * @author AlejaDevelops
 */
public class Fabricantes {
    private int codigo;
    private String nombre;

    public Fabricantes() {
    }
    
    

    public Fabricantes(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Fabricantes{" + "codigo=" + codigo + ", nombre=" + nombre + '}';
    }
    
    
    
}
