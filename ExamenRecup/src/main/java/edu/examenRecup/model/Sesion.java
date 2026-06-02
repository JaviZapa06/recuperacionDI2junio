package edu.examenRecup.model;

public class Sesion {

    private static User usuarioActual;

    public static User getUsuarioActual(){
        return usuarioActual;
    }

    public static User setUsuarioActual(User usuarioActual){
        Sesion.usuarioActual = usuarioActual;
    }

    public static void cerrarSesion(){
        usuarioActual = null;
    }
}
