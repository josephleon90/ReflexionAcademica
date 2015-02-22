package espol.lenguajes.grupo4.reflexionacademica.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper{
	
	private static final String __DATABASE = "dbReflexionAcademica"; //nombre de base de datos
	private static final int __VERSION=1;//version de la base de datos
	
	public final String __tabla__ = "Materias";
	public final String __campo_id_materia = "idMateria";
	public final String __campo_materia_abreviatura = "Abreviatura";
	public final String __campo_nombre_materia = "NombreMateria";
	public final String __campo_totalclases_semestral = "TotalClases";

	//Crear tabla
	private final String sql = "CREATE TABLE" + __tabla__ + " ( " +
				  __campo_id_materia + "INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
				  __campo_materia_abreviatura + "TEXT NULL, " +
				  __campo_nombre_materia + "TEXT NULL, " +
				  __campo_totalclases_semestral + "INTEGER" +
				  " ) ";

	//Connstructor
	public SQLiteHelper(Context context){
		super(context, __DATABASE,null, __VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db){
		db.execSQL(sql);		
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int antiguaVersion, int nuevaVersion){
		if (nuevaVersion > antiguaVersion){
			
			db.execSQL("DROP TABLE IF EXISTS" + __tabla__);//eliminar
			db.execSQL(sql);//crear nueva
		}
	}
	
}
