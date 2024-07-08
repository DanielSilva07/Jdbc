package br.com.danielsilva.domain;

public class Produto {
    private  Long id;
    private String codigoP;
    private String nomeP;
    private Double precoP;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(String codigoP) {
        this.codigoP = codigoP;
    }

    public String getNomeP() {
        return nomeP;
    }

    public void setNomeP(String nomeP) {
        this.nomeP = nomeP;
    }

    public Double getPrecoP() {
        return precoP;
    }

    public void setPrecoP(Double precoP) {
        this.precoP = precoP;
    }
}
