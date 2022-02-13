package model.DAO.pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DAO.ConnectionFactory;
import model.bo.pessoa.FoneFornecedor;
import model.bo.pessoa.Fornecedor;
import service.pessoa.FornecedorService;

public class FoneFornecedorDAO {

    public void create(FoneFornecedor obj) {
        String sql = "INSERT INTO fonefornecedor (foneFornecedor, fornecedor_idfornecedor) " +
                     "VALUES (?, ?)";
        // Abre conexão
        Connection connection = ConnectionFactory.getConnection();

        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, obj.getDescricao());
            prepState.setInt(2, obj.getFornecedor().getIdFornecedor());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            // fechar a conexão
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    public List<FoneFornecedor> readBySupplierID(int codigo) {
        String sql = "SELECT idFone, foneFornecedor, fornecedor_idfornecedor " + 
                             "FROM fonefornecedor " +
                             "WHERE fornecedor_idfornecedor = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        List<FoneFornecedor> fones = new ArrayList<>();
        
        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, codigo);
            result = prepState.executeQuery();

            while (result.next()) {
                FoneFornecedor foneFornecedor = new FoneFornecedor();
                Fornecedor fornecedor = new Fornecedor();
                FornecedorService fService = new FornecedorService();

                foneFornecedor.setIdFone(result.getInt("idFone"));
                foneFornecedor.setDescricao(result.getString("foneFornecedor"));
                
                fornecedor = fService.buscar(result.getInt("fornecedor_idfornecedor"));
                foneFornecedor.setFornecedor(fornecedor);

                fones.add(foneFornecedor);
            }
            return fones;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }


    public FoneFornecedor readByID(int codigo) {
        String sql =  "SELECT idFone, foneFornecedor, fornecedor_idfornecedor FROM fonefornecedor " +
                      "WHERE fonefornecedor.idFone = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        FoneFornecedor foneFornecedor = new FoneFornecedor();
        Fornecedor fornecedor = new Fornecedor();
        FornecedorService fService = new FornecedorService();
        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, codigo);
            result = prepState.executeQuery();

            while (result.next()) {
                foneFornecedor.setIdFone(result.getInt("idFone"));
                foneFornecedor.setDescricao(result.getString("foneFornecedor"));
                
                fornecedor = fService.buscar(result.getInt("fornecedor_idfornecedor"));
                foneFornecedor.setFornecedor(fornecedor);
            }
            return foneFornecedor;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    public void update(FoneFornecedor obj) {
        String sql = "UPDATE fonefornecedor SET foneFornecedor = ?, fornecedor_idfornecedor = ? " + 
                     "WHERE fonefornecedor.idFone = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, obj.getDescricao());
            prepState.setInt(2, obj.getFornecedor().getIdFornecedor());
            prepState.setInt(3, obj.getIdFone());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    public void delete(FoneFornecedor obj) {
        String sql = "DELETE FROM fonefornecedor WHERE idFone = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, obj.getIdFone());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }
}
