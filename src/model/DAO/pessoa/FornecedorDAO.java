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
import model.bo.pessoa.Fornecedor;
import service.endereco.CepService;

public class FornecedorDAO implements InterfaceDAO<Fornecedor> {

    @Override
    public void create(Fornecedor obj) {
        // Abre conexão
        Connection connection = ConnectionFactory.getConnection();

        String sqlExecutar = "INSERT INTO fornecedor (razaoSocialFornecedor, nomeFantasiaFornecedor, cnpjFornecedor, " +
                             "inscEstadualFornecedor, emailFornecedor, complementoEndfornecedor, endereco_idCep) " +
                             "VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sqlExecutar);
            prepState.setString(1, obj.getRazaoSocial());
            prepState.setString(2, obj.getNome());
            prepState.setString(3, obj.getCnpj());
            prepState.setString(4, obj.getInscEstadual());
            prepState.setString(5, obj.getEmail());
            prepState.setString(6, obj.getComplementoEnd());
            prepState.setInt(7, obj.getEnderecoCep().getIdCep());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // fechar a conexão
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public List<Fornecedor> read() {
        String sqlExecutar = "SELECT idFornecedor, razaoSocialFornecedor, nomeFantasiaFornecedor, cnpjFornecedor," +
                "inscEstadualFornecedor, emailFornecedor, complementoEndFornecedor, endereco_idCep FROM fornecedor";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        List<Fornecedor> fornecedores = new ArrayList<>();

        try {
            prepState = connection.prepareStatement(sqlExecutar);
            result = prepState.executeQuery();

            while (result.next()) {
                Fornecedor fornecedor = new Fornecedor();
                Cep cep = new Cep();
                CepService cepService = new CepService();
                
                fornecedor.setIdFornecedor(result.getInt("idFornecedor"));
                fornecedor.setRazaoSocial(result.getString("razaoSocialFornecedor"));
                fornecedor.setNome(result.getString("nomeFantasiaFornecedor"));
                fornecedor.setCnpj(result.getString("cnpjFornecedor"));
                fornecedor.setInscEstadual(result.getString("inscEstadualFornecedor"));
                fornecedor.setEmail(result.getString("emailFornecedor"));
                fornecedor.setComplementoEnd(result.getString("complementoEndFornecedor"));

                cep = cepService.buscar(result.getInt("endereco_idCep"));
                fornecedor.setEnderecoCep(cep);

                fornecedores.add(fornecedor);
            }
            return fornecedores;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Fornecedor read(int codigo) {
        String sqlExecutar = "SELECT idFornecedor, razaoSocialFornecedor, nomeFantasiaFornecedor, cnpjFornecedor, " +
                             "inscEstadualFornecedor, emailFornecedor, complementoEndFornecedor, endereco_idCep FROM fornecedor " +
                             "WHERE fornecedor.idFornecedor = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sqlExecutar);
            prepState.setInt(1, codigo);
            result = prepState.executeQuery();

            Fornecedor fornecedor = new Fornecedor();
            Cep cep = new Cep();
            CepService cepService = new CepService();

            while (result.next()) {
                fornecedor.setIdFornecedor(result.getInt("idFornecedor"));
                fornecedor.setRazaoSocial(result.getString("razaoSocialFornecedor"));
                fornecedor.setNome(result.getString("nomeFantasiaFornecedor"));
                fornecedor.setCnpj(result.getString("cnpjFornecedor"));
                fornecedor.setInscEstadual(result.getString("inscEstadualFornecedor"));
                fornecedor.setEmail(result.getString("emailFornecedor"));
                fornecedor.setComplementoEnd(result.getString("complementoEndFornecedor"));

                cep = cepService.buscar(result.getInt("endereco_idCep"));
                fornecedor.setEnderecoCep(cep);
            }
            return fornecedor;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Fornecedor read(String descricao) {
        String sql =  "SELECT idFornecedor, razaoSocialFornecedor, nomeFantasiaFornecedor, cnpjFornecedor, " +
                      "inscEstadualFornecedor, emailFornecedor, complementoEndFornecedor, endereco_idCep FROM fornecedor " +
                      "WHERE fornecedor.cnpjFornecedor = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, descricao);
            result = prepState.executeQuery();

            Fornecedor fornecedor = new Fornecedor();
            Cep cep = new Cep();
            CepService cepService = new CepService();

            while (result.next()) {
                fornecedor.setIdFornecedor(result.getInt("idFornecedor"));
                fornecedor.setRazaoSocial(result.getString("razaoSocialFornecedor"));
                fornecedor.setNome(result.getString("nomeFantasiaFornecedor"));
                fornecedor.setCnpj(result.getString("cnpjFornecedor"));
                fornecedor.setInscEstadual(result.getString("inscEstadualFornecedor"));
                fornecedor.setEmail(result.getString("emailFornecedor"));
                fornecedor.setComplementoEnd(result.getString("complementoEndFornecedor"));
                cep = cepService.buscar(result.getInt("endereco_idCep"));
                fornecedor.setEnderecoCep(cep);
            }
            return fornecedor;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public void update(Fornecedor obj) {
        String sql = "UPDATE fornecedor SET razaoSocialFornecedor = ? , nomeFantasiaFornecedor = ? , cnpjFornecedor = ?, " +
                     "inscEstadualFornecedor = ? , emailFornecedor = ? , complementoEndFornecedor = ? , endereco_idCep = ? " + 
                     "WHERE fornecedor.idFornecedor = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, obj.getRazaoSocial());
            prepState.setString(2, obj.getNome());
            prepState.setString(3, obj.getCnpj());
            prepState.setString(4, obj.getInscEstadual());
            prepState.setString(5, obj.getEmail());
            prepState.setString(6, obj.getComplementoEnd());
            prepState.setInt(7, obj.getEnderecoCep().getIdCep());
            prepState.setInt(8, obj.getIdFornecedor());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public void delete(Fornecedor obj) {
        String sql = "DELETE FROM fornecedor WHERE idFornecedor = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, obj.getIdFornecedor());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }
}