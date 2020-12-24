package DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Doacao;

public class DoacaoDAO extends GenericDAO<Doacao> {

    private static final String DELETE = "DELETE FROM doacao WHERE CPF = ?";
    private static final String DELETE2 = "DELETE FROM doacao WHERE ID=?";
    private static final String SELECT = "SELECT * FROM doacao WHERE cpf=? ORDER BY data ASC";
    private static final String INSERT = "INSERT INTO doacao (cpf,valor,data) VALUES (?,?,?)";
    private static final String UPDATE = "UPDATE doacao SET VALOR=?, data=? WHERE CPF = ?";
    private static final String FIND = "SELECT * FROM doacao";
    private static final String SUM = "SELECT SUM(valor) as soma FROM doacao";
    private static final String UPT="UPDATE doacao";

    @Override
    public void cadastrar(Doacao obj) {
        String sql = INSERT;

        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);

            comando.setLong(1, obj.getCpf());
            comando.setDouble(2, obj.getValor());
            comando.setDate(3, (Date) obj.getData());
            
            comando.execute();

            comando.close();
            this.conexao.getConnection().close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void atualizar(Doacao obj) {
        String sql = UPDATE;

        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);

            comando.setDouble(1, obj.getValor());
            comando.setDate(2, (Date) obj.getData());

            comando.setLong(3, obj.getCpf());

            comando.executeUpdate();

            comando.close();
            this.conexao.getConnection().close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    public void atualizarT(String search) {
        String sql = UPT;
        
        if (search != null && !search.isEmpty()) {
            sql += search;
        }
        System.out.println(sql);

        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);
            
            comando.executeUpdate();

            comando.close();
            this.conexao.getConnection().close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void remover(Doacao obj) {
        String sql = DELETE2;
        
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

    public ArrayList<Doacao> listDoacoes(String search, long cpf) {
        String sql = SELECT;
        
        if (search != null && !search.isEmpty()) {
            sql += search;
        }

        ArrayList<Doacao> objects;
        objects = new ArrayList<Doacao>();

        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);
            comando.setLong(1,cpf);
            ResultSet resultSet = comando.executeQuery();

            while (resultSet.next()) {
                Doacao doacao = new Doacao();
                doacao.setCpf(resultSet.getLong("cpf"));
                doacao.setValor(resultSet.getFloat("valor"));
                doacao.setData(resultSet.getDate("data"));
                doacao.setId(resultSet.getInt("id"));
                System.out.println(resultSet.getInt("id"));
                objects.add(doacao);
            }

            comando.close();
            this.conexao.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return objects;
    }

   @Override
    public ArrayList<Doacao> consultar(String search) {
       String sql = FIND;
        
        if(search !=null && !search.trim().isEmpty()){
            sql += search;
        }

        ArrayList<Doacao> objects;
        objects = new ArrayList<Doacao>();

        try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);
            ResultSet resultSet = comando.executeQuery();

            while (resultSet.next()) {
                Doacao doacao = new Doacao();
                doacao.setCpf(resultSet.getLong("cpf"));
                doacao.setValor(resultSet.getFloat("valor"));
                doacao.setData(resultSet.getDate("data"));
                objects.add(doacao);
            }

            comando.close();
            this.conexao.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return objects;
    }
    
    public float consultarDoacoes() {
    
        String sql = SUM;
    
    float somatorio = 0;
    
    try {
            PreparedStatement comando = this.conexao.getConnection().prepareStatement(sql);
            ResultSet resultSet = comando.executeQuery();
    
    while(resultSet.next()){
        somatorio = resultSet.getFloat("soma");
    }
    comando.close();
            this.conexao.getConnection().close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    return somatorio;
        
    }
    
}
