package kenti.kaktia.com.kenti.adaptadores;

import kenti.kaktia.com.kenti.R;
public class CuadriculaItem {
    private String titulo;
    private String descripcion;
    private String imagenId;
    private long itemId;

    public CuadriculaItem() {
        this.titulo = "Sin Titulo";
        this.descripcion = "Sin Descripcion";
        this.imagenId = null;
        itemId=0;
    }

    public CuadriculaItem(int itemId,String titulo, String descripcion, String imagenId) {
        this.itemId=itemId;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagenId = imagenId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenId() {
        return imagenId;
    }

    public void setImagenId(String imagenId) {
        this.imagenId = imagenId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }
}
