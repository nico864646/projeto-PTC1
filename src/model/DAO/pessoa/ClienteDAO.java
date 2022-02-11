package model.DAO.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DAO.ConnectionFactory;
import model.DAO.InterfaceDAO;
import model.bo.endereco.Cep;
import model.bo.pessoa.Cliente;
import service.endereco.CepService;

public class ClienteDAO implements InterfaceDAO<Cliente> {

    @Override
    public void create(Cliente obj) {
        // Abre conexão
        Connection connection = ConnectionFactory.getConnection();

        String sqlExecutar = "INSERT INTO cliente (nomeCliente, dtNascCliente, cpfCliente, rgCliente, foneCliente, " +
                             "emailCliente, complementoEndCliente, endereco_idCep) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sqlExecutar);
            prepState.setString(1, obj.getNome());
            prepState.setString(2, obj.getDtNasc());
            prepState.setString(3, obj.getCpf());
            prepState.setString(4, obj.getRg());
            prepState.setString(5, obj.getFone());
            prepState.setString(6, obj.getEmail());
            prepState.setString(7, obj.getComplementoEnd());
            prepState.setInt(8, obj.getEnderecoCep().getIdCep());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // fechar a conexão
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public List<Cliente> read() {
        String sqlExecutar = "SELECT idCliente, nomeCliente, dtNascCliente, cpfCliente, rgCliente," +
                "foneCliente, emailCliente, complementoEndCliente, endereco_idCep FROM cliente";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        List<Cliente> clientes = new ArrayList<>();

        try {
            prepState = connection.prepareStatement(sqlExecutar);
            result = prepState.executeQuery();

            while (result.next()) {
                Cliente cliente = new Cliente();
                Cep cep = new Cep();
                CepService cepService = new CepService();
                
                cliente.setIdCliente(result.getInt("idCliente"));
                cliente.setNome(result.getString("nomeCliente"));
                cliente.setDtNasc(result.getString("dtNascCliente"));
                cliente.setCpf(result.getString("cpfCliente"));
                cliente.setRg(result.getString("rgCliente"));
                cliente.setFone(result.getString("foneCliente"));
                cliente.setEmail(result.getString("emailCliente"));
                cliente.setComplementoEnd(result.getString("complementoEndCliente"));

                cep = cepService.buscar(result.getInt("endereco_idCep"));
                cliente.setEnderecoCep(cep);

                clientes.add(cliente);
            }
            return clientes;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Cliente read(int codigo) {
        String sql = "SELECT idCliente, nomeCliente, dtNascCliente, cpfCliente, rgCliente, " +
                     "foneCliente, emailCliente, complementoEndCliente, endereco_idCep FROM cliente " +
                     "WHERE cliente.idCliente = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, codigo);
            result = prepState.executeQuery();

            Cliente cliente = new Cliente();
            Cep cep = new Cep();
            CepService cepService = new CepService();

            while (result.next()) {
                cliente.setIdCliente(result.getInt("idCliente"));
                cliente.setNome(result.getString("nomeCliente"));
                cliente.setDtNasc(result.getString("dtNascCliente"));
                cliente.setCpf(result.getString("cpfCliente"));
                cliente.setRg(result.getString("rgCliente"));
                cliente.setFone(result.getString("foneCliente"));
                cliente.setEmail(result.getString("emailCliente"));
                cliente.setComplementoEnd(result.getString("complementoEndCliente"));
                
                cep = cepService.buscar(result.getInt("endereco_idCep"));
                cliente.setEnderecoCep(cep);
            }
            return cliente;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Cliente read(String descricao) {
        String sql = "SELECT idCliente, nomeCliente, dtNascCliente, cpfCliente, rgCliente, " +
                     "foneCliente, emailCliente, complementoEndCliente, endereco_idCep FROM cliente " +
                     "WHERE cliente.cpfCliente = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, descricao);
            result = prepState.executeQuery();

            Cliente cliente = new Cliente();
            Cep cep = new Cep();
            CepService cepService = new CepService();

            while (result.next()) {
                cliente.setIdCliente(result.getInt("idCliente"));
                cliente.setNome(result.getString("nomeCliente"));
                cliente.setDtNasc(result.getString("dtNascCliente"));
                cliente.setCpf(result.getString("cpfCliente"));
                cliente.setRg(result.getString("rgCliente"));
                cliente.setFone(result.getString("foneCliente"));
                cliente.setEmail(result.getString("emailCliente"));
                cliente.setComplementoEnd(result.getString("complementoEndCliente"));

                cep = cepService.buscar(result.getInt("endereco_idCep"));
                cliente.setEnderecoCep(cep);
            }
            return cliente;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public void update(Cliente obj) {
        String sql = "UPDATE cliente SET nomeCliente = ? , dtNascCliente = ? , cpfCliente = ?, " +
                     "rgCliente = ? , foneCliente = ? , emailCliente = ? , complementoEndCliente = ? , endereco_idCep = ? " + 
                     "WHERE cliente.idCliente = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, obj.getNome());
            prepState.setString(2, obj.getDtNasc());
            prepState.setString(3, obj.getCpf());
            prepState.setString(4, obj.getRg());
            prepState.setString(5, obj.getFone());
            prepState.setString(6, obj.getEmail());
            prepState.setString(7, obj.getComplementoEnd());
            prepState.setInt(8, obj.getEnderecoCep().getIdCep());
            prepState.setInt(9, obj.getIdCliente());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public void delete(Cliente obj) {
        String sql = "DELETE FROM cliente WHERE idCliente = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, obj.getIdCliente());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }
}