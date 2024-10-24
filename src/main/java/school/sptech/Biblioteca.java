package school.sptech;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros;


    public Biblioteca(String nome) {
        this.nome = nome;
        this.livros = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro){
        if (livro != null && livro.getTitulo() != null && !livro.getTitulo().isBlank() && livro.getAutor() != null && !livro.getAutor().isBlank() && livro.getDataPublicacao() != null ) {
            livros.add(livro);
        }
    }

    public void removerLivroPorTitulo(String titulo){
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getTitulo().equalsIgnoreCase(titulo))
            livros.remove(i);
        }
    }

    public Livro buscarLivroPorTitulo(String titulo){

        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).getTitulo().equalsIgnoreCase(titulo)){
                return  livros.get(i);
            }

        }
        return null;
    }

    public Integer contarLivros(){
        return livros.size();
    }

    public List<Livro> obterLivrosAteAno(Integer ano){
        List<Livro> livrosData = new ArrayList<>();

        for (int i = 0; i < livros.size(); i++) {
            if (ano >= livros.get(i).getDataPublicacao().getYear()) {
                livrosData.add(livros.get(i));
            } 
        }
        return livrosData;
    }

    public List<Livro> retornarTopCincoLivros(){
        List<Livro> listaOrdenada = new ArrayList<>(livros);
        List<Livro> lista5 = new ArrayList<>();

        listaOrdenada.sort(Comparator.comparingDouble(Livro::calcularMediaAvaliacoes).reversed());

        for (int i = 0; i < listaOrdenada.size() && i <5; i++) {
            lista5.add(listaOrdenada.get(i));
        }
        return lista5;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
