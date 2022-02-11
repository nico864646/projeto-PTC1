package model.bo.transacoes;

import java.time.LocalDateTime;
import java.util.Date;

public class Receber extends Conta{
    private int idReceber;
    private Venda venda;
    
    public Receber(){
        
    }

    public Receber(int idReceber, Venda venda, LocalDateTime dtHrEmissao, LocalDateTime dtHrPagamento, Date dtVencimento, float valorEmissao, float valPago, float desconto, float acrescimo, char status) {
        super(dtHrEmissao, dtHrPagamento, dtVencimento, valorEmissao, valPago, desconto, acrescimo, status);
        this.idReceber = idReceber;
        this.venda = venda;
    }

    public int getIdReceber() {
        return idReceber;
    }

    public void setIdReceber(int idReceber) {
        this.idReceber = idReceber;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public String toString() {
        return super.toString()+ "\n" + this.getVenda().toString();
    }
    
}
