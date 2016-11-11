package jordi.com.myprimeraaplicacion.datamodel;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nacho on 8/11/16.
 */

public class RoperoControlador {

    public static String TAG = "RoperoControlador";

    public void anadirRopa(Ropa ropa) {
        ropa.save();
    }

    public List<Ropa> litarRopa()
    {
        Log.d(TAG, "listando ropa...");
        List<Ropa> listaDeRopa = Ropa.listAll(Ropa.class);
        Log.d(TAG, "número de elementos en lista:" + listaDeRopa.size() + ".");
        return listaDeRopa;
    }

    public List<Ropa> listarPorMarca(String marca){
        List<Ropa> listaDeRopa = Ropa.find(Ropa.class, " marca LIKE ?", "%" + marca + "%");
        Log.d(TAG, "número de elementos en lista con LIKE:" + listaDeRopa.size() + ".");
        return listaDeRopa;
    }

    public void actualizarRopa(Ropa r)
    {
        Log.d(TAG, "actualizando ropa...");
        r.save();
        Log.d(TAG, "ropa actualizada.");
    }

    public void eliminarRopa(Ropa r){
        Log.d(TAG, "eliminando ropa...");
        r.delete();
        Log.d(TAG, "ropa eliminada.");
    }

}
