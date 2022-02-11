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

public class BairroDAO implements InterfaceDAO<Bairro> {

    @Override
    public void create(Bairro obj) {
        Connection connection = ConnectionFactory.getConnection();

        String sql = "INSERT INTO bairro (descricaoBairro) VALUES (?)";

        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, obj.getDescricao());
            prepState.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // fechar a conexão
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public List<Bairro> read() {
        String sql = "SELECT idBairro, descricaoBairro FROM bairro";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        List<Bairro> bairros = new ArrayList<>();

        try {
            prepState = connection.prepareStatement(sql);
            result = prepState.executeQuery();

            while (result.next()) {
                Bairro bairro = new Bairro();
                bairro.setIdBairro(result.getInt("idBairro"));
                bairro.setDescricao(result.getString("descricaoBairro"));
                bairros.add(bairro);
            }

            return bairros;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Bairro read(int codigo) {
        String sql = "SELECT idBairro, descricaoBairro FROM bairro WHERE bairro.idBairro = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, codigo);
            result = prepState.executeQuery();
            Bairro bairro = new Bairro();

            while (result.next()) {
                bairro.setIdBairro(result.getInt("idBairro"));
                bairro.setDescricao(result.getString("descricaoBairro"));
            }

            return bairro;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Bairro read(String descricao) {
        String sql = "SELECT idBairro, descricaoBairro FROM bairro WHERE bairro.descricaoBairro = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, descricao);
            result = prepState.executeQuery();
            Bairro bairro = new Bairro();

            while (result.next()) {
                bairro.setIdBairro(result.getInt("idBairro"));
                bairro.setDescricao(result.getString("descricaoBairro"));
            }

            return bairro;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public void update(Bairro obj) {
        String sql = "UPDATE bairro SET descricaoBairro = ? WHERE bairro.idBairro = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, obj.getDescricao());
            prepState.setInt(2, obj.getIdBairro());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public void delete(Bairro obj) {
        Connection connection = ConnectionFactory.getConnection();

        String sql = "DELETE FROM bairro WHERE idBairro = ?";

        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, obj.getIdBairro());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }
}