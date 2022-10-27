package Apoio;

public class Personagem {

    private int codigo; // gerado automaticamente
    private String nome;
    private Arma armas[];
    private int pArmas;
    private Defesa defesas[];
    private int pDefesas;

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

    public Arma[] getArmas() {
        return armas;
    }

    public void setArmas(Arma[] armas) {
        this.armas = armas;
    }

    public int getpArmas() {
        return pArmas;
    }

    public void setpArmas(int pArmas) {
        this.pArmas = pArmas;
    }

    public Defesa[] getDefesas() {
        return defesas;
    }

    public void setDefesas(Defesa[] defesas) {
        this.defesas = defesas;
    }

    public int getpDefesas() {
        return pDefesas;
    }

    public void setpDefesas(int pDefesas) {
        this.pDefesas = pDefesas;
    }
    
    
}
