package model.bo.transacoes;

import model.bo.pessoa.Fornecedor;
import java.time.LocalDateTime;


public class Compra extends Transacao{
    private int idCompra;
    private int numNF;
    private String serieNF;
    private Fornecedor fornecedor;
    
    public Compra(){
        
    }

    public Compra(int idCompra, int numNF, String serieNF, Fornecedor fornecedor, LocalDateTime dtHora, float valorTotal, float valorDesconto, CondicaoPagamento condicaoPagamento) {
        super(dtHora, valorTotal, valorDesconto, condicaoPagamento);
        this.idCompra = idCompra;
        this.numNF = numNF;
        this.serieNF = serieNF;
        this.fornecedor = fornecedor;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getNumNF() {
        return numNF;
    }

    public void setNumNF(int numNF) {
        this.numNF = numNF;
    }

    public String getSerieNF() {
        return serieNF;
    }

    public void setSerieNF(String serieNF) {
        this.serieNF = serieNF;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + this.getNumNF() + "\n" + this.getSerieNF() + "\n" + this.getFornecedor().getRazaoSocial();
    }
    
    
}
