package model.bo.pessoa;

import model.bo.endereco.Cep;
import java.util.Date;

public class Vendedor extends Pessoa{
    private int idVendedor;
    private String cpf;
    private float percentComissaoVenda;
    private float percentComissaoRecebto;
    
    public Vendedor(){
    }

    public Vendedor(int idVendedor, String cpf, float percentComissaoVenda, float percentComissaoRecebto, Date dtNasc, String nome, String email, String fone, Cep enderecoCep, String complementoEnd) {
        super(nome, email, fone, enderecoCep, complementoEnd);
        this.idVendedor = idVendedor;
        this.cpf = cpf;
        this.percentComissaoVenda = percentComissaoVenda;
        this.percentComissaoRecebto = percentComissaoRecebto;
    }

    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public float getPercentComissaoVenda() {
        return percentComissaoVenda;
    }

    public void setPercentComissaoVenda(float percentComissaoVenda) {
        this.percentComissaoVenda = percentComissaoVenda;
    }

    public float getPercentComissaoRecebto() {
        return percentComissaoRecebto;
    }

    public void setPercentComissaoRecebto(float percentComissaoRecebto) {
        this.percentComissaoRecebto = percentComissaoRecebto;
    }

    @Override
    public String toString() {
        return super.toString()
                + this.getCpf() + "\n"
                + this.getPercentComissaoVenda() + "\n" 
                + this.getPercentComissaoRecebto(); 
    }
    
}
