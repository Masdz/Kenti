package kenti.kaktia.com.kenti.adaptadores;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

public class StatusMultispinner implements Parcelable{
    private String[] items=new String[]{""};
    private boolean[] selected=new boolean[]{false};
    private String actual="";
    boolean cambiado=false;

    public StatusMultispinner() {
        this.items = new String[]{};
        this.selected = new boolean[]{};
        this.actual = "";
    }

    public StatusMultispinner(String[] items, boolean[] selected, String actual) {
        this.items = items;
        this.selected = selected;
        this.actual = actual;
    }

    protected StatusMultispinner(Parcel in) {
        items = in.createStringArray();
        selected = in.createBooleanArray();
        actual = in.readString();
        cambiado = in.readByte() != 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(items);
        dest.writeBooleanArray(selected);
        dest.writeString(actual);
        dest.writeByte((byte) (cambiado ? 1 : 0));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<StatusMultispinner> CREATOR = new Creator<StatusMultispinner>() {
        @Override
        public StatusMultispinner createFromParcel(Parcel in) {
            return new StatusMultispinner(in);
        }

        @Override
        public StatusMultispinner[] newArray(int size) {
            return new StatusMultispinner[size];
        }
    };

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    public boolean[] getSelected() {
        return selected;
    }

    public void setSelected(boolean[] selected) {
        this.selected = selected;
    }

    public String getActual() {
        return actual;
    }

    public void setActual(String actual) {
        this.actual = actual;
    }

    public boolean isCambiado() {
        return cambiado;
    }

    public void setCambiado(boolean cambiado) {
        this.cambiado = cambiado;
    }

}
