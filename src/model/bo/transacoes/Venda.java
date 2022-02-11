package model.bo.transacoes;

import model.bo.pessoa.Cliente;
import model.bo.pessoa.Vendedor;
import java.time.LocalDateTime;


public class Venda extends Transacao {
    private int idVenda;
    private String serie;
    private Cliente cliente;
    private Vendedor vendedor;
    private int diaVencimento;
    
    public Venda(){
        
    }

    public Venda(int idVenda, String serie, Cliente cliente, Vendedor vendedor, int diaVencimento, LocalDateTime dtHora, float valorTotal, float valorDesconto, CondicaoPagamento condicaoPagamento) {
        super(dtHora, valorTotal, valorDesconto, condicaoPagamento);
        this.idVenda = idVenda;
        this.serie = serie;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.diaVencimento = diaVencimento;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public int getDiaVencimento() {
        return diaVencimento;
    }

    public void setDiaVencimento(int diaVencimento) {
        this.diaVencimento = diaVencimento;
    }

   @Override
    public String toString() {
        return super.toString()+ "\n" + this.getSerie() + "\n" + this.getCliente().getCpf() + "\n" + this.getVendedor().getCpf() + "\n" + this.getDiaVencimento();
    }
}
