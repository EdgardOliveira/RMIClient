package br.edu.fametro;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.rmi.Naming;

public class FormSalario extends JFrame {

    private static final String ENDPOINT = "rmi://192.168.1.10:1099/Servidor";
    private JPanel jPanel;
    private JLabel lblNome;
    private JTextField txtNome;
    private JSpinner spnDependentes;
    private JLabel lblDependentes;
    private JFormattedTextField txtSalario;
    private JButton btnCalcular;
    private JButton btnLimpar;
    private JComboBox cbbEnderecos;
    private JLabel lblEndereco;
    private JLabel lblPorta;
    private JSpinner spnPorta;
    private JComboBox cbbServicos;
    private JLabel lblServico;
    private JLabel lblCaminhoCompleto;
    private Salario salario;
    private String caminhoCompleto;

    public FormSalario() {
        add(jPanel);
        setSize(800, 500);
        setTitle("Cálculo de Salário Líquido");
        setLocationRelativeTo(null);

        popularEnderecos();
        configurarPorta();
        popularServicos();
        atualizarDadosTela();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validarDados()) {
                    try {
                        calcularSalario(salario);
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                } else {
                    exibirMensagem("Preencha todos os campos obrigatórios");
                }
            }
        });

        btnLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNome.setText(null);
                spnDependentes.setValue(0);
                txtSalario.setText("0");
            }
        });

        cbbEnderecos.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                atualizarDadosTela();
            }
        });

        cbbServicos.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent arg0) {
                atualizarDadosTela();
            }
        });

        spnPorta.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                atualizarDadosTela();
            }
        });
    }

    private void configurarPorta() {
        spnPorta.setValue(1099);
    }

    private void popularServicos(){
        cbbServicos.addItem("Servidor");
        cbbServicos.addItem("ServidorCalculoSalarial");
    }

    private void popularEnderecos() {
        cbbEnderecos.addItem("blockfy.ddns.net");
        cbbEnderecos.addItem("192.168.1.10");
        cbbEnderecos.addItem("192.168.1.100");
    }

    private void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem);
    }

    private void calcularSalario(Salario salario) throws Exception {
        try {
            ICalculoSalarial iCalculoSalarial = (ICalculoSalarial) Naming.lookup(caminhoCompleto);
            this.salario = iCalculoSalarial.calcular(salario);
            abrirTelaContraCheque();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro.\nErro: " + e.getMessage());
        }
    }

    public boolean validarDados() {
        boolean status = true;
        String nome = txtNome.getText().trim().length()>0 ? txtNome.getText().trim() : "";
        int dependentes = spnDependentes.getValue().toString().trim().length()>0 ? Integer.parseInt(spnDependentes.getValue().toString().trim()): 0;
        Double salarioBase = txtSalario.getText().trim().length()>0 ? (Double.parseDouble(txtSalario.getText().trim())) : (0);
        salario = new Salario(nome, dependentes, salarioBase);

        if (nome.isEmpty() || nome.length() < 3)
            status = false;

        if (salarioBase < 1)
            status = false;

        return status;
    }

    private void atualizarDadosTela() {
        caminhoCompleto = "rmi://" +
                cbbEnderecos.getSelectedItem().toString() +
                ":" + spnPorta.getValue().toString() +
                "/" + cbbServicos.getSelectedItem().toString();
        lblCaminhoCompleto.setText("Caminho completo: " + caminhoCompleto);

    }

    private void abrirTelaContraCheque() throws IOException {
        FormContraCheque formContraCheque = new FormContraCheque(salario);
        formContraCheque.setVisible(true);
    }
}
