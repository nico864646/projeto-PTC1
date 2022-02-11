package model.bo.pessoa;

import model.bo.endereco.Cep;


public class Fornecedor extends Pessoa{
    private int idFornecedor;
    private String razaoSocial;
    private String cnpj;
    private String inscEstadual;
    
    public Fornecedor(){
        
    }

    public Fornecedor(int idFornecedor, String razaoSocial, String cnpj, String inscEstadual, String nome, String email, Cep enderecoCep, String complementoEnd) {
        super(nome, email, enderecoCep, complementoEnd);
        this.idFornecedor = idFornecedor;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.inscEstadual = inscEstadual;
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getInscEstadual() {
        return inscEstadual;
    }

    public void setInscEstadual(String inscEstadual) {
        this.inscEstadual = inscEstadual;
    }

    @Override
    public String toString() {
        return super.toString()
                + this.getCnpj() + "\n"
                + this.getInscEstadual() + "\n"
                + this.getRazaoSocial();
    }
} 
    