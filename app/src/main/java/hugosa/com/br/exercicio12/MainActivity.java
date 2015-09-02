package hugosa.com.br.exercicio12;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Spinner;

public class MainActivity extends Activity {
    public final static String EXTRA_MESSAGE = "br.usjt.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void listarVoos(View view) {

        String sp = "São Paulo/Rio de Janeiro: 10:00 hs" +
                    "\nSão Paulo/Rio de Janeiro: 12:00 hs" +
                    "\nSão Paulo/Rio de Janeiro: 14:00 hs";

        String rj = "Rio de Janeiro/São Paulo: 16:00 hs" +
                    "\nRio de Janeiro/São Paulo: 18:00 hs" +
                    "\nRio de Janeiro/São Paulo: 20:00 hs";

        Intent intent = new Intent(this, Voos.class);
        Spinner origem = (Spinner)findViewById(R.id.origem);
        String or = origem.getSelectedItem().toString();
        Spinner destino = (Spinner)findViewById(R.id.destino);
        String ds = destino.getSelectedItem().toString();

        if((or.equals("Sao Paulo")) && (ds.equals("Rio de Janeiro"))) {
            intent.putExtra(EXTRA_MESSAGE, sp);

        }
        if((or.equals("Rio de Janeiro")) && (ds.equals("Sao Paulo"))) {
            intent.putExtra(EXTRA_MESSAGE, rj);

        }

        startActivity(intent);
    }
}
