package kenti.kaktia.com.kenti.adaptadores;

import android.os.Parcel;
import android.os.Parcelable;

public class Filtro implements Parcelable{
    private int posEdad;
    private int posGenero;
    private int posEstilo;
    private int posTalla;
    private int posTemporada;
    private int posTipo;

    public Filtro() {;
        this.posEdad=0;
        this.posGenero=0;
        this.posEstilo=0;
        this.posTalla=0;
        this.posTemporada=0;
        this.posTipo=0;
    }

    public Filtro(int posEdad, int posGenero, int posEstilo, int posTalla, int posTemporada, int posTipo) {
        this.posEdad = posEdad;
        this.posGenero = posGenero;
        this.posEstilo = posEstilo;
        this.posTalla = posTalla;
        this.posTemporada = posTemporada;
        this.posTipo = posTipo;
    }

    protected Filtro(Parcel in) {
        posEdad = in.readInt();
        posGenero = in.readInt();
        posEstilo = in.readInt();
        posTalla = in.readInt();
        posTemporada = in.readInt();
        posTipo = in.readInt();
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

    public int getPosEdad() {
        return posEdad;
    }

    public void setPosEdad(int posEdad) {
        this.posEdad = posEdad;
    }

    public int getPosGenero() {
        return posGenero;
    }

    public void setPosGenero(int posGenero) {
        this.posGenero = posGenero;
    }

    public int getPosEstilo() {
        return posEstilo;
    }

    public void setPosEstilo(int posEstilo) {
        this.posEstilo = posEstilo;
    }

    public int getPosTalla() {
        return posTalla;
    }

    public void setPosTalla(int posTalla) {
        this.posTalla = posTalla;
    }

    public int getPosTemporada() {
        return posTemporada;
    }

    public void setPosTemporada(int posTemporada) {
        this.posTemporada = posTemporada;
    }

    public int getPosTipo() {
        return posTipo;
    }

    public void setPosTipo(int posTipo) {
        this.posTipo = posTipo;
    }

    @Override
    public int describeContents() {
        return 0;
    }
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(posEdad);
        parcel.writeInt(posGenero);
        parcel.writeInt(posEstilo);
        parcel.writeInt(posTalla);
        parcel.writeInt(posTemporada);
        parcel.writeInt(posTipo);
    }
}
