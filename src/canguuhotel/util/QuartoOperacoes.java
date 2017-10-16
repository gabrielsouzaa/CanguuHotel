/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package canguuhotel.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class QuartoOperacoes {
    
    Connection conexao = ConexaoBanco.getConexao();
    
    public void cadastrarQuarto(Quartos quarto, JFrame frame){
        try {
            String sql = "INSERT INTO quartos (numero, disponivel, id_tipo_quarto) VALUES (?, ?, ?)";
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setInt(1, quarto.getNumero());
            stmt.setInt(2, quarto.getDisponivel());
            stmt.setInt(3, quarto.getId_tipo());
            stmt.execute();
            stmt.close();
            JOptionPane.showMessageDialog(frame, "Cadastrado com sucesso!");
            conexao.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Falha ao cadastrar!");
        }
    }
    
    public void editarQuarto(Quartos quarto, JFrame frame){
        String sql = "UPDATE quartos SET disponivel = ?, id_tipo_quarto = ? WHERE numero = ? ";
        try {
            PreparedStatement banco = (PreparedStatement)conexao.prepareStatement(sql);
            banco.setInt(1, quarto.getDisponivel());
            banco.setInt(2, quarto.getId_tipo());
            banco.setInt(3, quarto.getNumero());
            banco.executeUpdate(); // cria o vetor com os resultados obtidos da consulta
            JOptionPane.showMessageDialog(frame, "Quarto atualizado com sucesso");
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Falha ao editar quarto");
            Logger.getLogger(ClienteOperacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet getQuartoPeloNumero(String numero) throws SQLException{
        if(numero.equals(""))
            return null;
        String sql = "SELECT * FROM quartos WHERE numero = "+ numero;  
        PreparedStatement banco = (PreparedStatement)conexao.prepareStatement(sql);
        banco.execute(); // cria o vetor com os resultados obtidos da consulta
        ResultSet resultado = banco.executeQuery(sql); //Execulta a query
        return resultado;        
    }
    
    public void deletarQuarto(String numero, JFrame frame){
        String sql = "DELETE FROM quartos WHERE numero = ?";
        try {
            PreparedStatement banco = (PreparedStatement)conexao.prepareStatement(sql);
            banco.setString(1, numero);
            banco.execute();
            JOptionPane.showMessageDialog(frame, "Quarto Excluido!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Falha ao excluir!");
            Logger.getLogger(ClienteOperacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
