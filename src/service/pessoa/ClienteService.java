package service.pessoa;

import java.util.List;

import model.bo.pessoa.Cliente;
import model.DAO.pessoa.ClienteDAO;
import service.InterfaceService;

public class ClienteService implements InterfaceService<Cliente> {

    @Override
    public void salvar(Cliente obj) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.create(obj);
    }

    @Override
    public List<Cliente> buscar() {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.read();
    }

    @Override
    public Cliente buscar(int codigo) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.read(codigo);
    }

    @Override
    public Cliente buscar(String descricao) {
        ClienteDAO clienteDAO = new ClienteDAO();
        return clienteDAO.read(descricao);
    }

    @Override
    public void atualizar(Cliente obj) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.update(obj);
    }

    @Override
    public void deletar(Cliente obj) {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.delete(obj);
    }
}