package br.ufpb.dcx.lima.albiere;

import java.io.Serializable;
import java.util.Objects;

public class Contato implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private int diaAniversario;
    private int mesAniversario;

    public Contato(String nome, int dia, int mes) {
        this.nome = nome;
        this.diaAniversario = dia;
        this.mesAniversario = mes;
    }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getDiaAniversario() { return diaAniversario; }
    public void setDiaAniversario(int dia) { this.diaAniversario = dia; }
    public int getMesAniversario() { return mesAniversario; }
    public void setMesAniversario(int mes) { this.mesAniversario = mes; }

    @Override
    public String toString() {
        return "Contato [nome=" + nome + ", aniversario=" + diaAniversario + "/" + mesAniversario + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contato contato = (Contato) o;
        return Objects.equals(nome, contato.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}