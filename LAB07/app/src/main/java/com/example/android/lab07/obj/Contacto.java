package com.example.android.lab07.obj;

import java.io.Serializable;

/**
 * Created by ANDROID on 31/03/2016.
 */
public class Contacto implements Serializable{
    private String nombre;
    private String telefono;
    private String web;

    public Contacto(String nombre, String telefono, String web) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.web = web;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }
}
