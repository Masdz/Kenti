package kenti.kaktia.com.kenti;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;

import org.json.JSONException;
import org.json.JSONObject;

import conexion.Conexion;

public class DescripcionActivity extends AppCompatActivity {
    TextView tvmos;
    ImageView imimagen;
    Conexion conexion;
    Context contexto=this;
    Bitmap imagen;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);

        conexion=new Conexion(contexto,"http://192.168.137.1:8080/Ojkali");
        tvmos=findViewById(R.id.tvcontenidodescripcion);
        imimagen=findViewById(R.id.ivprendadescripcion);

        long id=getIntent().getExtras().getLong("id");
        url=getIntent().getExtras().getString("url");

        conexion.get2("/Prenda/"+id,onrespuesta);
        ((Button)findViewById(R.id.botonaceptardescripcion)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    Response.Listener<JSONObject> onrespuesta=new Response.Listener<JSONObject>() {
        @Override
        public void onResponse(JSONObject response) {
            try {
                String desc="Tipo: "+response.getString("tipo")+"\n" +
                        "Marca: "+response.getString("marca")+"\n" +
                        "Estilo: "+response.getString("estilo")+"\n" +
                        "Poblacion:"+response.getString("poblacion")+"\n" +
                        "Genero:"+response.getString("genero")+"\n" +
                        "Tallas: "+response.getString("tallas")+"\n" +
                        "Etiquetas: "+response.getString("etiquetas")+"\n" +
                        "";
                conexion.cargarImagen(imimagen,url);
                tvmos.setText(desc);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

}
