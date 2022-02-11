package model.bo.transacoes;
import model.bo.produto.CaractProd;


public class ItemCompra extends Item{
    private int idItemCompra;
    private Compra compra;

    public ItemCompra() {
    }

    public ItemCompra(int idItemCompra, Compra compra, float valUnitario, int qtdProduto, CaractProd caracteristicaProduto) {
        super(valUnitario, qtdProduto, caracteristicaProduto);
        this.idItemCompra = idItemCompra;
        this.compra = compra;
    }

    public int getIdItemCompra() {
        return idItemCompra;
    }

    public void setIdItemCompra(int idItemCompra) {
        this.idItemCompra = idItemCompra;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    @Override
    public String toString() {
        return super.toString()+ "\n" + this.getCompra().getSerieNF();
    }
    
}
