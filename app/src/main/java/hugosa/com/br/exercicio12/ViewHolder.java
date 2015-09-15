package hugosa.com.br.exercicio12;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hugosa on 15/09/15.
 */
public class ViewHolder {
    private ImageView fotinhoVoo;
    private TextView nomeVoo, detalhesVoo;

    public ViewHolder(ImageView fotinhoVoo, TextView nomeVoo, TextView detalhesVoo) {
        this.fotinhoVoo = fotinhoVoo;
        this.nomeVoo = nomeVoo;
        this.detalhesVoo = detalhesVoo;
    }

    public ImageView getFotinhoVoo() {
        return fotinhoVoo;
    }

    public void setFotinhoVoo(ImageView fotinhoVoo) {
        this.fotinhoVoo = fotinhoVoo;
    }

    public TextView getNomeVoo() {
        return nomeVoo;
    }

    public void setNomeVoo(TextView nomeVoo) {
        this.nomeVoo = nomeVoo;
    }

    public TextView getDetalhesVoo() {
        return detalhesVoo;
    }

    public void setDetalhesVoo(TextView detalhesVoo) {
        this.detalhesVoo = detalhesVoo;
    }
}

