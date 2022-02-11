package service.produto;

import java.util.List;

import model.DAO.produto.TipoProdutoDAO;
import model.bo.produto.TipoProduto;
import service.InterfaceService;

public class TipoProdutoService implements InterfaceService<TipoProduto> {

    @Override
    public void salvar(TipoProduto obj) {
        TipoProdutoDAO tipoProdDAO = new TipoProdutoDAO();
        tipoProdDAO.create(obj);
    }

    @Override
    public List<TipoProduto> buscar() {
        TipoProdutoDAO tipoProdDAO = new TipoProdutoDAO();
        return tipoProdDAO.read();
    }

    @Override
    public TipoProduto buscar(int codigo) {
        TipoProdutoDAO tipoProdDAO = new TipoProdutoDAO();
        return tipoProdDAO.read(codigo);
    }

    @Override
    public TipoProduto buscar(String descricao) {
        TipoProdutoDAO tipoProdDAO = new TipoProdutoDAO();
        return tipoProdDAO.read(descricao);
    }

    @Override
    public void atualizar(TipoProduto obj) {
        TipoProdutoDAO tipoProdDAO = new TipoProdutoDAO();
        tipoProdDAO.update(obj);
    }

    @Override
    public void deletar(TipoProduto obj) {
        TipoProdutoDAO tipoProdDAO = new TipoProdutoDAO();
        tipoProdDAO.delete(obj);
    }
}