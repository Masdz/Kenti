package kenti.kaktia.com.kenti.adaptadores;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

@SuppressLint("AppCompatCustomView")
public class MultiSpinner extends Spinner{
    String items[]=new String[]{""};
    boolean selected[]=new boolean[]{false};
    String actual="";
    Context contexto;
    boolean cambiado=false;

    public MultiSpinner(Context context) {
        super(context);
    }

    public MultiSpinner(Context context, int mode) {
        super(context, mode);
    }

    public MultiSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MultiSpinner(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MultiSpinner(Context context, AttributeSet attrs, int defStyleAttr, int mode) {
        super(context, attrs, defStyleAttr, mode);
    }


    @Override
    public boolean performClick() {
        AlertDialog.Builder alerta=new AlertDialog.Builder(contexto);
        alerta.setMultiChoiceItems(items, selected, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                selected[i]=b;
            }
        });
        alerta.setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                aceptar();
                dialogInterface.cancel();
            }
        });
        alerta.show();
        return true;
    }

    public void aceptar(){
        String val="";
        for(int i=0;i<items.length;i++){
            if(selected[i]){
                val+=items[i]+",";
            }
            actual=val.length()>1?val.substring(0,val.length()-1):"";
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(contexto,android.R.layout.simple_spinner_item,new String[]{actual});
            setAdapter(adapter);
            cambiado=true;
        }
    }

    public void setItems(Context c,String[] items,String defecto){
        this.contexto=c;
        this.items=items;
        this.actual=defecto;
        selected=new boolean[this.items.length];
        for(int i=0;i<selected.length;i++){
            selected[i]=false;
        }
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(contexto,android.R.layout.simple_spinner_item,new String[]{actual});
        setAdapter(adapter);
    }

    public String getValue(){
        return actual;
    }

    public StatusMultispinner getStatus(){
        StatusMultispinner status=new StatusMultispinner();
        status.setActual(actual);
        status.setItems(items);
        status.setSelected(selected);
        status.setCambiado(cambiado);
        return status;
    }

    public void setStatus(Context c,StatusMultispinner status){
        setItems(c,status.getItems(),status.getActual());
        this.selected=status.getSelected();
        cambiado=status.cambiado;
    }

    public boolean getCambiado(){
        return cambiado;
    }

}