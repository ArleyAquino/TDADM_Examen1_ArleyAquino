package mx.edu.ittepic.tdadm_exmane1_arleyaquino;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

public class Main2Activity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private BaseDatos base;
    Button regresar;

    String [] paciente= new String[5];
    String [] nombre= new String[5];
    String [] rfc= new String[5];
    String [] celular= new String[5];
    String [] email= new String[5];
    String [] fecha= new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Base de datos
        base=new BaseDatos(this, "primera",null,1); //clase de conexion BaseDatos y la bd se llama primera
        try{
            SQLiteDatabase tabla= base.getReadableDatabase();
            String SQL ="SELECT * FROM PACIENTE";

            Cursor resultado =tabla.rawQuery(SQL, null);
            if(resultado.moveToFirst()) {
                int i=0;
                while(!resultado.isAfterLast()){
                    paciente[i]=resultado.getString(0).toString();
                    nombre[i]=resultado.getString(1);
                    rfc[i]=resultado.getString(2);
                    celular[i]=resultado.getString(3);
                    email[i]=resultado.getString(4);
                    fecha[i]=resultado.getString(5);
                    i++;
                    resultado.moveToNext();
                }
            }
            tabla.close();
        }catch (SQLiteException e){
            Toast.makeText(this, "NO SE PUDO REALIZAR"+e.toString(), Toast.LENGTH_LONG).show();
        }
        regresar=findViewById(R.id.regresar);
        // Crear referencias hacia el componente RecycleriView
        recyclerView = findViewById(R.id.recycler_id);

        // Crear un objeto de tipo RecyclerAdapter que recibe un arreglo de cadenas
        adapter = new RecyclerAdapter(paciente, nombre, rfc, celular, email, fecha, this);

        // Crea un objeto de tipo LinearLayoutManager
        layoutManager = new LinearLayoutManager(this);
        // Establecer el LayautManager
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        // Establecer el Adapter
        recyclerView.setAdapter(adapter);

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otra = new Intent(Main2Activity.this, MainActivity.class);
                startActivity(otra);

            }
        });

    }
}