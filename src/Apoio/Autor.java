package Apoio;

public class Autor {

    private int codigo; // auto numerada
    private String nome;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo() {
        this.codigo = (int) (Math.random() * 500) + 100;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
