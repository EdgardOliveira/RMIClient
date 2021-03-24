package br.edu.fametro;

import java.io.Serializable;

public class Salario implements Serializable {
    private String nome;
    private int dependentes;
    private Double salarioBase;
    private Double faixaINSS;
    private Double inss;
    private Double salarioBaseIRRF;
    private Double faixaIRRF;
    private Double irrf;
    private Double salarioLiquido;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDependentes() {
        return dependentes;
    }

    public void setDependentes(int dependentes) {
        this.dependentes = dependentes;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Double getFaixaINSS() {
        return faixaINSS;
    }

    public void setFaixaINSS(Double faixaINSS) {
        this.faixaINSS = faixaINSS;
    }

    public Double getInss() {
        return inss;
    }

    public void setInss(Double inss) {
        this.inss = inss;
    }

    public Double getSalarioBaseIRRF() {
        return salarioBaseIRRF;
    }

    public void setSalarioBaseIRRF(Double salarioBaseIRRF) {
        this.salarioBaseIRRF = salarioBaseIRRF;
    }

    public Double getFaixaIRRF() {
        return faixaIRRF;
    }

    public void setFaixaIRRF(Double faixaIRRF) {
        this.faixaIRRF = faixaIRRF;
    }

    public Double getIrrf() {
        return irrf;
    }

    public void setIrrf(Double irrf) {
        this.irrf = irrf;
    }

    public Double getSalarioLiquido() {
        return salarioLiquido;
    }

    public void setSalarioLiquido(Double salarioLiquido) {
        this.salarioLiquido = salarioLiquido;
    }

    public Salario(String nome, int dependentes, Double salarioBase) {
        this.nome = nome;
        this.dependentes = dependentes;
        this.salarioBase = salarioBase;
    }

    public Salario(String nome, int dependentes, Double salarioBase, Double faixaINSS, Double inss, Double salarioBaseIRRF, Double faixaIRRF, Double irrf, Double salarioLiquido) {
        this.nome = nome;
        this.dependentes = dependentes;
        this.salarioBase = salarioBase;
        this.faixaINSS = faixaINSS;
        this.inss = inss;
        this.salarioBaseIRRF = salarioBaseIRRF;
        this.faixaIRRF = faixaIRRF;
        this.irrf = irrf;
        this.salarioLiquido = salarioLiquido;
    }
}
