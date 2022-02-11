package model.bo.pessoa;

import model.bo.endereco.Cep;

public class Cliente extends Pessoa {
    private int idCliente;
    private String cpf;
    private String rg;
    private String dtNasc;
    
    public Cliente(){
    }

    public Cliente(int idCliente, String cpf, String rg, String dtNasc, String nome, String email, String fone, Cep enderecoCep, String complementoEnd) {
        super(nome, email, fone, enderecoCep, complementoEnd);
        this.idCliente = idCliente;
        this.cpf = cpf;
        this.rg = rg;
        this.dtNasc = dtNasc;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDtNasc() {
        return dtNasc;
    }

    public void setDtNasc(String dtNasc) {
        this.dtNasc = dtNasc;
    }
    
    @Override
    public String toString() {
        return super.toString() 
                + this.getCpf() + "\n" 
                + this.getRg() + "\n" 
                + this.getDtNasc();
    }
    
}
