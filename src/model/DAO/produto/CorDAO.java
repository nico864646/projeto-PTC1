package model.DAO.produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DAO.ConnectionFactory;
import model.DAO.InterfaceDAO;
import model.bo.produto.Cor;

public class CorDAO implements InterfaceDAO<Cor>{

    @Override
    public void create(Cor obj) {
        Connection connection = ConnectionFactory.getConnection();
        
        String sql = "INSERT INTO cor (descricaoCor) VALUES (?)";
        
        PreparedStatement prepState = null;
        
        try{
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, obj.getDescricao());
            prepState.executeUpdate();
            
        } 
        catch(SQLException ex){
            ex.printStackTrace();
        } 
        finally{
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public List<Cor> read() {
        String sql = "SELECT idCor, descricaoCor FROM cor";
        
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;

        List<Cor> cores = new ArrayList<>();
        
        try{
            prepState = connection.prepareStatement(sql);
            result = prepState.executeQuery();
            
            while(result.next()){
                Cor cor = new Cor();
                cor.setIdCor(result.getInt("idCor"));
                cor.setDescricao(result.getString("descricaoCor"));
                cores.add(cor);
            }

            return cores;
        } 
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
        finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Cor read(int codigo) {
        String sql = "SELECT idCor, descricaoCor FROM cor WHERE cor.idCor = ?";
        
        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;
        
        try{
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, codigo);
            result = prepState.executeQuery();
            Cor cor = new Cor();
            
            while(result.next()){
                cor.setIdCor(result.getInt("idCor"));
                cor.setDescricao(result.getString("descricaoCor"));
            }

            return cor;

        } catch(SQLException ex){
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public Cor read(String descricao) {
        String sql = "SELECT idCor, descricaoCor FROM cor WHERE cor.descricaoCor = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        ResultSet result = null;
        
        try{
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, descricao);
            result = prepState.executeQuery();
            Cor cor = new Cor();

            while(result.next()){
                cor.setIdCor(result.getInt("idCor"));
                cor.setDescricao(result.getString("descricaoCor"));
            }

            return cor;
        } catch(SQLException ex){
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(connection, prepState, result);
        }
    }

    @Override
    public void update(Cor obj) {
        String sql = "UPDATE cor SET descricaoCor = ? WHERE cor.idCor = ?";

        Connection connection = ConnectionFactory.getConnection();
        PreparedStatement prepState = null;
        
        try {
            prepState = connection.prepareStatement(sql);
            prepState.setString(1, obj.getDescricao());
            prepState.setInt(2, obj.getIdCor());
            prepState.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

    @Override
    public void delete(Cor obj) {
        Connection connection =  ConnectionFactory.getConnection();
        
        String sql = "DELETE FROM cor WHERE idCor = ?";

        PreparedStatement prepState = null;

        try {
            prepState = connection.prepareStatement(sql);
            prepState.setInt(1, obj.getIdCor());
            prepState.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally{
            ConnectionFactory.closeConnection(connection, prepState);
        }
    }

}