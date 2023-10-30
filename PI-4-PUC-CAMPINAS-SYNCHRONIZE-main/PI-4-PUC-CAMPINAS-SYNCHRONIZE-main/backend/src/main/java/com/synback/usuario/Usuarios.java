package com.synback.usuario;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;

@EntityScan
@Document(collection = "Usuarios")
public class Usuarios {

    @Id
    private String id;
    private String nome;
    private Date dataNascimento;
    private double altura;
    private double peso;
    private String genero;
    private double tempoMedioExerciciosPorMinuto;
    private String possuiHistoricoDoencaNaFamilia;

    public Usuarios() {}



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public double getTempoMedioExerciciosPorMinuto() {
        return tempoMedioExerciciosPorMinuto;
    }

    public void setTempoMedioExerciciosPorMinuto(double tempoMedioExerciciosPorMinuto) {
        this.tempoMedioExerciciosPorMinuto = tempoMedioExerciciosPorMinuto;
    }

    public String isPossuiHistoricoDoencaNaFamilia() {
        return possuiHistoricoDoencaNaFamilia;
    }

    public void setPossuiHistoricoDoencaNaFamilia(String possuiHistoricoDoencaNaFamilia) {
        this.possuiHistoricoDoencaNaFamilia = possuiHistoricoDoencaNaFamilia;
    }
}
