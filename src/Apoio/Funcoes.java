package Apoio;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Funcoes {

    public static String getDataAtual() {
        Date dataAtual = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String data = df.format(dataAtual);

        return data;
    }

    public static String getHoraAtual() {
        Date horaAtual = new Date();
        DateFormat df = new SimpleDateFormat("HH:mm");
        String hora = df.format(horaAtual);

        return hora;
    }

    public static String getDataHoraAtual() {
        Date dataHoraAtual = new Date();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        String dataHora = df.format(dataHoraAtual);

        return dataHora;
    }
}
