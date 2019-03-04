package mx.edu.ittepic.tdadm_exmane1_arleyaquino;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.widget.AlertDialogLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.content.DialogInterface;
import android.widget.Toast;

/**
 * Created by lenovo on 20/02/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private String[] nombres;
    String [] paciente;
    private String [] nombre;
    String [] rfc;
    String [] celular;
    String [] email;
    String [] fecha;
    private Context contexto;

    public RecyclerAdapter(String[] p,String[] n,String[] r,String[] c, String[] e,String[] f, Context con) {
        this.paciente = p;
        this.nombre = n;
        this.rfc = r;
        this.celular = c;
        this.email = e;
        this.fecha = f;
        this.contexto = con;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.paciente.setText(paciente[position]);
        holder.nombre.setText(nombre[position]);
        holder.rfc.setText(rfc[position]);
        holder.celular.setText(celular[position]);
        holder.email.setText(email[position]);
        holder.fecha.setText(fecha[position]);

    }

    @Override
    public int getItemCount() {
        return nombre.length;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView paciente;
        TextView nombre;
        TextView rfc;
        TextView celular;
        TextView email;
        TextView fecha;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            paciente = itemView.findViewById(R.id.id);
            nombre = itemView.findViewById(R.id.nombre);
            rfc = itemView.findViewById(R.id.rfc);
            celular = itemView.findViewById(R.id.cel);
            email = itemView.findViewById(R.id.email);
           fecha = itemView.findViewById(R.id.fecha);


        }
    }
}