package kenti.kaktia.com.kenti.adaptadores;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
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
        ImageView imageView=view.findViewById(R.id.cuadriculaItemImagen);
        if(item.getImagen()!=null){
            imageView.setImageBitmap(item.getImagen());
        }else{
            if(item.getImagenId()!=null){
                conexion.cargarImagen(imageView,item);
            }else{
                imageView.setImageResource(R.drawable.warning);
            }
        }
        RatingBar cali=view.findViewById(R.id.cuadriculaItemcalificacion);
        if(item.getCalificacion()!=-1){
            cali.setRating(item.getCalificacion());
        }else{
            cali.setVisibility(View.GONE);
        }
        return view;
    }
}
