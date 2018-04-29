package kenti.kaktia.com.kenti.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import conexion.Conexion;
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
    public inicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fragmentView= inflater.inflate(R.layout.fragment_inicio, container, false);
        conexion=new Conexion(getContext(),"url");
        cuadricula=fragmentView.findViewById(R.id.inicioGVprendas);
        if(savedInstanceState==null) {

        }
        return fragmentView;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
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
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if(savedInstanceState!=null){
            items= (CuadriculaItem[]) savedInstanceState.getParcelableArray("items");
        }else{
            items = new CuadriculaItem[]{
                    new CuadriculaItem(0, "Prenda uno", "Esta bien chidori", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ6Ld3bh9laCXXqW2ULG9Lyd0vX_M5rjWwWwdegVwpIgiOOBmczNA",4),
                    new CuadriculaItem(0, "Prenda dos", "Esta bien chidori", "http://www.comprarbolsasonline.es/image/cache/data/category_2/woodland-prenda-hombre-ukqtfsu-615-500x500_0.jpg",4.7f),
                    new CuadriculaItem(0, "Prenda tres", "Esta bien chidori", "http://es.advisto.com/user_images/65341_6538_tactical-polo-web.jpg",4.5f),
                    new CuadriculaItem(0, "Prenda cuatro", "Esta bien chidori", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTByJF_VtcBxlgASpu0nj99SML5aidyvPcuKgKqVDzsd7L9FOWIDg",4.5f),
                    new CuadriculaItem(0, "Prenda cinco", "Esta no esta tan chidori pero igual comprala plox :v\n te conviene", "http://4.bp.blogspot.com/-l5Aff0oOOnc/U4ZaPJgQH1I/AAAAAAAAqO0/2ewhz00ubm8/s1600/97e7eb982033844fad286f3183a3d79a.jpg",1.5f)
            };
        }
        adaptador = new CuadriculaAdapter(getContext(), items, conexion);
        cuadricula.setAdapter(adaptador);
    }

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
