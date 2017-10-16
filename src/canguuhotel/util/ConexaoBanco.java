package canguuhotel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBanco { 
    
    public static PreparedStatement cmd; //PASSA UM COMANDO SQL
    public static ResultSet leitor;  //RECEBE OS DADOS DO SQL
    
    public static Connection getConexao(){
        
        Connection conexao = null;
        
        String url = "jdbc:mysql://gabrielsouzaa.com/gabriel1_lp2a4";
        String user = "gabriel1_lp2a4";
        String password = "123Mudar";
        
        try { 
            conexao = DriverManager.getConnection(url, user, password);
            System.out.println("BANCO CONECTADO");
        } catch (SQLException ex) {
            System.out.println("FALHA NA CONEXÃO");
            ex.printStackTrace();
        }
        
        return conexao;
    }

}
