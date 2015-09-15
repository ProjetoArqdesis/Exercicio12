package hugosa.com.br.exercicio12;

import java.io.Serializable;

/**
 * Created by hugosa on 15/09/15.
 */


public class Voo implements Comparable<Voo>, Serializable {
    private String nome;
    private String imagem;
    private double preco;
    private String origem;
    private String destino;
    private String horario;
    public static final String NAO_ENCONTRADA = "Não encontrada.";

    public Voo(String nome, String origem, String destino, String horario, String imagem, double preco) {
        this.nome = nome;
        this.imagem = imagem;
        this.preco = preco;
        this.origem = origem;
        this.destino = destino;
        this.horario = horario;
    }

    public String getNome() {
        return nome;
    }

    public String getImagem() {
        return imagem;
    }

    public double getPreco() {
        return preco;
    }

    public String getOrigem() {
        return origem;
    }

    public String getDestino() {
        return destino;
    }

    public String getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return "br.usjt.cervejap1.Cerveja{" +
                "nome='" + nome + '\'' +
                ", imagem='" + imagem + '\'' +
                ", preco='" + preco + '\'' +
                ", origem='" + origem + '\'' +
                ", destino='" + destino + '\'' +
                ", horario='" + horario + '\'' +
                '}';
    }

    @Override
    public int compareTo(Voo voo) {
        if (nome.equals(voo.getNome())
                && origem.equals(voo.getOrigem())
                && destino.equals(voo.getDestino())){
            return 0;
        }
        return this.getNome().compareTo(voo.getNome());
    }
}

