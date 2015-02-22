package espol.lenguajes.grupo4.reflexionacademica;

import android.app.Activity;
import android.app.Dialog;
import android.app.ListActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;


public class IEEMaterias extends Activity {
	
	final Context context = this;
	private Button addBotonMaterias;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.iee_materias);
		
		addBotonMaterias = (Button) findViewById(R.id.addBtnMaterias);
		addBotonMaterias.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				//Dialog dialogSubject = new Dialog(IEEMaterias.this);
				final Dialog dialogSubject = new Dialog(context);
				dialogSubject.setContentView(R.layout.dialog_materias);
				dialogSubject.setTitle("Agregar");
				
				Button dialogButtonSubject = (Button)dialogSubject.findViewById(R.id.okAddMateria);
				dialogButtonSubject.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						dialogSubject.dismiss();
						
					}
				});
				dialogSubject.show();
			}
		});
	}
	
	
	
	
//	//Agregar materias
//	public void addSubject(View view){
//		final Dialog d = new Dialog(this);    
//		d.setContentView(R.layout.dialog_materias);
//		d.setTitle("A�adir materias");
//		d.setCancelable(true);
//		final Editable editS = (Editable) d.findViewById(R.id.shortNameSubject);
//		Button bS = (Button) d.findViewById(R.id.okAddMateria);
//		bS.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				String shortName = editS.toString();
//				IEEMaterias.this.
//			}
//		});
//		
//	}

}
