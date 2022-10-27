package Classes;

public class Agenda {
    private String nome;
    private int telefone;
    private String email;
    private String tipoCont;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoCont() {
        return tipoCont;
    }

    public void setTipoCont(int tipoCont) {
        switch (tipoCont) {
            case 1:
                this.tipoCont = "Família";
                break;
            case 2:
                this.tipoCont = "Amigos";
                break;
            case 3:
                this.tipoCont = "Trabalho";
                break;
        }
    }
    
    
}
