package conexion;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by masdz on 30/10/2017.
 */

public class Conectar {
    private String url;
    private Context contexto;
    private RequestQueue queue ;

    public Conectar(Context contexto, String url) {
        this.url = url;
        this.contexto = contexto;
        queue = Volley.newRequestQueue(contexto);
    }

    public Context getContexto(){
        return contexto;
    }

    public RequestQueue getQueue(){
        return queue;
    }

    public void post(Map<String,String> param, String port,Response.ErrorListener error, Response.Listener<String> respuesta){
        final String portf=port;
        final Map<String,String> paramf=param;
        try {
            StringRequest postrequest = new StringRequest(Request.Method.POST, url+port,respuesta,error) {
                @Override
                public Map<String, String> getParams() {
                    return paramf;
                }
            };
            queue.add(postrequest);
        }catch (Exception e){
            Toast.makeText(contexto,"Error: "+e.getMessage(),Toast.LENGTH_LONG).show();
        }
    }

    public void get(String port, Response.Listener<String> respuesta){
        try {
            StringRequest getRequest = new StringRequest(Request.Method.GET, url + port,respuesta,
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("Error", "Indefinido" + error);
                        }
                    }
            );
            queue.add(getRequest);
        }catch (Exception e){
            Log.d("Error get","No se pudo realizar la peticion al servidor");
        }
    }
    public void Getimagen(String ruta,Response.Listener<Bitmap> respuesta,Response.ErrorListener error){
        try {
            ImageRequest imgRequest = new ImageRequest(ruta, respuesta, 0, 0, null, error);
            queue.add(imgRequest);
        }catch (Exception e){
            Log.d("Error imagen","No se pudo realizar la peticion al servidor");
        }
    }

}
