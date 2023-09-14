
/**
 @Author Reinaldo Couto
 RM: 94330
 TURMA: 2 SIT
 */

package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.Mensagem;

public class MensagemDAO {

    private Connection con;

    public MensagemDAO() throws SQLException {
        this.con = getConnection();
    }

    public void inclui(Mensagem m) throws SQLException {
        String sql = "INSERT INTO tbl_mensagem (assunto, destinatario, remetente, data, conteudo, prioridade) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);

        stmt.setString(1, m.getAssunto());
        stmt.setString(2, m.getDestinatario());
        stmt.setString(3, m.getRemetente());
        stmt.setDate(4, Date.valueOf(m.getData()));
        stmt.setString(5, m.getConteudo());
        stmt.setInt(6, m.getPrioridade());

        stmt.executeUpdate();
    }

    public List<Mensagem> recuperaTodas() throws SQLException {
        List<Mensagem> mensagens = new ArrayList<>();
        String sql = "SELECT * FROM tbl_mensagem";

        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Mensagem mensagem = new Mensagem();
                mensagem.setId(rs.getLong("id"));
                mensagem.setAssunto(rs.getString("assunto"));
                mensagem.setDestinatario(rs.getString("destinatario"));
                mensagem.setRemetente(rs.getString("remetente"));
                mensagem.setData(rs.getDate("data").toLocalDate());
                mensagem.setConteudo(rs.getString("conteudo"));
                mensagem.setPrioridade(rs.getInt("prioridade"));
                mensagens.add(mensagem);
            }
        }

        return mensagens;
    }

    // Outros métodos da classe...

    private Connection getConnection() throws SQLException {
        String url = "jdbc:oracle:thin:@//oracle.fiap.com.br:1521/orcl"; // Altere o host, porta e SID de acordo com o seu ambiente
        String user = "RM94330";
        String password = "fiap";

        try {
            // Carregar o driver JDBC Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver JDBC Oracle não encontrado: " + e.getMessage());
        }

        return DriverManager.getConnection(url, user, password);
    }

    public void close() throws SQLException {
        con.close();
    }
}
