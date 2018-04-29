package kenti.kaktia.com.kenti.adaptadores;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;

import kenti.kaktia.com.kenti.R;
@SuppressLint("ParcelCreator")
public class CuadriculaItem implements Parcelable {
    private String titulo;
    private String descripcion;
    private String imagenId;
    private long itemId;
    private Bitmap imagen;
    private float calificacion;

    public CuadriculaItem() {
        this.titulo = "Sin Titulo";
        this.descripcion = "Sin Descripcion";
        this.imagenId = null;
        this.itemId=0;
        this.imagen=null;
        this.calificacion=-1;
    }

    public CuadriculaItem(int itemId,String titulo, String descripcion, String imagenId, float calificacion) {
        this.itemId=itemId;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagenId = imagenId;
        this.imagen=null;
        this.calificacion=calificacion;
    }

    protected CuadriculaItem(Parcel in) {
        titulo = in.readString();
        descripcion = in.readString();
        imagenId = in.readString();
        itemId = in.readLong();
        imagen = in.readParcelable(Bitmap.class.getClassLoader());
        calificacion = in.readFloat();
    }

    public static final Creator<CuadriculaItem> CREATOR = new Creator<CuadriculaItem>() {
        @Override
        public CuadriculaItem createFromParcel(Parcel in) {
            return new CuadriculaItem(in);
        }

        @Override
        public CuadriculaItem[] newArray(int size) {
            return new CuadriculaItem[size];
        }
    };

    public Bitmap getImagen() {
        return imagen;
    }

    public void setImagen(Bitmap imagen) {
        this.imagen = imagen;
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

    public float getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(float calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(titulo);
        parcel.writeString(descripcion);
        parcel.writeString(imagenId);
        parcel.writeLong(itemId);
        parcel.writeParcelable(imagen, i);
        parcel.writeFloat(calificacion);
    }
}
