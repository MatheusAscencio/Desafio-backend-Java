package com.challenge.backend.model.classes;

public class ProdCount {

    // Properties
    private Integer id;
    private Integer qtd = 0;


    // Constructors
    public ProdCount(Integer id, Integer qtd) {
        setId(id);
        setQtd(qtd);
    }

    public ProdCount() {}


    // Getters
    public Integer getId() { return this.id; }
    public Integer getQtd() { return this.qtd; }


    // Setters
    public void setId(Integer id) { this.id = id; }
    public void setQtd(Integer qtd) { this.qtd = qtd; }
}
