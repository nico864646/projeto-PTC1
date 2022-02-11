package model.DAO.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DAO.ConnectionFactory;
import model.DAO.InterfaceDAO;
import model.bo.endereco.Bairro;
import model.bo.endereco.Cep;
import model.bo.endereco.Cidade;
import service.endereco.BairroService;
import service.endereco.CidadeService;

public class CepDAO implements InterfaceDAO<Cep> {

    @Override
    public void create(Cep obj) {
        // Abre conexão
        Connection connection = ConnectionFactory.getConnection();

        String sqlExecutar = "INSERT INTO endereco (cepCep, logradouroCep, bairro_idBairro, cidade_idCidade) " +
                             "VALUES (?, ?, ?, ?)";

        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sqlExecutar);
            prepState.setString(1, obj.getCep());
            prepState.setString(2, obj.getLogradouro());
            prepState.setInt(3, obj.getBairro().getIdBairro());
            prepState.setInt(4, obj.getCidade().getIdCidade());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // fechar a conexão
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public List<Cep> read() {
        String sqlExecutar = "SELECT idCep, cepCep, logradouroCep, bairro_idBairro, cidade_idCidade FROM endereco";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        List<Cep> ceps = new ArrayList<>();

        try {
            prepState = connection.prepareStatement(sqlExecutar);
            result = prepState.executeQuery();

            while (result.next()) {
                Bairro bairro = new Bairro();
                Cep cep = new Cep();
                Cidade cidade = new Cidade();
                BairroService bService = new BairroService();
                CidadeService cService = new CidadeService();

                cep.setIdCep(result.getInt("idCep"));
                cep.setCep(result.getString("cepCep"));
                cep.setLogradouro(result.getString("logradouroCep"));

                bairro = bService.buscar(result.getInt("bairro_idBairro"));
                cidade = cService.buscar(result.getInt("cidade_idCidade"));
                cep.setBairro(bairro);
                cep.setCidade(cidade);

                ceps.add(cep);
            }

            return ceps;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Cep read(int codigo) {
        String sql = "SELECT idCep, cepCep, logradouroCep, bairro_idBairro, cidade_idCidade FROM endereco WHERE endereco.idCep = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, codigo);
            result = prepState.executeQuery();

            Cep cep = new Cep();
            Bairro bairro = new Bairro();
            Cidade cidade = new Cidade();
            BairroService bService = new BairroService();
            CidadeService cService = new CidadeService();

            while (result.next()) {
                cep.setIdCep(result.getInt("idCep"));
                cep.setCep(result.getString("cepCep"));
                cep.setLogradouro(result.getString("logradouroCep"));
                bairro = bService.buscar(result.getInt("bairro_idBairro"));
                cidade = cService.buscar(result.getInt("cidade_idCidade"));
                cep.setBairro(bairro);
                cep.setCidade(cidade);
            }

            return cep;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Cep read(String descricao) {
        String sql = "SELECT idCep, cepCep, logradouroCep, bairro_idBairro, cidade_idCidade FROM endereco WHERE endereco.cepCep = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, descricao);
            result = prepState.executeQuery();

            Cep cep = new Cep();
            Bairro bairro = new Bairro();
            Cidade cidade = new Cidade();
            BairroService bService = new BairroService();
            CidadeService cService = new CidadeService();

            while (result.next()) {
                cep.setIdCep(result.getInt("idCep"));
                cep.setCep(result.getString("cepCep"));
                cep.setLogradouro(result.getString("logradouroCep"));
                bairro = bService.buscar(result.getInt("bairro_idBairro"));
                cidade = cService.buscar(result.getInt("cidade_idCidade"));
                cep.setBairro(bairro);
                cep.setCidade(cidade);
            }

            return cep;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public void update(Cep obj) {
        String sql = "UPDATE endereco SET cepCep = ?, logradouroCep = ?, bairro_idBairro = ?, cidade_idCidade = ? " +
                     "WHERE endereco.idCep = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, obj.getCep());
            prepState.setString(2, obj.getLogradouro());
            prepState.setInt(3, obj.getBairro().getIdBairro());
            prepState.setInt(4, obj.getCidade().getIdCidade());
            prepState.setInt(5, obj.getIdCep());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public void delete(Cep obj) {
        String sql = "DELETE FROM endereco WHERE idCep = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, obj.getIdCep());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }
}