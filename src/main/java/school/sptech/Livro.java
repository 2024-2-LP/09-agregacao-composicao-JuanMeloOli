package school.sptech;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String titulo;
    private String autor;
    private LocalDate dataPublicacao;
    private List<Avaliacao> avaliacoes;

    public Livro(String titulo, LocalDate dataPublicacao, String autor) {
        this.titulo = titulo;
        this.avaliacoes = new ArrayList<>();
        this.dataPublicacao = dataPublicacao;
        this.autor = autor;
    }

    public void adicionarAvaliacao(String descricao, Double qtdEstrelas){
        if (descricao != null && !descricao.isBlank() && qtdEstrelas!= null && qtdEstrelas >= 0 && qtdEstrelas <= 5) {
            Avaliacao avaliacaoAtual = new Avaliacao(descricao, qtdEstrelas);
            avaliacoes.add(avaliacaoAtual);
        }
    }

    public Double calcularMediaAvaliacoes(){
        if (avaliacoes.isEmpty()) {
            return 0.0;
        }
        Double soma = 0.0;
        for (int i = 0; i < avaliacoes.size(); i++) {
            Avaliacao avaliacaoAtual = avaliacoes.get(i);
            soma += avaliacaoAtual.getQtdEstrelas();
        }
        return soma/avaliacoes.size();
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", avaliacoes=" + avaliacoes +
                '}';
    }
}
