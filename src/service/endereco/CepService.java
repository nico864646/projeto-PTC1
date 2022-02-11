package service.endereco;

import java.util.List;

import model.bo.endereco.Cep;
import model.DAO.endereco.CepDAO;
import service.InterfaceService;

public class CepService implements InterfaceService<Cep> {

    @Override
    public void salvar(Cep obj) {
        CepDAO cepDAO = new CepDAO();
        cepDAO.create(obj);
    }

    @Override
    public List<Cep> buscar() {
        CepDAO cepDAO = new CepDAO();
        return cepDAO.read();
    }

    @Override
    public Cep buscar(int codigo) {
        CepDAO cepDAO = new CepDAO();
        return cepDAO.read(codigo);
    }

    @Override
    public Cep buscar(String descricao) {
        CepDAO cepDAO = new CepDAO();
        return cepDAO.read(descricao);
    }

    @Override
    public void atualizar(Cep obj) {
        CepDAO cepDAO = new CepDAO();
        cepDAO.update(obj);
    }

    @Override
    public void deletar(Cep obj) {
        CepDAO cepDAO = new CepDAO();
        cepDAO.delete(obj);
    }
}