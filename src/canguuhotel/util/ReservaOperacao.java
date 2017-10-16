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
public class ReservaOperacao {
    
    Connection conexao = ConexaoBanco.getConexao();
    
    public void cadastrarReserva(Reservas reserva, JFrame frame, String cpf, String numQuarto) throws SQLException{
        if (getIdCliente(cpf) == 0){
            return;
        }
        String sql = "INSERT INTO reservas (quantidade_de_dias, checkin, checkout, numero_de_hospedes, id_quarto, id_cliente) "
                + "VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setInt(1, reserva.getQuantidade_de_dias());
        stmt.setString(2, reserva.getCheckin());
        stmt.setString(3, reserva.getCheckout());
        stmt.setInt(4, reserva.getNumero_de_hospedes());
        stmt.setInt(5, getIdQuarto(numQuarto));
        stmt.setInt(6, getIdCliente(cpf));
        stmt.execute();
        stmt.close();
        JOptionPane.showMessageDialog(frame, "Reserva realizada com sucesso!");
        conexao.close();
    }
    
    
    
    public int getIdCliente(String cpf) throws SQLException{
        int id = 0;
        String sql = "SELECT id FROM clientes WHERE cpf = " + cpf;  
        PreparedStatement banco = (PreparedStatement)conexao.prepareStatement(sql);
        banco.execute(); // cria o vetor com os resultados obtidos da consulta
        ResultSet resultado = banco.executeQuery(sql); //Execulta a query
        while (resultado.next()){
            id = resultado.getInt("id");
        }
        return id;
    }
    
    public int getIdQuarto(String numQuarto) throws SQLException{
        int id = 1;
        String sql = "SELECT id FROM quartos WHERE numero = " + numQuarto;  
        PreparedStatement banco = (PreparedStatement)conexao.prepareStatement(sql);
        banco.execute(); // cria o vetor com os resultados obtidos da consulta
        ResultSet resultado = banco.executeQuery(sql); //Execulta a query
        while (resultado.next()){
            id = resultado.getInt("id");
        }
        updateStatusQuarto(id);
        return id;
    }
    
    public void updateStatusQuarto(int id){
        String sql = "UPDATE quartos "
                + "SET disponivel = ? WHERE id = ? ";
        try {
            PreparedStatement banco = (PreparedStatement)conexao.prepareStatement(sql);
            banco.setString(1, "0");
            banco.setInt(2, id);
            banco.executeUpdate();
            banco.close();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteOperacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ResultSet getInformacaoReserva(String numeroQuarto) throws SQLException{
       String sql = "SELECT reservas.id, reservas.quantidade_de_dias, reservas.checkin, reservas.checkout, reservas.numero_de_hospedes "
                + "FROM quartos "
                + "INNER JOIN reservas ON quartos.id = reservas.id_quarto "
                + "WHERE quartos.numero = " + numeroQuarto;
        PreparedStatement banco = (PreparedStatement)conexao.prepareStatement(sql);
        banco.execute(); // cria o vetor com os resultados obtidos da consulta
        ResultSet resultado = banco.executeQuery(sql); //Execulta a query
        return resultado;        
    }
    
    public void updateReserva(Reservas reservas, JFrame frame){
        String sql = "UPDATE reservas"
                + " SET quantidade_de_dias = ?,"
                + " checkin = ?,"
                + " checkout = ?,"
                + " numero_de_hospedes = ?"
                + " WHERE id = ?";
        try {
            PreparedStatement banco = (PreparedStatement)conexao.prepareStatement(sql);
            banco.setInt(1, reservas.getQuantidade_de_dias());
            banco.setString(2, reservas.getCheckin());
            banco.setString(3, reservas.getCheckout());
            banco.setInt(4, reservas.getNumero_de_hospedes());
            banco.setInt(5, reservas.getId());
            banco.executeUpdate();
            banco.close();
            JOptionPane.showMessageDialog(frame, "Reserva atualizada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Falha na atualização!");
            System.out.println(ex);
        }
    }
    
    public void deletarReserva(int id, JFrame frame){
        String sql = "DELETE FROM reservas WHERE id = ?";
        try {
            PreparedStatement banco = (PreparedStatement)conexao.prepareStatement(sql);
            banco.setInt(1, id);
            banco.execute();
            JOptionPane.showMessageDialog(frame, "Reserva Excluida!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Falha ao excluir!");
            Logger.getLogger(ClienteOperacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
