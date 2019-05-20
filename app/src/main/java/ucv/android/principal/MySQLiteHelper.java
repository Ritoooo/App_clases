package ucv.android.principal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class MySQLiteHelper extends android.database.sqlite.SQLiteOpenHelper {
    public static final String nombreTabla = "persona";
    private static final String nombreBaseDatos = "BDCJAVA.db";
    private static final int version = 1;

    private static final String SQLDB = "create table " + nombreTabla +
                                        "(codigo integer primary key autoincrement, " +
                                        "nombre text not null, apellido text not null, dni text not null);";

    public MySQLiteHelper(Context contexto){
        super(contexto,nombreBaseDatos,null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(SQLDB);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(MySQLiteHelper.class.getName(), "Actualizando la versión de la Base de Datos Número: " + oldVersion + " a " + newVersion);
        db.execSQL("DROP TABLE IF EXISTS " + nombreTabla);
        onCreate(db);
    }
}
