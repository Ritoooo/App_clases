package ucv.android.principal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class PersonaDAO {
    private SQLiteDatabase database;
    private MySQLiteHelper dbHelper;

    public PersonaDAO(Context context){
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException{
        database = dbHelper.getWritableDatabase();
    }

    public  void close(){
        dbHelper.close();
    }

    public long insertar(String nom, String ape, String dni){
        long estado = 0;
        try {
            ContentValues valores = new ContentValues();
            valores.put("nombre",nom);
            valores.put("apellido",ape);
            valores.put("dni",dni);
            estado = database.insert(MySQLiteHelper.nombreTabla,null,valores);
        }catch (Exception e){
            estado = 0;
        }
        return estado;
    }

    public long eliminar(int codigo){
        long estado = 0;
        try {
            estado = database.delete(MySQLiteHelper.nombreTabla,"codigo=?",new String[]{String.valueOf(codigo)});
        }catch (Exception e){
            estado = 0;
        }
        return estado;
    }

    public long modificar(String cod, String nom, String ape, String dni){
        long estado = 0;
        try {
            ContentValues valorea = new ContentValues();
            valorea.put("nombre",nom);
            valorea.put("apellido",ape);
            valorea.put("dni",dni);
            estado = database.update(MySQLiteHelper.nombreTabla,valorea,"codigo="+cod,null);
        }catch (Exception e){
            estado = 0;
        }
        return estado;
    }

    public ArrayList<Persona> listadoGeneral(){
        Cursor c;
        ArrayList<Persona> listado = new ArrayList<Persona>();
        c = database.rawQuery("SELECT * FROM persona ",null);
        while (c.moveToNext()){
            Persona bean = new Persona();
            bean.setCodigo(c.getInt(0));
            bean.setNombre(c.getString(1));
            bean.setApellido(c.getString(2));
            bean.setDni(c.getString(3));
            listado.add(bean);
        }
        c.close();
        return listado;
    }
}
