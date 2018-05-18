package conexion;

import java.util.HashMap;

public class Puntaje {
    private int id;
    private int idUsuario;
    private int idPrenda; //*
    private String puntaje; //*
    private String comentario;
    private String adquirido;

    public Puntaje() {
    }

    public Puntaje(int id, int idUsuario, int idPrenda, String puntaje, String comentario, String adquirido) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idPrenda = idPrenda;
        this.puntaje = puntaje;
        this.comentario = comentario;
        this.adquirido = adquirido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPrenda() {
        return idPrenda;
    }

    public void setIdPrenda(int idPrenda) {
        this.idPrenda = idPrenda;
    }

    public String getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(String puntaje) {
        this.puntaje = puntaje;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getAdquirido() {
        return adquirido;
    }

    public void setAdquirido(String adquirido) {
        this.adquirido = adquirido;
    }

    public HashMap<String,String> getParams(){
        HashMap<String,String> mapa=new HashMap<>();
        mapa.put("id",id+"");
        mapa.put("idUsuario",idUsuario+"");
        mapa.put("idPrenda",idPrenda+"");
        mapa.put("puntaje",puntaje);
        mapa.put("comentario",comentario);
        mapa.put("adquirido",adquirido);
        return mapa;
    }
}
