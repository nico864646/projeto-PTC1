package model.bo.transacoes;
import java.time.LocalDateTime;
import java.util.Date;

public abstract class Conta {
    private LocalDateTime dtHrEmissao;
    private LocalDateTime dtHrPagamento;
    private Date dtVencimento;
    private float valorEmissao;
    private float valPago;
    private float desconto;
    private float acrescimo;
    private char status;
    
    public Conta(){
        
    }

    public Conta(LocalDateTime dtHrEmissao, LocalDateTime dtHrPagamento, Date dtVencimento, float valorEmissao, float valPago, float desconto, float acrescimo, char status) {
        this.dtHrEmissao = dtHrEmissao;
        this.dtHrPagamento = dtHrPagamento;
        this.dtVencimento = dtVencimento;
        this.valorEmissao = valorEmissao;
        this.valPago = valPago;
        this.desconto = desconto;
        this.acrescimo = acrescimo;
        this.status = status;
    }

    public LocalDateTime getDtHrEmissao() {
        return dtHrEmissao;
    }

    public LocalDateTime getDtHrPagamento() {
        return dtHrPagamento;
    }

    public Date getDtVencimento() {
        return dtVencimento;
    }

    public float getValorEmissao() {
        return valorEmissao;
    }

    public float getValPago() {
        return valPago;
    }

    public float getDesconto() {
        return desconto;
    }

    public float getAcrescimo() {
        return acrescimo;
    }

    public char getStatus() {
        return status;
    }

    public void setDtHrEmissao(LocalDateTime dtHrEmissao) {
        this.dtHrEmissao = dtHrEmissao;
    }

    public void setDtHrPagamento(LocalDateTime dtHrPagamento) {
        this.dtHrPagamento = dtHrPagamento;
    }

    public void setDtVencimento(Date dtVencimento) {
        this.dtVencimento = dtVencimento;
    }

    public void setValorEmissao(float valorEmissao) {
        this.valorEmissao = valorEmissao;
    }

    public void setValPago(float valPago) {
        this.valPago = valPago;
    }

    public void setDesconto(float desconto) {
        this.desconto = desconto;
    }

    public void setAcrescimo(float acrescimo) {
        this.acrescimo = acrescimo;
    }

    public void setStatus(char status) {
        this.status = status;
    }
    
    @Override
    public String toString() {
        return this.getDtHrEmissao()+ "\n" + this.getDtHrPagamento() + "\n" + this.getDtVencimento() + "\n" + this.getValorEmissao() + "\n" + this.getValPago() + "\n" + this.getDesconto() + "\n" + this.getAcrescimo() + "\n" + this.getStatus();
    }
    
}
