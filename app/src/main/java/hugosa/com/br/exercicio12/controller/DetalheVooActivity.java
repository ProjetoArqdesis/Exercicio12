package hugosa.com.br.exercicio12.controller;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Locale;

import hugosa.com.br.exercicio12.R;
import hugosa.com.br.exercicio12.util.Util;
import hugosa.com.br.exercicio12.model.Voo;

public class DetalheVooActivity extends Activity {

    TextView vooNome;
    ImageView vooImageView;
    TextView vooPreco;
    TextView vooOrigem;
    TextView vooDestino;
    TextView vooHorario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_voo);

        Intent intent = getIntent();
        Serializable obj = intent.getSerializableExtra(ListaVooActivity.VOO);
        Voo voo = (Voo)obj;
        setupViews(voo);

    }

    private void setupViews(Voo voo) {
        vooNome = (TextView) findViewById(R.id.txt_voo_nome);
        vooNome.setText(voo.getNome());
        vooImageView = (ImageView) findViewById(R.id.voo_image_view);
        Drawable drawable = Util.getDrawable(this, voo.getImagem());
        vooImageView.setImageDrawable(drawable);
        vooPreco = (TextView) findViewById(R.id.txt_voo_preco);
        Locale locale = new Locale("pt", "BR");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        vooPreco.setText(""+formatter.format(voo.getPreco()));
        vooOrigem = (TextView) findViewById(R.id.txt_voo_origem);
        vooOrigem.setText(voo.getOrigem());
        vooDestino = (TextView) findViewById(R.id.txt_voo_destino);
        vooDestino.setText(voo.getDestino());
        vooHorario = (TextView) findViewById(R.id.txt_voo_horario);
        vooHorario.setText(voo.getHorario());
    }

}
