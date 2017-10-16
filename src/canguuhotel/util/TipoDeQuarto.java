package canguuhotel.util;

import java.sql.SQLException;
import javax.swing.JOptionPane;

public class TipoDeQuarto {
    private int id;
    private String nome;
    private String descricao;
    
    public void inserir() {
        try {
            String query
                    = "INSERT INTO tipo_de_quarto (nome, descricao) VALUES (?, ?)";

            ConexaoBanco.cmd = ConexaoBanco.getConexao().prepareStatement(query);
            ConexaoBanco.cmd.setString(1, this.nome);
            ConexaoBanco.cmd.setString(2, this.descricao);
            ConexaoBanco.cmd.executeUpdate();
            // Banco.leitor = Banco.cmd.executeQuery();

            // if (Banco.leitor.next()) {
            //    this.id = Banco.leitor.getInt(1);
            // }

            ConexaoBanco.cmd.close(); //FECHA CONEXÃO
        } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex.toString());
        }
    }
    
    public void editar () {
      try {
        String query
                    = "UPDATE tipo_de_quarto set nome = ? , descricao = ? WHERE id = ?";

            ConexaoBanco.cmd = ConexaoBanco.getConexao().prepareStatement(query);
            ConexaoBanco.cmd.setString(1, this.nome);
            ConexaoBanco.cmd.setString(2, this.descricao);
            ConexaoBanco.cmd.setInt(3, this.id);
            ConexaoBanco.cmd.executeUpdate();
      } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex.toString());
        }
    }
    
    public void deletar () {
      try {
        String query
                    = "DELETE FROM tipo_de_quarto WHERE id = ?";

            ConexaoBanco.cmd = ConexaoBanco.getConexao().prepareStatement(query);
            ConexaoBanco.cmd.setInt(1, this.id);
            ConexaoBanco.cmd.executeUpdate();
      } catch (SQLException ex) {
            JOptionPane.showConfirmDialog(null, ex.toString());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
        
}
