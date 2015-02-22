package espol.lenguajes.grupo4.reflexionacademica;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;


public class MainActivity extends Activity {
	
	ImageButton imageButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addListenerOnButton();
	}

	public void addListenerOnButton() {

		imageButton = (ImageButton) findViewById(R.id.logoRA);

		imageButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Toast.makeText(MainActivity.this,
						"Con metas claras", Toast.LENGTH_SHORT).show();

			}

		});

	}
	
	
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
	
	public void Amenu(View view)
	{
		Intent i =new Intent(this, Menu.class);
		startActivity(i);
		
	}
/*
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/
}