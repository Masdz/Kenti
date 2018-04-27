package conexion;

import java.util.HashMap;

public class Usuario {
    private int id;
    private String nombre;
    private String contrasenia;
    private String correo;

    public Usuario() {
    }

    public Usuario(int id, String nombre, String contrasenia, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public HashMap<String,String> getJson(){
        HashMap param=new HashMap<String,String>();
        param.put("usuario",nombre);
        param.put("correo",correo);
        param.put("contrasenia",contrasenia);
        return param;
    }
}