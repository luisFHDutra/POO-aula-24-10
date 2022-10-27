package Apoio;

public class Arma {

    private int codigo; // gerado automaticamente
    private String descricao;
    private double forca;
    private int nivelUtilizacao;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo() {
        this.codigo = (int) (Math.random() * 500) + 100;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getForca() {
        return forca;
    }

    public void setForca(double forca) {
        this.forca = forca;
    }

    public int getNivelUtilizacao() {
        return nivelUtilizacao;
    }

    public void setNivelUtilizacao(int nivelUtilizacao) {
        this.nivelUtilizacao = nivelUtilizacao;
    }
    
    
}
