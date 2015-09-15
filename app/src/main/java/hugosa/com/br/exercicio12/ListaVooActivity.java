package hugosa.com.br.exercicio12;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class ListaVooActivity extends Activity {

    ListView listView;
    Activity atividade;
    public final static String VOO = "br.usjt.VOO";
    Voo[] voos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_voo);
        atividade = this;

        Especialista especialista = new Especialista();
        //pega a mensagem do intent
        Intent intent = getIntent();
        String origem = intent.getStringExtra(MainActivity.ORIGEM);
        String destino = intent.getStringExtra(MainActivity.DESTINO);
        String modo = intent.getStringExtra(MainActivity.MODO);

        voos = especialista.listarMarcas(origem, destino).toArray(new Voo[0]);
        String[] lista = null;

        if(modo.equals(MainActivity.SIMPLES)) {
            lista = new String[voos.length];

            for (int i = 0; i < voos.length; i++) {
                lista[i] = voos[i].getNome();
            }
        }
        //cria a lista de voos
        listView = (ListView) findViewById(R.id.view_lista_voo);
        BaseAdapter adapter;
        if(modo.equals(MainActivity.SIMPLES)) {
            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, lista);
        } else {
            adapter = new VooAdapter(this, voos);
        }
        listView.setAdapter(adapter);

        // listener de click em um item do listview

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // manda para a tela de detalhe
                Intent intent = new Intent(atividade, DetalheVooActivity.class);
                intent.putExtra(VOO, voos[position]);

                startActivity(intent);

            }

        });
    }

}
