package conexion;

import java.util.HashMap;

public class Usuario {
    private int id;
    private String nombre;
    private String contrasenia;
    private String correo;

    public Usuario() {
        this.id = 0;
        this.nombre = "Desconocido";
        this.contrasenia = "Desconocida";
        this.correo = "Desconocido";
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

    public void setRandomId(){
        this.id= (int) (Math.random()*100000000);
    }

    public HashMap<String,String> getParams(){
        HashMap param=new HashMap<String,String>();
        param.put("id",id);
        param.put("usuario",nombre);
        param.put("correo",correo);
        param.put("contraseña",contrasenia);
        return param;
    }
}
