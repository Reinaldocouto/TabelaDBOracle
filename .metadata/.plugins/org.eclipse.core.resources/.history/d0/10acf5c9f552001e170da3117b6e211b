package br.com.fiap.app;

import java.sql.SQLException;
import java.util.List;
import br.com.fiap.dao.MensagemDAO;
import br.com.fiap.model.Mensagem;

public class VisualizaMensagensApp {

    public static void main(String[] args) throws SQLException {
        MensagemDAO dao = new MensagemDAO();
        
        try {
            // Recupera todas as mensagens da tabela
            List<Mensagem> mensagens = dao.recuperaTodas();

            if (mensagens.isEmpty()) {
                System.out.println("Nenhuma mensagem encontrada.");
            } else {
                System.out.println("Mensagens encontradas:");
                for (Mensagem mensagem : mensagens) {
                    System.out.println("ID: " + mensagem.getId());
                    System.out.println("Assunto: " + mensagem.getAssunto());
                    System.out.println("Destinatário: " + mensagem.getDestinatario());
                    System.out.println("Remetente: " + mensagem.getRemetente());
                    System.out.println("Data: " + mensagem.getData());
                    System.out.println("Conteúdo: " + mensagem.getConteudo());
                    System.out.println("Prioridade: " + mensagem.getPrioridade());
                    System.out.println();
                }
            }
        } finally {
            // Não se esqueça de fechar a conexão com o banco de dados quando terminar
            dao.close();
        }
    }
}
