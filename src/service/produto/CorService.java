package service.produto;

import java.util.List;

import model.DAO.produto.CorDAO;
import model.bo.produto.Cor;
import service.InterfaceService;

public class CorService implements InterfaceService<Cor> {

    @Override
    public void salvar(Cor obj) {
        CorDAO corDAO = new CorDAO();
        corDAO.create(obj);
    }

    @Override
    public List<Cor> buscar() {
        CorDAO corDAO = new CorDAO();
        return corDAO.read();
    }

    @Override
    public Cor buscar(int codigo) {
        CorDAO corDAO = new CorDAO();
        return corDAO.read(codigo);
    }

    @Override
    public Cor buscar(String descricao) {
        CorDAO corDAO = new CorDAO();
        return corDAO.read(descricao);
    }

    @Override
    public void atualizar(Cor obj) {
        CorDAO corDAO = new CorDAO();
        corDAO.update(obj);
    }

    @Override
    public void deletar(Cor obj) {
        CorDAO corDAO = new CorDAO();
        corDAO.delete(obj);
    }
}