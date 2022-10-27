package Classes;

public class Noticia {

    private int codigo; // auto numerada
    private String titulo;
    private String descricao;
    private Autor autor;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo() {
        this.codigo = (int) (Math.random() * 500) + 100;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    
    
}
