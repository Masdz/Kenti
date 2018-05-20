package kenti.kaktia.com.kenti;

import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.android.volley.Response;

import org.json.JSONArray;
import org.json.JSONException;

import conexion.Conexion;
import conexion.Filtro;
import kenti.kaktia.com.kenti.adaptadores.MultiSpinner;
import kenti.kaktia.com.kenti.adaptadores.StatusMultispinner;

public class FiltrosActivity extends AppCompatActivity {
    Filtro filtro;
    ArrayAdapter<String> adaptadores[];
    Context contexto=this;
    Conexion conexion;

    String tipos[];//get tipos
    String marcas[];//get marcas
    String etiquetas[];//get etiquetas
    String estilos[]={"Formal","Formal-Casual","Casual","Deportivo"};
    String tallas[];//get tallas
    String poblacion[]={"Bebe","Niño","Joven-Adulto"};
    String genero[]={"Mujer","Hombre","Unisex"};
    MultiSpinner SPTipos;
    MultiSpinner SPMarcas;
    MultiSpinner SPEtiquetas;
    MultiSpinner SPEstilos;
    MultiSpinner SPTallas;
    MultiSpinner SPPoblacion;
    MultiSpinner SPGenero;
    int respondido=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtros);
        String url=getIntent().getExtras().getString("url");
        conexion=new Conexion(contexto,url);
        SPTipos =(MultiSpinner) findViewById(R.id.filtrosSPTipo);
        SPMarcas =(MultiSpinner) findViewById(R.id.filtrosSPMarca);
        SPEtiquetas =(MultiSpinner) findViewById(R.id.filtrosSPEtiquetas);
        SPEstilos =(MultiSpinner) findViewById(R.id.filtrosSPEstilo);
        SPTallas =(MultiSpinner) findViewById(R.id.filtrosSPTalla);
        SPPoblacion =(MultiSpinner) findViewById(R.id.filtrosSPPoblacion);
        SPGenero =(MultiSpinner) findViewById(R.id.filtrosSPGenero);
        if(savedInstanceState==null){
            filtro=getIntent().getExtras().getParcelable("filtro");
            SPTipos.setEnabled(false);
            SPMarcas.setEnabled(false);
            SPEtiquetas.setEnabled(false);
            SPEstilos.setItems(this,estilos,filtro.getEstilo());
            SPTallas.setEnabled(false);
            SPPoblacion.setItems(this,poblacion,filtro.getPoblacion());
            SPGenero.setItems(this,genero,filtro.getGenero());

            conexion.get("/Prendatipo/",tiposListener);
            conexion.get("/Marca/",marcasListener);
            conexion.get("/Etiqueta/",etiquetasListener);
            conexion.get("/Talla/",tallasListener);
        }
        ((Button)findViewById(R.id.filtrosbotonaceptar)).setOnClickListener(onClickAceptar);
    }


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        SPTipos.setStatus(contexto,(StatusMultispinner) savedInstanceState.getParcelable("sptipos"));
        SPMarcas.setStatus(contexto,(StatusMultispinner) savedInstanceState.getParcelable("spmarcas"));
        SPEtiquetas.setStatus(contexto,(StatusMultispinner) savedInstanceState.getParcelable("spetiquetas"));
        SPEstilos.setStatus(contexto,(StatusMultispinner) savedInstanceState.getParcelable("spestilos"));
        SPTallas.setStatus(contexto,(StatusMultispinner) savedInstanceState.getParcelable("sptallas"));
        SPPoblacion.setStatus(contexto,(StatusMultispinner) savedInstanceState.getParcelable("sppoblacion"));
        SPGenero.setStatus(contexto,(StatusMultispinner) savedInstanceState.getParcelable("spgenero"));
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("sptipos",SPTipos.getStatus());
        outState.putParcelable("spmarcas",SPMarcas.getStatus());
        outState.putParcelable("spetiquetas",SPEtiquetas.getStatus());
        outState.putParcelable("spestilos",SPEstilos.getStatus());
        outState.putParcelable("sptallas",SPTallas.getStatus());
        outState.putParcelable("sppoblacion",SPPoblacion.getStatus());
        outState.putParcelable("spgenero",SPGenero.getStatus());
        Log.d("Guardar datos2", "onSaveInstanceState: datos guardados");
    }

    View.OnClickListener onClickAceptar=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(SPTipos.getCambiado()){filtro.setTipo(SPTipos.getValue());}
            if(SPMarcas.getCambiado()){filtro.setMarca(SPMarcas.getValue());}
            if(SPEtiquetas.getCambiado()){filtro.setEtiquetas(SPEtiquetas.getValue());}
            if(SPEstilos.getCambiado()){filtro.setEstilo(SPEstilos.getValue());}
            if(SPTallas.getCambiado()){filtro.setTallas(SPTallas.getValue());}
            if(SPPoblacion.getCambiado()){filtro.setPoblacion(SPPoblacion.getValue());}
            Intent data=new Intent();
            data.putExtra("filtro",filtro);
            setResult(RESULT_OK,data);
            finish();
        }
    };

    Response.Listener tiposListener=new Response.Listener() {
        @Override
        public void onResponse(Object response) {
            JSONArray datos= (JSONArray) response;
            tipos=new String[datos.length()];
            for(int i=0;i<datos.length();i++){
                try {
                    tipos[i]=datos.getString(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            SPTipos.setItems(contexto,tipos,filtro.getTipo());
            SPTipos.setEnabled(true);
        }
    };
    Response.Listener marcasListener=new Response.Listener() {
        @Override
        public void onResponse(Object response) {
            JSONArray datos= (JSONArray) response;
            marcas=new String[datos.length()];
            for(int i=0;i<datos.length();i++){
                try {
                    marcas[i]=datos.getString(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            SPMarcas.setItems(contexto,marcas,filtro.getMarca());
            SPMarcas.setEnabled(true);
        }
    };
    Response.Listener etiquetasListener=new Response.Listener() {
        @Override
        public void onResponse(Object response) {
            JSONArray datos= (JSONArray) response;
            etiquetas=new String[datos.length()];
            for(int i=0;i<datos.length();i++){
                try {
                    etiquetas[i]=datos.getString(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            SPEtiquetas.setItems(contexto,etiquetas,filtro.getEtiquetas());
            SPEtiquetas.setEnabled(true);
        }
    };
    Response.Listener tallasListener=new Response.Listener() {
        @Override
        public void onResponse(Object response) {
            JSONArray datos= (JSONArray) response;
            tallas=new String[datos.length()];
            for(int i=0;i<datos.length();i++){
                try {
                    tallas[i]=datos.getString(i);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
            SPTallas.setItems(contexto,tallas,filtro.getTallas());
            SPTallas.setEnabled(true);
        }
    };

}
