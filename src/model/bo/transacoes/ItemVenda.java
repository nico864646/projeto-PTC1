package model.bo.transacoes;
import model.bo.produto.CaractProd;

public class ItemVenda extends Item{
    private int idItemVenda;
    private Venda venda;

    public ItemVenda() {
    }

    public ItemVenda(int idItemVenda, Venda venda, float valUnitario, int qtdProduto, CaractProd caracteristicaProduto) {
        super(valUnitario, qtdProduto, caracteristicaProduto);
        this.idItemVenda = idItemVenda;
        this.venda = venda;
    }

    public int getIdItemVenda() {
        return idItemVenda;
    }

    public void setIdItemVenda(int idItemVenda) {
        this.idItemVenda = idItemVenda;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public String toString() {
        return super.toString()+ "\n" + this.getVenda().getSerie();
    }
    
    
}


