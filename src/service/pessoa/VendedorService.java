package service.pessoa;

import java.util.List;

import model.bo.pessoa.Vendedor;
import model.DAO.pessoa.VendedorDAO;
import service.InterfaceService;

public class VendedorService implements InterfaceService<Vendedor> {

    @Override
    public void salvar(Vendedor obj) {
        VendedorDAO vendedorDAO = new VendedorDAO();
        vendedorDAO.create(obj);
    }

    @Override
    public List<Vendedor> buscar() {
        VendedorDAO vendedorDAO = new VendedorDAO();
        return vendedorDAO.read();
    }

    @Override
    public Vendedor buscar(int codigo) {
        VendedorDAO vendedorDAO = new VendedorDAO();
        return vendedorDAO.read(codigo);
    }

    @Override
    public Vendedor buscar(String descricao) {
        VendedorDAO vendedorDAO = new VendedorDAO();
        return vendedorDAO.read(descricao);
    }

    @Override
    public void atualizar(Vendedor obj) {
        VendedorDAO vendedorDAO = new VendedorDAO();
        vendedorDAO.update(obj);
    }

    @Override
    public void deletar(Vendedor obj) {
        VendedorDAO vendedorDAO = new VendedorDAO();
        vendedorDAO.delete(obj);
    }
}