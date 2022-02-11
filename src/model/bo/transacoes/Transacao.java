package model.bo.transacoes;

import java.time.LocalDateTime;

public abstract class Transacao {
    private LocalDateTime dtHora;
    private float valorTotal;
    private float valorDesconto;
    private CondicaoPagamento condicaoPagamento;
    
    public Transacao(){
    
    }

    public Transacao(LocalDateTime dtHora, float valorTotal, float valorDesconto, CondicaoPagamento condicaoPagamento) {
        this.dtHora = dtHora;
        this.valorTotal = valorTotal;
        this.valorDesconto = valorDesconto;
        this.condicaoPagamento = condicaoPagamento;
    }

    public LocalDateTime getDtHora() {
        return dtHora;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public float getValorDesconto() {
        return valorDesconto;
    }

    public CondicaoPagamento getCondicaoPagamento() {
        return condicaoPagamento;
    }

    public void setDtHora(LocalDateTime dtHora) {
        this.dtHora = dtHora;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setValorDesconto(float valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public void setCondicaoPagamento(CondicaoPagamento condicaoPagamento) {
        this.condicaoPagamento = condicaoPagamento;
    }
    
    
    
}
