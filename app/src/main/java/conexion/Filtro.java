package conexion;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Filtro implements Parcelable{
    private String tipo="Pantalon";
    private String marca;
    private String etiquetas="ajustada,Joven-adulto,estampada";
    private String estilo;
    private String tallas;
    private String poblacion;
    private String genero;

    public Filtro() {
        this.tipo = "Pantalon";
        this.marca = "";
        this.etiquetas = "ajustada,Joven-adulto,estampada";
        this.estilo = "";
        this.tallas = "";
        this.poblacion = "";
        this.genero = "";
    }

    public Filtro(String tipo, String marca, String etiquetas, String estilo, String tallas, String poblacion, String genero) {
        this.tipo = tipo;
        this.marca = marca;
        this.etiquetas = etiquetas;
        this.estilo = estilo;
        this.tallas = tallas;
        this.poblacion = poblacion;
        this.genero = genero;
    }

    protected Filtro(Parcel in) {
        tipo = in.readString();
        marca = in.readString();
        etiquetas = in.readString();
        estilo = in.readString();
        tallas = in.readString();
        poblacion = in.readString();
        genero = in.readString();
    }

    public static final Creator<Filtro> CREATOR = new Creator<Filtro>() {
        @Override
        public Filtro createFromParcel(Parcel in) {
            return new Filtro(in);
        }

        @Override
        public Filtro[] newArray(int size) {
            return new Filtro[size];
        }
    };

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getTallas() {
        return tallas;
    }

    public void setTallas(String tallas) {
        this.tallas = tallas;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getParams(){
        String mapa = "{";
        mapa+="\"tipo\":\""+tipo+"\",";
        mapa+="\"marca\":\""+marca+"\",";
        mapa+="\"etiquetas\":\""+etiquetas+"\",";
        mapa+="\"estilo\":\""+estilo+"\",";
        mapa+="\"tallas\":\""+tallas+"\",";
        mapa+="\"poblacion\":\""+poblacion+"\",";
        mapa+="\"genero\":\""+genero+"\"}";
        return mapa;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(tipo);
        parcel.writeString(marca);
        parcel.writeString(etiquetas);
        parcel.writeString(estilo);
        parcel.writeString(tallas);
        parcel.writeString(poblacion);
        parcel.writeString(genero);
    }
}
