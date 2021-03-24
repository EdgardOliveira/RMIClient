package br.edu.fametro;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                abrirTelaSalario();
            }
        });
    }

    private static void abrirTelaSalario() {
        FormSalario formSalario = new FormSalario();
        formSalario.setVisible(true);
    }
}
