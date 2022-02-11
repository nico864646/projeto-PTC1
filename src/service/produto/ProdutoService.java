package service.produto;

import java.util.List;

import model.DAO.produto.ProdutoDAO;
import model.bo.produto.Produto;
import service.InterfaceService;

public class ProdutoService implements InterfaceService<Produto> {

    @Override
    public void salvar(Produto obj) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.create(obj);
    }

    @Override
    public List<Produto> buscar() {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.read();
    }

    @Override
    public Produto buscar(int codigo) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.read(codigo);
    }

    @Override
    public Produto buscar(String descricao) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        return produtoDAO.read(descricao);
    }

    @Override
    public void atualizar(Produto obj) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.update(obj);
    }

    @Override
    public void deletar(Produto obj) {
        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.delete(obj);
    }
}
