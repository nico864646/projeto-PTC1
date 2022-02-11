package model.bo.pessoa;

import model.bo.endereco.Cep;

abstract class Pessoa {
    private String nome;
    private String email;
    private String fone;
    private Cep enderecoCep;
    private String complementoEnd;
    
    Pessoa() {

    }

    Pessoa(String nome, String email, String fone, Cep enderecoCep, String complementoEnd) {
        this.nome = nome;
        this.email = email;
        this.fone = fone;
        this.enderecoCep = enderecoCep;
        this.complementoEnd = complementoEnd;
    }

    Pessoa(String nome, String email, Cep enderecoCep, String complementoEnd) {
        this.nome = nome;
        this.email = email;
        this.enderecoCep = enderecoCep;
        this.complementoEnd = complementoEnd;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getFone() {
        return fone;
    }

    public Cep getEnderecoCep() {
        return enderecoCep;
    }

    public String getComplementoEnd() {
        return complementoEnd;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public void setEnderecoCep(Cep enderecoCep) {
        this.enderecoCep = enderecoCep;
    }

    public void setComplementoEnd(String complementoEnd) {
        this.complementoEnd = complementoEnd;
    }

    @Override
    public String toString() {
        return this.getNome()  + "\n" + this.getEmail() + "\n" + this.getEnderecoCep().getCep() + "\n" + this.getComplementoEnd() + "\n" + this.getFone() + "\n";
    }
   
    
}
