package service.produto;

import java.util.List;

import model.DAO.produto.TamanhoDAO;
import model.bo.produto.Tamanho;
import service.InterfaceService;

public class TamanhoService implements InterfaceService<Tamanho> {

    @Override
    public void salvar(Tamanho obj) {
        TamanhoDAO tamanhoDAO = new TamanhoDAO();
        tamanhoDAO.create(obj);
    }

    @Override
    public List<Tamanho> buscar() {
        TamanhoDAO tamanhoDAO = new TamanhoDAO();
        return tamanhoDAO.read();
    }

    @Override
    public Tamanho buscar(int codigo) {
        TamanhoDAO tamanhoDAO = new TamanhoDAO();
        return tamanhoDAO.read(codigo);
    }

    @Override
    public Tamanho buscar(String descricao) {
        TamanhoDAO tamanhoDAO = new TamanhoDAO();
        return tamanhoDAO.read(descricao);
    }

    @Override
    public void atualizar(Tamanho obj) {
        TamanhoDAO tamanhoDAO = new TamanhoDAO();
        tamanhoDAO.update(obj);
    }

    @Override
    public void deletar(Tamanho obj) {
        TamanhoDAO tamanhoDAO = new TamanhoDAO();
        tamanhoDAO.delete(obj);
    }
}