package espol.lenguajes.grupo4.reflexionacademica;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.opciones_usuario);
	}
	
	public void Aasistencias(View view){
		Intent j=new Intent(this,IEEAsistencias.class);
		startActivity(j);
	}
	
	public void Aexamenes(View view){
		Intent i=new Intent(this,IEEExamenes.class);
		startActivity(i);
	}
	
	public void Aproyectos(View view){
		Intent j=new Intent(this,IEEProyectos.class);
		startActivity(j);
	}
	
	public void Atareas(View view){
		Intent j=new Intent(this,IEETareas.class);
		startActivity(j);
	}
	
	public void Amaterias(View view){
		Intent j=new Intent(this,IEEMaterias.class);
		startActivity(j);
	}

}
