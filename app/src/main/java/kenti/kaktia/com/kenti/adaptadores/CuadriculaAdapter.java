package kenti.kaktia.com.kenti.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import conexion.Conexion;
import kenti.kaktia.com.kenti.R;

public class CuadriculaAdapter extends BaseAdapter{

    private CuadriculaItem items[];
    private Context contexto;
    private Conexion conexion;
    public CuadriculaAdapter(Context contexto, CuadriculaItem items[], Conexion conexion){
        this.items=items;
        this.contexto=contexto;
        this.conexion=conexion;
    }

    @Override
    public int getCount() {
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return items[i].getItemId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view==null)
            view=(LayoutInflater.from(contexto)).inflate(R.layout.item_cuadricula,null);
        CuadriculaItem item=this.items[i];
        ((TextView)view.findViewById(R.id.cuadriculaItemTitulo)).setText(item.getTitulo());
        ((TextView)view.findViewById(R.id.cuadriculaItemDescripcion)).setText(item.getDescripcion());
        if(item.getImagenId()!=null)
            conexion.cargarImagen(((ImageView)view.findViewById(R.id.cuadriculaItemImagen)),item.getImagenId());
        else
            ((ImageView)view.findViewById(R.id.cuadriculaItemImagen)).setImageResource(R.drawable.warning);
        return view;
    }
}
