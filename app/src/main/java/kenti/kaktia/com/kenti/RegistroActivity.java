package kenti.kaktia.com.kenti;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;

import conexion.Conexion;
import conexion.Usuario;

public class RegistroActivity extends AppCompatActivity{

    EditText TFusuario;
    EditText TFcorreo;
    EditText TFcontrasena;
    EditText TFrepcontrasena;
    Context contexto=this;
    Conexion conexion;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        conexion=new Conexion(contexto,"http://192.168.137.1:8080/Ojkali");
        setContentView(R.layout.activity_registro);
        TFusuario=findViewById(R.id.registrousuario);
        TFcorreo=findViewById(R.id.registroemail);
        TFcontrasena=findViewById(R.id.registrocontrasenia);
        TFrepcontrasena=findViewById(R.id.registrocontrasenia2);
        ((Button)findViewById(R.id.registrobotonregresar)).setOnClickListener(onVolver);
        ((Button)findViewById(R.id.registrobotonregistrar)).setOnClickListener(onRegistrarse);
    }
    private View.OnClickListener onVolver= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
    private View.OnClickListener onRegistrarse= new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            validar();
            String usuario=TFusuario.getText().toString();
            String correo=TFcorreo.getText().toString();
            String contrasena=TFcontrasena.getText().toString();
            Usuario us=new Usuario();
            us.setRandomId();
            us.setNombre(usuario);
            us.setCorreo(correo);
            us.setContrasenia(contrasena);
            conexion.post2(us.getParams(),"/Usuarioaplicacion/",errorListener,ingresarListener);
        }
    };
    public boolean validar(){
        String usuario=TFusuario.getText().toString();
        String correo=TFcorreo.getText().toString();
        String contrasena=TFcontrasena.getText().toString();
        String contrasena2=TFrepcontrasena.getText().toString();
        boolean valido=false;
        if(usuario.equals("")||correo.equals("")||contrasena.equals("")||contrasena2.equals("")){
            Toast.makeText(this,"No deje Campos vacios",Toast.LENGTH_LONG).show();
        }else{
            if(!isEmailValid(correo)){
                Toast.makeText(this,"Correo no valido",Toast.LENGTH_LONG);
            }else{
                if(!contrasena.equals(contrasena2)){
                    Toast.makeText(this,"Las contraseñas no coinciden",Toast.LENGTH_LONG);
                    TFcontrasena.setText("");
                    TFrepcontrasena.setText("");
                }else{
                    if(contrasena.length()<8){
                        Toast.makeText(this,"La contraseña no debe tener menos de 8 caracteres",Toast.LENGTH_LONG);
                    }else{
                        valido=true;
                    }
                }
            }
        }
        return valido;
    }
    public boolean  isEmailValid(String correo){
        return correo.contains("@")&&(correo.contains(".com")||correo.contains(".net"));
    }

    Response.Listener<JSONArray> ingresarListener= new Response.Listener<JSONArray>() {
        @Override
        public void onResponse(JSONArray response) {
            Toast.makeText(contexto, "Usuario Registrado", Toast.LENGTH_LONG).show();
            finish();
        }
    };

    Response.ErrorListener errorListener=new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Toast.makeText(contexto, "Hubo un error al registrarse: "+error, Toast.LENGTH_LONG).show();
        }
    };
}
