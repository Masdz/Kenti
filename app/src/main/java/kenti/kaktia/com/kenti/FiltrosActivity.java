package kenti.kaktia.com.kenti;

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

import conexion.Filtro;

public class FiltrosActivity extends AppCompatActivity {
    Filtro filtro;
    ArrayAdapter<String> adaptadores[];
    Spinner spfiltros[];
    String tipos[];//get tipos
    String marcas[];//get marcas
    String etiquetas[];//get etiquetas
    String estilos[]={"","Formal","Formal-Casual","Casual","Deportivo"};
    String tallas[];//get tallas
    String poblacion[]={"","Bebe","Niño","Joven-Adulto"};
    String genero[]={"","Mujer","Hombre","Unisex"};
    int respondido=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtros);
        spfiltros=new Spinner[]{
                findViewById(R.id.filtrosSPTipo),
                findViewById(R.id.filtrosSPMarca),
                findViewById(R.id.filtrosSPEtiquetas),
                findViewById(R.id.filtrosSPEstilo),
                findViewById(R.id.filtrosSPTalla),
                findViewById(R.id.filtrosSPPoblacion),
                findViewById(R.id.filtrosSPGenero)
        };
        adaptadores=new ArrayAdapter[spfiltros.length];

        ((Button)findViewById(R.id.filtrosbotonaceptar)).setOnClickListener(onClickAceptar);

    }

    View.OnClickListener onClickAceptar=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent data=new Intent();
            data.putExtra("filtro",filtro);
            setResult(RESULT_OK,data);
            finish();
        }
    };

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    Response.Listener tiposListener=new Response.Listener() {
        @Override
        public void onResponse(Object response) {
            
        }
    };
}
