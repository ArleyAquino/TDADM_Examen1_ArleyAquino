package mx.edu.ittepic.tdadm_exmane1_arleyaquino;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class BaseDatos extends SQLiteOpenHelper {
    public BaseDatos(Context context,  String name,  SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PACIENTE (ID INTEGER PRIMARY KEY, NOMBRE VARCHAR(200), RFC VARCHAR(100), CELULAR VARCHAR(100) , MAIL VARCHAR(500), FECHA VARCHAR(500))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
