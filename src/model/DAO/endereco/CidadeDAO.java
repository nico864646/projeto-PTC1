package model.DAO.endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DAO.ConnectionFactory;
import model.DAO.InterfaceDAO;
import model.bo.endereco.Cidade;

public class CidadeDAO implements InterfaceDAO<Cidade> {

    @Override
    public void create(Cidade obj) {
        // Abre conexão
        Connection connection = ConnectionFactory.getConnection();

        String sql = "INSERT INTO cidade (descricaoCidade, ufCidade) VALUES (?, ?)";

        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, obj.getDescricao());
            prepState.setString(2, obj.getUf());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // fechar a conexão
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public List<Cidade> read() {
        String sql = "SELECT idCidade, descricaoCidade, ufCidade FROM cidade";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        List<Cidade> cidades = new ArrayList<>();

        try {
            prepState = connection.prepareStatement(sql);
            result = prepState.executeQuery();

            while (result.next()) {
                Cidade cidade = new Cidade();
                cidade.setIdCidade(result.getInt("idCidade"));
                cidade.setDescricao(result.getString("descricaoCidade"));
                cidade.setUf(result.getString("ufCidade"));
                cidades.add(cidade);
            }

            return cidades;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Cidade read(int codigo) {
        String sql = "SELECT idCidade, descricaoCidade, ufCidade FROM cidade WHERE cidade.idCidade = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, codigo);
            result = prepState.executeQuery();
            Cidade cidade = new Cidade();

            while (result.next()) {
                cidade.setIdCidade(result.getInt("idCidade"));
                cidade.setDescricao(result.getString("descricaoCidade"));
                cidade.setUf(result.getString("ufCidade"));
            }

            return cidade;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Cidade read(String descricao) {
        String sql = "SELECT idCidade, descricaoCidade, ufCidade FROM cidade WHERE cidade.descricaoCidade = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, descricao);
            result = prepState.executeQuery();
            Cidade cidade = new Cidade();

            while (result.next()) {
                cidade.setIdCidade(result.getInt("idCidade"));
                cidade.setDescricao(result.getString("descricaoCidade"));
                cidade.setUf(result.getString("ufCidade"));
            }

            return cidade;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public void update(Cidade obj) {
        String sql = "UPDATE cidade SET descricaoCidade = ?, ufCidade = ? WHERE cidade.idCidade = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, obj.getDescricao());
            prepState.setString(2, obj.getUf());
            prepState.setInt(3, obj.getIdCidade());
            prepState.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public void delete(Cidade obj) {
        Connection connection = ConnectionFactory.getConnection();

        String sql = "DELETE FROM cidade WHERE idCidade = ?";

        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, obj.getIdCidade());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }
}