package model.bo.produto;


public class Produto {
    private int idProduto;
    private String descricao;
    private float valProduto;
    private Marca marca;
    private TipoProduto tipoProduto;
    private Tamanho tamanho;

    public Produto() {
    }

    public Produto(int idProduto, String descricao, float valProduto, Marca marca, TipoProduto tipoProduto, Tamanho tamanho) {
        this.idProduto = idProduto;
        this.descricao = descricao;
        this.valProduto = valProduto;
        this.marca = marca;
        this.tipoProduto = tipoProduto;
        this.tamanho = tamanho;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValProduto() {
        return valProduto;
    }

    public void setValProduto(float valProduto) {
        this.valProduto = valProduto;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }
    
     @Override
    public String toString() {
        return this.getDescricao()  + "\n" + this.getValProduto() + "\n" + this.getMarca().getDescricao() + "\n" + this.getTipoProduto().getDescricao() + "\n" + this.getTamanho().getDescricao();
    }
    
}
