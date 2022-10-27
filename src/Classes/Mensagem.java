package Classes;

public class Mensagem {

    private Agenda contato;
    private int contador; // auto incremento;

    public Agenda getContato() {
        return contato;
    }

    public void setContato(Agenda contato) {
        this.contato = contato;
    }

    public int getContador() {
        return contador;
    }

    public void setContador() {
        this.contador++;
    }

}
