package com.digilivros.controller;

import java.time.LocalDate;

public class FrequenciaDTO {

    public int getAluno() {
        return aluno;
    }

    public void setAluno(int aluno) {
        this.aluno = aluno;
    }

    public int getAula() {
        return aula;
    }

    public void setAula(int aula) {
        this.aula = aula;
    }

    private int aluno;
    private int aula;
    private String dataAula;

    public LocalDate getDataAula() {

    return LocalDate.parse(dataAula);

    }

    public void setDataAula(String dataAula) {
        this.dataAula = dataAula;
    }

}

