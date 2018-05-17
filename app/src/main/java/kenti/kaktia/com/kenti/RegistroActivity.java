package kenti.kaktia.com.kenti;

import android.app.LoaderManager;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class RegistroActivity extends AppCompatActivity{
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
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
            finish();
        }
    };
}
