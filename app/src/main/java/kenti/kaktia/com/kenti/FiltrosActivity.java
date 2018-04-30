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

import kenti.kaktia.com.kenti.adaptadores.Filtro;

public class FiltrosActivity extends AppCompatActivity {
    Filtro filtro;
    Spinner spEdad;
    Spinner spGenero;
    Spinner spEstilo;
    Spinner spTalla;
    Spinner spTemporada;
    Spinner spTipo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filtros);

        spEdad=findViewById(R.id.filtrosSPCategoriaedad);
        spGenero=findViewById(R.id.filtrosSPGenero);
        spEstilo=findViewById(R.id.filtrosSPEstilo);
        spTalla=findViewById(R.id.filtrosSPTalla);
        spTemporada=findViewById(R.id.filtrosSPTemporada);
        spTipo=findViewById(R.id.filtrosSPTipo);

        ArrayAdapter<CharSequence> edadAdapter=ArrayAdapter.createFromResource(this,R.array.arrayedad,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> generoAdapter=ArrayAdapter.createFromResource(this,R.array.arraygenero,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> estiloAdapter=ArrayAdapter.createFromResource(this,R.array.arrayestilo,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> tallaAdapter=ArrayAdapter.createFromResource(this,R.array.arraytalla,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> temporadaAdapter=ArrayAdapter.createFromResource(this,R.array.arraytemporada,android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> tipoAdapter=ArrayAdapter.createFromResource(this,R.array.arraytipo,android.R.layout.simple_spinner_item);

        edadAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        generoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        estiloAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tallaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        temporadaAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipoAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spEdad.setAdapter(edadAdapter);
        spGenero.setAdapter(generoAdapter);
        spEstilo.setAdapter(estiloAdapter);
        spTalla.setAdapter(tallaAdapter);
        spTemporada.setAdapter(temporadaAdapter);
        spTipo.setAdapter(tipoAdapter);

        spEdad.setOnItemSelectedListener(onEdadSelected);
        spGenero.setOnItemSelectedListener(onGeneroSelected);
        spEstilo.setOnItemSelectedListener(onEstiloSelected);
        spTalla.setOnItemSelectedListener(onTallaSelected);
        spTemporada.setOnItemSelectedListener(onTemporadaSelected);
        spTipo.setOnItemSelectedListener(onTipoSelected);
        ((Button)findViewById(R.id.filtrosbotonaceptar)).setOnClickListener(onClickAceptar);
        if(savedInstanceState==null) {
            filtro = getIntent().getExtras().getParcelable("filtro");
            Log.d("Filtro recibido:","Se recibio: "+filtro);
            spEdad.setSelection(filtro.getPosEdad());
            spGenero.setSelection(filtro.getPosGenero());
            spEstilo.setSelection(filtro.getPosEstilo());
            spTalla.setSelection(filtro.getPosTalla());
            spTemporada.setSelection(filtro.getPosTemporada());
            spTipo.setSelection(filtro.getPosTipo());
        }else{
            filtro=new Filtro();
            spEdad.setSelection(savedInstanceState.getInt("posedad"));
            spGenero.setSelection(savedInstanceState.getInt("posgenero"));
            spEstilo.setSelection(savedInstanceState.getInt("posestilo"));
            spTalla.setSelection(savedInstanceState.getInt("postalla"));
            spTemporada.setSelection(savedInstanceState.getInt("postemporada"));
            spTipo.setSelection(savedInstanceState.getInt("postipo"));
        }
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
    AdapterView.OnItemSelectedListener onEdadSelected=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            filtro.setPosEdad(i);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
    AdapterView.OnItemSelectedListener onGeneroSelected=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            filtro.setPosGenero(i);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
    AdapterView.OnItemSelectedListener onEstiloSelected=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            filtro.setPosEstilo(i);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
    AdapterView.OnItemSelectedListener onTallaSelected=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            filtro.setPosTalla(i);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
    AdapterView.OnItemSelectedListener onTemporadaSelected=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            filtro.setPosTemporada(i);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };
    AdapterView.OnItemSelectedListener onTipoSelected=new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
            filtro.setPosTipo(i);
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        outState.putInt("posedad",spEdad.getSelectedItemPosition());
        outState.putInt("posgenero",spGenero.getSelectedItemPosition());
        outState.putInt("posestilo",spEstilo.getSelectedItemPosition());
        outState.putInt("postalla",spTalla.getSelectedItemPosition());
        outState.putInt("postemporada",spTemporada.getSelectedItemPosition());
        outState.putInt("postipo",spTipo.getSelectedItemPosition());
        super.onSaveInstanceState(outState, outPersistentState);
    }
}
