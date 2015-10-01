package hugosa.com.br.exercicio12.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.SectionIndexer;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Hashtable;
import java.util.Locale;

import hugosa.com.br.exercicio12.R;
import hugosa.com.br.exercicio12.util.Util;
import hugosa.com.br.exercicio12.util.ViewHolder;
import hugosa.com.br.exercicio12.model.Voo;

/**
 * Created by hugosa on 15/09/15.
 */
public class VooAdapter extends BaseAdapter implements SectionIndexer
{
    Activity context;
    Voo[] voos;
    Object[] sectionHeaders;
    Hashtable<Integer, Integer> positionForSectionMap;
    Hashtable<Integer, Integer> sectionForPositionMap;

    public VooAdapter(Activity context, Voo[] voos){
        this.context = context;
        this.voos = voos;
        sectionHeaders = SectionIndexBuilder.BuildSectionHeaders(voos);
        positionForSectionMap = SectionIndexBuilder.BuildPositionForSectionMap(voos);
        sectionForPositionMap = SectionIndexBuilder.BuildSectionForPositionMap(voos);

    }
    @Override
    public int getCount() {
        return voos.length;
    }

    @Override
    public Object getItem(int position) {
        if(position >= 0 && position < voos.length)
            return voos[position];
        else
            return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //o list view recicla os layouts para melhor performance
        //o layout reciclado vem no parametro convert view
        View view = convertView;
        //se nao recebeu um layout para reutilizar deve inflar um
        if(view == null) {
            //um inflater transforma um layout em uma view
            LayoutInflater inflater = (LayoutInflater) context.getSystemService
                    (Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.linha_voo, parent, false);

            ImageView fotinhoVoo = (ImageView)view.findViewById(R.id.fotinhoVooImageView);
            TextView nomeVoo = (TextView)view.findViewById(R.id.nomeVooTextView);
            TextView detalhesVoo = (TextView)view.findViewById(R.id.detalhesVooTextView);
            //faz cache dos widgets instanciados na tag da view para reusar quando houver reciclagem
            view.setTag(new ViewHolder(fotinhoVoo, nomeVoo, detalhesVoo));
        }
        //usa os widgets cacheados na view reciclada
        ViewHolder holder = (ViewHolder)view.getTag();
        //carrega os novos valores
        Drawable drawable = Util.getDrawable(context, voos[position].getImagem());
        holder.getFotinhoVoo().setImageDrawable(drawable);
        Locale locale = new Locale("pt", "BR");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);
        holder.getNomeVoo().setText(voos[position].getNome());
        holder.getDetalhesVoo().setText(String.format("%s - %s", voos[position].getOrigem(),
                formatter.format(voos[position].getPreco())));

        return view;
    }
//metodos da interface SectionIndexer


    @Override
    public Object[] getSections() {
        return sectionHeaders;
    }

    @Override
    public int getPositionForSection(int sectionIndex) {
        return positionForSectionMap.get(sectionIndex).intValue();
    }

    @Override
    public int getSectionForPosition(int position) {
        return sectionForPositionMap.get(position).intValue();
    }
}
