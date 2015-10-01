package hugosa.com.br.exercicio12.model;

import java.util.ArrayList;
import java.util.TreeSet;

import hugosa.com.br.exercicio12.model.Voo;

/**
 * Created by hugosa on 15/09/15.
 */



public class Especialista {
    private static final ArrayList<Voo> voos = cadastroDeVoos();

    public Especialista() {

    }

    private Voo buscarNome(String nome) {
        for (Voo voo : voos) {
            if (nome.equals(voo.getNome())) {
                return voo;
            }
        }
        return null;
    }

    public TreeSet<Voo> listarMarcas(String origem, String destino) {
        TreeSet<Voo> marcas = new TreeSet<Voo>();

        if (origem.length() > 0 && destino.length() > 0) {
            marcas = buscarOrigemDestino(origem, destino);
        } else if (origem.length() > 0) {
            marcas = buscarOrigem(origem);
        } else if (destino.length() > 0) {
            marcas = buscarDestino(destino);
        } else {
            marcas = todas();
        }

        return marcas;
    }

    private TreeSet<Voo> buscarOrigem(String origem) {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if (origem.equals(voo.getOrigem())) {
                lista.add(voo);
            }
        }
        return lista;
    }

    private TreeSet<Voo> buscarDestino(String destino) {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            if (destino.equals(voo.getDestino())) {
                lista.add(voo);
            }
        }
        return lista;
    }

    private TreeSet<Voo> buscarOrigemDestino(String origem, String destino) {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo: voos) {
            if (origem.equals(voo.getOrigem())
                    && destino.equals(voo.getDestino())) {
                lista.add(voo);
            }
        }
        return lista;
    }

    private TreeSet<Voo> todas() {
        TreeSet<Voo> lista = new TreeSet<Voo>();
        for (Voo voo : voos) {
            lista.add(voo);
        }
        return lista;
    }

    private static ArrayList<Voo> cadastroDeVoos() {
        ArrayList<Voo> voos = new ArrayList<Voo>();
        voos.add(new Voo("SAO -> CUR", "São Paulo - SP",
                "Curitiba - PR", "10h00", "voo", 97.99));
        voos.add(new Voo("SAO -> MAC", "São Paulo - SP",
                "Maceió - AL", "13h10", "voo", 248.59));
        voos.add(new Voo("SAO -> BRA", "São Paulo - SP",
                "Brasília - DF", "15h20", "voo", 150.29));
        voos.add(new Voo("SAO -> SLU", "São Paulo - SP",
                "São Luis - MA", "18h50", "voo", 225.99));
        voos.add(new Voo("SAO -> FOR", "São Paulo - SP",
                "Fortaleza - CE", "20h10", "voo", 197.10));
        voos.add(new Voo("RJ -> CUR", "Rio de Janeiro - RJ",
                "Curitiba - PR", "09h00", "voo", 80.99));
        voos.add(new Voo("RJ -> MAC", "Rio de Janeiro - RJ",
                "Maceió - AL", "07h10", "voo", 270.78));
        voos.add(new Voo("RJ -> BRA", "Rio de Janeiro - RJ",
                "Brasília - DF", "05h30", "voo", 172.49));
        voos.add(new Voo("RJ -> SLU", "Rio de Janeiro - RJ",
                "São Luis - MA", "17h55", "voo", 285.99));
        voos.add(new Voo("RJ -> FOR", "Rio de Janeiro - RJ",
                "Fortaleza - CE", "22h18", "voo", 221.10));
        voos.add(new Voo("POR -> CUR", "Porto Alegre - RS",
                "Curitiba - PR", "15h23", "voo", 43.80));
        voos.add(new Voo("POR -> MAC", "Porto Alegre - RS",
                "Maceió - AL", "21h30", "voo", 308.79));
        voos.add(new Voo("POR -> BRA", "Porto Alegre - RS",
                "Brasília - DF", "11h40", "voo", 187.19));
        voos.add(new Voo("POR -> SLU", "Porto Alegre - RS",
                "São Luis - MA", "12h54", "voo", 285.29));
        voos.add(new Voo("POR -> FOR", "Porto Alegre - RS",
                "Fortaleza - CE", "00h19", "voo", 260.30));
        voos.add(new Voo("SAL -> CUR", "Salvador - BA",
                "Curitiba - PR", "20h48", "voo", 130.89));
        voos.add(new Voo("SAL -> MAC", "Salvador - BA",
                "Maceió - AL", "03h30", "voo", 99.99));
        voos.add(new Voo("SAL -> BRA", "Salvador - BA",
                "Brasília - DF", "08h37", "voo", 135.79));
        voos.add(new Voo("SAL -> SLU", "Salvador - BA",
                "São Luis - MA", "13h54", "voo", 75.49));
        voos.add(new Voo("SAL -> FOR", "Salvador - BA",
                "Fortaleza - CE", "19h20", "voo", 145.30));
        voos.add(new Voo("POR -> CUR", "Belo Horizonte - MG",
                "Curitiba - PR", "18h23", "voo", 154.40));
        voos.add(new Voo("POR -> MAC", "Belo Horizonte - MG",
                "Maceió - AL", "22h50", "voo", 246.19));
        voos.add(new Voo("POR -> BRA", "Belo Horizonte - MG",
                "Brasília - DF", "16h25", "voo", 75.10));
        voos.add(new Voo("POR -> SLU", "Belo Horizonte - MG",
                "São Luis - MA", "10h49", "voo", 260.15));
        voos.add(new Voo("POR -> FOR", "Belo Horizonte - MG",
                "Fortaleza - CE", "02h20", "voo", 235.10));

        return voos;
    }
}

