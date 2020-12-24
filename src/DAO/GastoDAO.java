package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Gasto;
import modelo.Usuarios;
import visao.Tela_Inicial;

public class GastoDAO extends GenericDAO<Gasto> {

    private static final String DELETE = "DELETE FROM gasto WHERE id = ?";
    private static final String DELETE2 = "DELETE FROM gasto WHERE data = ? AND tipo = ?";
    private static final String FIND = "SELECT * FROM gasto";
    private static final String INSERT = "INSERT INTO gasto (tipo, valor, data,cpf) VALUES (?,?,?,?)";
    private static final String UPDATE = "UPDATE gasto SET TIPO=?, VALOR=?, DATA=?, WHERE id = ?";
    private static final String UPT = "UPDATE gasto";
    private static final String SUM = "SELECT sum(valor) as soma FROM gasto";

    @Override
    public void cadastrar(Gasto obj) {
        String sql = INSERT;
        Usuarios usuario=new Usuarios();
        Tela_Inicial ti=new Tela_Inicial();
        usuario=ti.getUsuario();
        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);
            comando.setString(1, obj.getTipo());
            comando.setDouble(2, obj.getValor());
            comando.setDate(3, (Date)obj.getData());
            comando.setLong(4, usuario.getCpf());
            
            comando.execute();
            comando.close();
            this.conexao.getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void atualizar(Gasto obj) {
        String sql = UPDATE;
        
        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);
            
            comando.setString(1, obj.getTipo());
            comando.setDouble(2, obj.getValor());
            comando.setDate(3, (Date) obj.getData());             
            comando.setInt(4, obj.getId());
            
            comando.executeUpdate();

            comando.close();
            this.conexao.getConnection().close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void remover(Gasto obj) {
        String sql = DELETE;
        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);
            comando.setInt(1, obj.getId());
            comando.execute();
            comando.close();
            this.conexao.getConnection().close();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public ArrayList<Gasto> consultar(String search) {
        String sql = FIND;

        if (search != null && !search.isEmpty()) {
            sql += search;
        }

        ArrayList<Gasto> objects;
        objects = new ArrayList<Gasto>();

        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);
            ResultSet resultSet = comando.executeQuery();

            while (resultSet.next()) {
                Gasto gasto = new Gasto();
                gasto.setData(resultSet.getDate("data"));
                gasto.setValor(resultSet.getFloat("valor"));               
                gasto.setTipo(resultSet.getString("tipo"));
                gasto.setId(resultSet.getInt("id"));
                
                objects.add(gasto);
            }

            comando.close();
            this.conexao.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return objects;
    }

    public void atualizarT(String search) {
        String sql = UPT;
        
        if (search != null && !search.isEmpty()) {
            sql += search;
        }
        
        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);

            comando.executeUpdate();
            comando.close();
            this.conexao.getConnection().close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public float consultarGastos() {
    
        String sql = SUM;
    
        float somatorio = 0;
    
        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);
            ResultSet resultSet = comando.executeQuery();
    
            while(resultSet.next()){
                somatorio =resultSet.getFloat("soma");
            }
            comando.close();
            this.conexao.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return somatorio;
        
    }
    
      public ArrayList<Gasto> consultaTudo(){
         String sql = FIND;
         
        ArrayList<Gasto> objects;
        objects = new ArrayList<Gasto>();

        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);
            ResultSet resultSet = comando.executeQuery();

            while (resultSet.next()) {
                Gasto gasto = new Gasto();
                gasto.setData(resultSet.getDate("data"));
                gasto.setValor(resultSet.getFloat("valor"));               
                gasto.setTipo(resultSet.getString("tipo"));

                objects.add(gasto);
            }

            comando.close();
            this.conexao.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         return objects;
     }
}
