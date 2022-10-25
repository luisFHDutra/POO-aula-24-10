package Apoio;

public class Peca {

    private int codigo; // auto numerado
    private String referencia;
    private String nomePeca;
    private String categoria;
    private double valor;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo() {
        this.codigo = (int) (Math.random() * 500) + 100;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    
}
