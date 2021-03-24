package br.edu.fametro;

import javax.swing.*;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class FormContraCheque extends JFrame {

    private JPanel jPanel;
    public FormContraCheque(Salario salario){
        JPanelCustomizado jPanelCustomizado = new JPanelCustomizado("imagens/contraCheque.jpg");
        jPanelCustomizado.setLayout(null);
        JLabel lblCodFunc = new JLabel("010");
        lblCodFunc.setBounds(20, 75, 30, 15);
        jPanelCustomizado.add(lblCodFunc);
        JLabel lblNome = new JLabel(salario.getNome().toUpperCase());
        lblNome.setBounds(68, 75, 260, 15);
        jPanelCustomizado.add(lblNome);

        JLabel lblCodSalario = new JLabel("0001");
        lblCodSalario.setBounds(20, 125, 50, 15);
        jPanelCustomizado.add(lblCodSalario);
        JLabel lblDescSalario = new JLabel("SALÁRIO CONTRATUAL");
        lblDescSalario.setBounds(68, 125, 260, 15);
        jPanelCustomizado.add(lblDescSalario);
        JLabel lblRefSalario = new JLabel("30D");
        lblRefSalario.setBounds(345, 125, 50, 15);
        jPanelCustomizado.add(lblRefSalario);
        JLabel lblVencSalario = new JLabel(formatarValor(salario.getSalarioBase()));
        lblVencSalario.setBounds(405, 125, 150, 15);
        jPanelCustomizado.add(lblVencSalario);

        JLabel lblCodINSS = new JLabel("0520");
        lblCodINSS.setBounds(20, 145, 50, 15);
        jPanelCustomizado.add(lblCodINSS);
        JLabel lblDescINSS = new JLabel("INSS");
        lblDescINSS.setBounds(68, 145, 260, 15);
        jPanelCustomizado.add(lblDescINSS);
        JLabel lblRefINSS = new JLabel(formatarPercentual(salario.getFaixaINSS()));
        lblRefINSS.setBounds(345, 145, 50, 15);
        jPanelCustomizado.add(lblRefINSS);
        JLabel lblDescontoINSS = new JLabel(formatarValor(salario.getInss()));
        lblDescontoINSS.setBounds(520, 145, 150, 15);
        jPanelCustomizado.add(lblDescontoINSS);

        JLabel lblCodIRR = new JLabel("0731");
        lblCodIRR.setBounds(20, 165, 50, 15);
        jPanelCustomizado.add(lblCodIRR);
        JLabel lblDescIRRF = new JLabel("IRRF");
        lblDescIRRF.setBounds(68, 165, 260, 15);
        jPanelCustomizado.add(lblDescIRRF);
        JLabel lblRefIRRF = new JLabel(formatarPercentual(salario.getFaixaIRRF()));
        lblRefIRRF.setBounds(345, 165, 50, 15);
        jPanelCustomizado.add(lblRefIRRF);
        JLabel lblDescontoIRRF = new JLabel(formatarValor(salario.getIrrf()));
        lblDescontoIRRF.setBounds(520, 165, 150, 15);
        jPanelCustomizado.add(lblDescontoIRRF);

        JLabel lblVencTotal = new JLabel(formatarValor(salario.getSalarioBase()));
        lblVencTotal.setBounds(405, 403, 150, 15);
        jPanelCustomizado.add(lblVencTotal);
        Double descontos = (salario.getInss() + salario.getIrrf());
        JLabel lblDescTotal = new JLabel(formatarValor(descontos));
        lblDescTotal.setBounds(520, 403, 150, 15);
        jPanelCustomizado.add(lblDescTotal);

        JLabel lblLiquidoTotal = new JLabel(formatarValor(salario.getSalarioBase() - descontos));
        lblLiquidoTotal.setBounds(520, 425, 150, 15);
        jPanelCustomizado.add(lblLiquidoTotal);

        JLabel lblSalBase = new JLabel(formatarValor(salario.getSalarioBase()));
        lblSalBase.setBounds(23, 465, 100, 15);
        jPanelCustomizado.add(lblSalBase);

        JLabel lblSalBaseINSS = new JLabel(formatarValor(salario.getSalarioBase()));
        lblSalBaseINSS.setBounds(145, 465, 100, 15);
        jPanelCustomizado.add(lblSalBaseINSS);

        JLabel lblSalBaseFGTS = new JLabel(formatarValor(salario.getSalarioBase()));
        lblSalBaseFGTS.setBounds(245, 465, 100, 15);
        jPanelCustomizado.add(lblSalBaseFGTS);

        JLabel lblFGTS = new JLabel(formatarValor(salario.getSalarioBase() * 0.08));
        lblFGTS.setBounds(333, 465, 100, 15);
        jPanelCustomizado.add(lblFGTS);

        JLabel lblSalIRRF = new JLabel(formatarValor(salario.getSalarioBaseIRRF()));
        lblSalIRRF.setBounds(445, 465, 100, 15);
        jPanelCustomizado.add(lblSalIRRF);

        JLabel lblIRRF = new JLabel(formatarPercentual(salario.getFaixaIRRF()));
        lblIRRF.setBounds(550, 465, 100, 15);
        jPanelCustomizado.add(lblIRRF);

        add(jPanelCustomizado);
        setSize(624, 538);
        setTitle("Recibo de Pagamento de Salário");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public static String formatarValor(double valor) {
        Locale locale = new Locale("pt", "BR");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
        return numberFormat.format(valor);
    }

    public static String formatarPercentual(double valor) {
        Locale locale = new Locale("pt", "BR");
        NumberFormat number = NumberFormat.getPercentInstance(locale);
        number.setMinimumFractionDigits(2);
        return number.format(valor/100);
    }
}
