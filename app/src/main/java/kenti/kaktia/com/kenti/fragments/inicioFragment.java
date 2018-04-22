package kenti.kaktia.com.kenti.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

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
    public inicioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        fragmentView= inflater.inflate(R.layout.fragment_inicio, container, false);
        GridView cuadricula=(GridView)fragmentView.findViewById(R.id.inicioGVprendas);
        CuadriculaItem items[]={
                new CuadriculaItem(0,"Prenda uno","Esta bien chidori",null),
                new CuadriculaItem(0,"Prenda dos","Esta bien chidori",null),
                new CuadriculaItem(0,"Prenda tres","Esta bien chidori",null),
                new CuadriculaItem(0,"Prenda cuatro","Esta bien chidori",null),
                new CuadriculaItem(0,"Prenda cinco","Esta no esta tan chidori pero igual comprala plox :v\n te conviene",null),

        };
        cuadricula.setAdapter(new CuadriculaAdapter(getContext(),items));
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
