package espol.lenguajes.grupo4.reflexionacademica.db;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;



public class SQLite{
	private SQLiteHelper sqliteHelper;
	private SQLiteDatabase db;
	
	//Contructor
	public SQLite(Context context){
		sqliteHelper = new SQLiteHelper(context);
	}
	
	//Abrir conexion
	public void abrirConexion(){
		Log.i("SQLite", "Abrir conexion a Base de datos" + sqliteHelper.getDatabaseName());
		db = sqliteHelper.getWritableDatabase(); 
	}
	
	//Cerrar conexion
	public void cerrarConexion(){
		Log.i("SQLite", "Cerrar conexion a Base de datos" + sqliteHelper.getDatabaseName());
		sqliteHelper.close();
	}
	
	//Agregar nuevo registro
	/**
	 * @param String abreviatura Nombre corto de la materia
	 * @param String materia Nombre de la materia
	 * @param int totalclases Total de clases en el semestre de la materia
	 */
	public boolean addMateria(String abreviatura, String materia, int totalclases){
		if(materia.length() > 0)
		{
			ContentValues contentValues = new ContentValues();
			contentValues.put(sqliteHelper.__campo_materia_abreviatura, abreviatura);
			contentValues.put(sqliteHelper.__campo_nombre_materia, materia);
			contentValues.put(sqliteHelper.__campo_totalclases_semestral, totalclases);
			Log.i("SQLite", "Nuevo registro ");
			return (db.insert(sqliteHelper.__tabla__, null, contentValues)!=-1)?true:false;
		}
		else
			return false;
		
	}
	
	//Obtener el ultimo ID
	public int getUltimoID(){
		int id = -1;
		Cursor cursor = db.query(sqliteHelper.__tabla__, new String[]{sqliteHelper.__campo_id_materia}, null, null, null, null, sqliteHelper.__campo_id_materia + "DESC", "1");
		if( cursor.moveToFirst()){
			do
			{
				id = cursor.getInt(0);			
			}while(cursor.moveToNext());
		}
		return id;
	}
	
	//Eliminar registro
	public boolean eliminarRegistro(int id){
		return (db.delete(sqliteHelper.__tabla__, sqliteHelper.__campo_id_materia + "=" + id, null)>0)? true:false;
	}
	
	//Obtener todos los registros
	public Cursor getMaterias(){
		return db.query(sqliteHelper.__tabla__, 
			   new String[]{
				   sqliteHelper.__campo_id_materia,
				   sqliteHelper.__campo_materia_abreviatura,
				   sqliteHelper.__campo_nombre_materia,
				   sqliteHelper.__campo_totalclases_semestral
		}, null, null,null,null,null);
		
	}
	
	//Obtiene un registro
	public Cursor getRegistro(int id){
		return db.query(sqliteHelper.__tabla__,
				new String[]{
					sqliteHelper.__campo_id_materia,
					sqliteHelper.__campo_materia_abreviatura,
					sqliteHelper.__campo_nombre_materia,
					sqliteHelper.__campo_totalclases_semestral},
				sqliteHelper.__campo_id_materia + "=" + id,
				null, null, null, null);
		}
	
	//Formato
	public ArrayList<String> getFormato(Cursor cursor)
	{
		ArrayList<String> listData = new ArrayList<String>();
		String item="";
			if(cursor.moveToFirst())
			{
				do
				{
					item += "ID: " + cursor.getInt(0) + "\r\n";
					item += "Abreviatura: " + cursor.getString(1) + "\r\n";
					item += "Materia" + cursor.getString(2)+ "\r\n";
					item += "Total de clases"+ cursor.getInt(3)+ " ";
					listData.add(item);
					item="";
				}while(cursor.moveToNext());
			}
			return listData;
	}
}
