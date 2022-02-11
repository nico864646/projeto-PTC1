package model.bo.transacoes;


public class CondicaoPagamento {
    private int idCondicaoPagamento;
    private String descricao;
    private int numDiasAtePrimeiraParcela;
    private int numDiasEntreParcelas;
    
    public CondicaoPagamento(){
        
    }

    public int getIdCondicaoPagamento() {
        return idCondicaoPagamento;
    }

    public void setIdCondicaoPagamento(int idCondicaoPagamento) {
        this.idCondicaoPagamento = idCondicaoPagamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getNumDiasAtePrimeiraParcela() {
        return numDiasAtePrimeiraParcela;
    }

    public void setNumDiasAtePrimeiraParcela(int numDiasAtePrimeiraParcela) {
        this.numDiasAtePrimeiraParcela = numDiasAtePrimeiraParcela;
    }

    public int getNumDiasEntreParcelas() {
        return numDiasEntreParcelas;
    }

    public void setNumDiasEntreParcelas(int numDiasEntreParcelas) {
        this.numDiasEntreParcelas = numDiasEntreParcelas;
    }

    @Override
    public String toString() {
        return this.getDescricao()+ "\n" + this.getNumDiasAtePrimeiraParcela() + "\n" + this.getNumDiasEntreParcelas();
    }
}
