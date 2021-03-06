package jordi.com.myprimeraaplicacion;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import jordi.com.myprimeraaplicacion.datamodel.Ropa;

/**
 * Created by Admin on 03/11/2016.
 */



public class AdaptorRopa extends RecyclerView.Adapter<AdaptorRopa.ViewHolder> {
    private List<Ropa> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        public TextView myNombreRopa;

        public ImageView myImagenDeRopa;

        public View view;
        public ViewHolder(View v) {
            super(v);
            myNombreRopa = (TextView) v.findViewById(R.id.nombre_ropa);
            myImagenDeRopa = (ImageView)v.findViewById(R.id.imagen_ropa);
            view = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public AdaptorRopa(List<Ropa> myDataset) {
        mDataset = myDataset;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public AdaptorRopa.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ropa_view, parent, false);
        // set the view's size, margins, paddings and layout parameters

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.myNombreRopa.setText(mDataset.get(position).Nombre);
        holder.myImagenDeRopa.setImageResource(mDataset.get(position).Imagen);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}