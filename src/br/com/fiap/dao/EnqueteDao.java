package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import br.com.fiap.model.Enquete;
import br.com.fiap.model.Pergunta;

public class EnqueteDao implements Dao<Enquete> {

	@Override
	public Enquete recuperaPorId(long id) throws Exception {
		String sql = "SELECT e.id, e.nome, e.descricao, e.datacriacao, e.criador, p.id as idpergunta, p.questao, p.ordem, p.tipo FROM tbl_enquete e left join tbl_pergunta p on enq.id=p.enquete_id WHERE e.id = ?";
		Enquete enquete = null;
		try (Connection con = new ConnectionFactory().getConexao();
				PreparedStatement pstmt = con.prepareStatement(sql)) {  
			pstmt.setLong(1, id);
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				if (enquete == null) {
					enquete = new Enquete();
					enquete.setId(rs.getLong("id"));
					enquete.setNome(rs.getString("nome"));
					enquete.setDescricao(rs.getString("descricao"));
					enquete.setDataCriacao(rs.getDate("datacriacao").toLocalDate());
					enquete.setCriador(rs.getString("criador"));					
				}
				String questao = rs.getString("questao");
				if (questao != null) {
					Pergunta p = new Pergunta();
					p.setQuestao(questao);
					p.setOrdem(rs.getInt("ordem"));
					p.setTipo(rs.getInt("tipo"));
					p.setId(rs.getLong("idpergunta"));
					enquete.addPergunta(p);
				}
			}			
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		return enquete;
	}

	@Override
	public List<Enquete> recupera() throws Exception {
		String sql = "SELECT * FROM tbl_enquete ORDER BY datacriacao";
		List<Enquete> retorno = new LinkedList<>();

		try(Connection con = new ConnectionFactory().getConexao();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Enquete enq = new Enquete();
				enq.setId(rs.getLong("id"));
				enq.setNome(rs.getString("nome"));
				enq.setDescricao(rs.getString("descricao"));
				enq.setCriador(rs.getString("criador"));
				enq.setDataCriacao(rs.getDate("datacriacao").toLocalDate());

				retorno.add(enq);
			}	

		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retorno;
	}

	@Override
	public void altera(Enquete enq) throws Exception {
		String sql = "UPDATE tbl_enquete SET nome=?, descricao=?, criador=?, datacriacao=? WHERE id = ?";
		try(Connection con = new ConnectionFactory().getConexao();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, enq.getNome());
			pstmt.setString(2, enq.getDescricao());
			pstmt.setString(3, enq.getCriador());
			pstmt.setDate(4, Date.valueOf(enq.getDataCriacao()));
			pstmt.setLong(5, enq.getId());

			pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}		
	}

	@Override
	public void deleta(long id) throws Exception {
		String sql = "DELETE FROM tbl_enquete WHERE id = ?";
		try(Connection con = new ConnectionFactory().getConexao();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setLong(1, id);

			pstmt.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}		

	}



	@Override
	public void salva(Enquete enq) throws Exception {
		String sql = "INSERT INTO tbl_enquete(nome, descricao, criador, datacriacao) VALUES (?, ?, ?, ?)";
		try(Connection con = new ConnectionFactory().getConexao();
				PreparedStatement pstmt = con.prepareStatement(sql, new String[]{"id"})) {
			pstmt.setString(1, enq.getNome());
			pstmt.setString(2, enq.getDescricao());
			pstmt.setString(3, enq.getCriador());
			pstmt.setDate(4, Date.valueOf(enq.getDataCriacao()));

			pstmt.executeUpdate();

			//recuperando o id neste trecho de código
			ResultSet rs = pstmt.getGeneratedKeys();
			if (rs.next()) 
				enq.setId(rs.getBigDecimal(1).longValue());

		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}		
	}
}