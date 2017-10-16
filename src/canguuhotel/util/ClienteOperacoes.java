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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * 
 */
public class ClienteOperacoes {
    
    Connection conexao = ConexaoBanco.getConexao();
    
    public void cadastrarCliente(Clientes cliente, JFrame frame) throws SQLException{
        if (verificaCpfCliente(cliente) == false){
            JOptionPane.showMessageDialog(frame, "CPF já cadastrado");
        } else {
            String sql = "INSERT INTO clientes (nome_completo, cpf, rg, email, telefone, data_nascimento) "
                + "VALUES (?,?,?,?,?,?)";
        PreparedStatement stmt = conexao.prepareStatement(sql);
        stmt.setString(1, cliente.getNome_completo());
        stmt.setString(2, cliente.getCpf());
        stmt.setString(3, cliente.getRg());
        stmt.setString(4, cliente.getEmail());
        stmt.setString(5, cliente.getTelefone());
        stmt.setString(6, cliente.getData_nascimento());
        stmt.execute();
        stmt.close();
        JOptionPane.showMessageDialog(frame, "Cadastrado com sucesso!");
        conexao.close();
        }
    }
    
    private boolean verificaCpfCliente(Clientes cliente) throws SQLException{
        List dadosCliente = new ArrayList();
        String sql = "SELECT * FROM clientes WHERE cpf = " + cliente.getCpf();  
        PreparedStatement banco = (PreparedStatement)conexao.prepareStatement(sql);
        banco.execute(); // cria o vetor com os resultados obtidos da consulta
        ResultSet resultado = banco.executeQuery(sql); //Execulta a query
        while(resultado.next()){
            dadosCliente.add(resultado.getString("nome_completo"));
        }
        if(dadosCliente.size() > 0){
            return false; 
        } else 
            return true;
    }
    
    public List getNomeClientes() throws SQLException{
        List dadosCliente = new ArrayList();
        String sql = "SELECT nome_completo FROM clientes";  
        PreparedStatement banco = (PreparedStatement)conexao.prepareStatement(sql);
        banco.execute(); // cria o vetor com os resultados obtidos da consulta
        ResultSet resultado = banco.executeQuery(sql); //Execulta a query
        while(resultado.next()){
            dadosCliente.add(resultado.getString("nome_completo"));
        }
        banco.close();
        conexao.close();
        return dadosCliente;
    }
    
    public ResultSet getClientesPeloCpf(String cpf) throws SQLException{
        String sql = "SELECT * FROM clientes WHERE cpf = "+ cpf;  
        PreparedStatement banco = (PreparedStatement)conexao.prepareStatement(sql);
        banco.execute(); // cria o vetor com os resultados obtidos da consulta
        ResultSet resultado = banco.executeQuery(sql); //Execulta a query
        return resultado;        
    }
    
    public void editarCliente(Clientes cliente, JFrame frame){
        String sql = "UPDATE clientes "
                + "SET nome_completo = ?, "
                + "cpf = ?, "
                + "rg =  ?, "
                + "email =  ?, "
                + "telefone =  ?, "
                + "data_nascimento = ? WHERE id = ? ";
        try {
            PreparedStatement banco = (PreparedStatement)conexao.prepareStatement(sql);
            banco.setString(1, cliente.getNome_completo());
            banco.setString(2, cliente.getCpf());
            banco.setString(3, cliente.getRg());
            banco.setString(4, cliente.getEmail());
            banco.setString(5, cliente.getTelefone());
            banco.setString(6, cliente.getData_nascimento());
            banco.setString(7, String.valueOf(cliente.getId()));
            banco.executeUpdate(); // cria o vetor com os resultados obtidos da consulta
            JOptionPane.showMessageDialog(frame, "Cliente atualizado com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Falha ao atualizar cliente");
            Logger.getLogger(ClienteOperacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deletarCliente(String cpf, JFrame frame){
        String sql = "DELETE FROM clientes WHERE cpf = ?";
        try {
            PreparedStatement banco = (PreparedStatement)conexao.prepareStatement(sql);
            banco.setString(1, cpf);
            banco.execute();
            JOptionPane.showMessageDialog(frame, "Cliente Excluido!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(frame, "Falha ao excluir!");
            Logger.getLogger(ClienteOperacoes.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
