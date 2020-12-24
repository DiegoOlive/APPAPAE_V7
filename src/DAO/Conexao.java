package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {
    private String servidor;
    private String banco;
    private String usuario;
    private String senha;
    private Connection conexao;

    public Conexao() {
         this.servidor = "ec2-174-129-227-51.compute-1.amazonaws.com";
         this.banco = "df2nh4ajvk4a0u";
         this.usuario = "fugubhgqccdpxb";
         this.senha = "29aa56b8b8be47f02bcc51b4774f60041a33785003bb385dc2cf7e369ba55ccb";
    }    
    
    public Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            
            return DriverManager.getConnection("jdbc:postgresql://" + this.servidor + "/" + this.banco,
                    this.usuario, this.senha);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}