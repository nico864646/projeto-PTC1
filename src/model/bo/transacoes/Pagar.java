package model.bo.transacoes;

import java.time.LocalDateTime;
import java.util.Date;

public class Pagar extends Conta{
    private int idPagar;
    private Compra compra;

    public Pagar(){
        
    }

    public Pagar(int idPagar, Compra compra, LocalDateTime dtHrEmissao, LocalDateTime dtHrPagamento, Date dtVencimento, float valorEmissao, float valPago, float desconto, float acrescimo, char status) {
        super(dtHrEmissao, dtHrPagamento, dtVencimento, valorEmissao, valPago, desconto, acrescimo, status);
        this.idPagar = idPagar;
        this.compra = compra;
    }

    public int getIdPagar() {
        return idPagar;
    }

    public void setIdPagar(int idPagar) {
        this.idPagar = idPagar;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }
    
   @Override
    public String toString() {
        return super.toString()+ "\n" + this.getCompra().toString();
    }
}
