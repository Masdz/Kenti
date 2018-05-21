package kenti.kaktia.com.kenti.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import conexion.Conexion;
import conexion.Filtro;
import conexion.Prenda;
import kenti.kaktia.com.kenti.DescripcionActivity;
import kenti.kaktia.com.kenti.FiltrosActivity;
import kenti.kaktia.com.kenti.R;
import kenti.kaktia.com.kenti.adaptadores.CuadriculaAdapter;
import kenti.kaktia.com.kenti.adaptadores.CuadriculaItem;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link inicioFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class inicioFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    View fragmentView;
    Conexion conexion;
    CuadriculaAdapter adaptador;
    CuadriculaItem items[];
    GridView cuadricula;
    Context contexto;
    Filtro filtro;
    public inicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragmentView= inflater.inflate(R.layout.fragment_inicio, container, false);
        conexion=new Conexion(getContext(),"http://192.168.137.1:8080/Ojkali");
        contexto=getContext();
        cuadricula=fragmentView.findViewById(R.id.inicioGVprendas);
        cuadricula.setOnItemClickListener(onItemclick);
        ((Button)fragmentView.findViewById(R.id.iniciobotonfiltros)).setOnClickListener(onClickFiltros);
        return fragmentView;
    }

    View.OnClickListener onClickFiltros=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(filtro==null){
                filtro=new Filtro();
                Log.d("Error filtro","El filtro era nulo");
            }
            Intent filtrosIntent=new Intent(contexto, FiltrosActivity.class);
            filtrosIntent.putExtra("filtro",filtro);
            filtrosIntent.putExtra("url",conexion.getUrl());
            Log.d("Enviando filtro","Se envio "+ filtro);
            startActivityForResult(filtrosIntent,8888);
        }
    };

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    AdapterView.OnItemClickListener onItemclick=new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Log.d("itemSeleccionado", "onItemClick: "+i+","+l+","+items[i]);
            Intent intento=new Intent(contexto, DescripcionActivity.class);
            intento.putExtra("url",items[i].getImagenId());
            intento.putExtra("id",items[i].getItemId());
            startActivity(intento);
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==8888 && resultCode== Activity.RESULT_OK){
            filtro=data.getExtras().getParcelable("filtro");
            conexion.post2(filtro.getParams(), "/Prenda/", prendaError, prendasListener);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArray("items",items);
        outState.putParcelable("filtro",filtro);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(savedInstanceState!=null){
            items= (CuadriculaItem[]) savedInstanceState.getParcelableArray("items");
            filtro= savedInstanceState.getParcelable("filtro");
            adaptador = new CuadriculaAdapter(getContext(), items, conexion);
            cuadricula.setAdapter(adaptador);
        }else {
            filtro = new Filtro();
            Log.d("filtros", filtro.getParams() + "");
            conexion.post2(filtro.getParams(), "/Prenda/", prendaError, prendasListener);
        }

    }

    Response.Listener<JSONArray> prendasListener=new Response.Listener() {
        @Override
        public void onResponse(Object response) {
            JSONArray datos;
            CuadriculaItem item;
            JSONArray json= (JSONArray) response;
            items=new CuadriculaItem[json.length()];
            Log.d("onResposePrendas", "onResponse: "+json);
            for(int i=0;i<json.length();i++){
                try {
                    datos =json.getJSONArray(i);
                    items[i]=new CuadriculaItem();
                    items[i].setItemId(datos.getInt(0));
                    items[i].setImagenId(datos.getString(1));
                    items[i].setTitulo(datos.getString(2));
                    items[i].setDescripcion(datos.getString(3));
                    items[i].setCalificacion((float) datos.getDouble(4));
                } catch (JSONException e) {
                    e.printStackTrace();
                    return;
                }
            }
            adaptador = new CuadriculaAdapter(getContext(), items, conexion);
            cuadricula.setAdapter(adaptador);
        }
    };

    Response.ErrorListener prendaError=new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.d("Error en getPrendas",error+"");
        }
    };


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
