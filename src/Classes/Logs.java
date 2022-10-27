package Classes;

import Apoio.Funcoes;

public class Logs {
    private String datahora;
    private Agenda contato;
    private String mensagem;

    public String getDatahora() {
        return datahora;
    }

    public void setDatahora() {
        this.datahora = Funcoes.getDataHoraAtual();
    }

    public Agenda getContato() {
        return contato;
    }

    public void setContato(Agenda contato) {
        this.contato = contato;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    
}
