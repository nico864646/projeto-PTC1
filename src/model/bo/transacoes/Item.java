package model.bo.transacoes;
import model.bo.produto.CaractProd;

public abstract class Item {
    private float valUnitario;
    private int qtdProduto;
    private CaractProd caracteristicaProduto;

    public Item() {
    }

    public Item(float valUnitario, int qtdProduto, CaractProd caracteristicaProduto) {
        this.valUnitario = valUnitario;
        this.qtdProduto = qtdProduto;
        this.caracteristicaProduto = caracteristicaProduto;
    }

    public float getValUnitario() {
        return valUnitario;
    }

    public int getQtdProduto() {
        return qtdProduto;
    }

    public CaractProd getCaracteristicaProduto() {
        return caracteristicaProduto;
    }

    public void setValUnitario(float valUnitario) {
        this.valUnitario = valUnitario;
    }

    public void setQtdProduto(int qtdProduto) {
        this.qtdProduto = qtdProduto;
    }

    public void setCaracteristicaProduto(CaractProd caracteristicaProduto) {
        this.caracteristicaProduto = caracteristicaProduto;
    }
    
    @Override
    public String toString() {
        return this.getValUnitario()+ "\n" + this.getQtdProduto() + this.getCaracteristicaProduto().getProduto().getDescricao();
    }
    
}
