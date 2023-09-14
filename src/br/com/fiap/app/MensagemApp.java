package br.com.fiap.app;

import java.sql.SQLException;
import java.util.Scanner;
import br.com.fiap.dao.MensagemDAO;
import br.com.fiap.model.Mensagem;
import java.time.LocalDate;

public class MensagemApp {

    public static void main(String[] args) throws SQLException {
        MensagemDAO dao = new MensagemDAO();
        
        Scanner scanner = new Scanner(System.in); // Crie um objeto Scanner para ler a entrada do usuário

        // Solicita as informações da mensagem ao usuário
        System.out.println("Informe o assunto da mensagem:");
        String assunto = scanner.nextLine(); // Use o Scanner para ler a linha de entrada

        System.out.println("Informe o destinatário da mensagem:");
        String destinatario = scanner.nextLine();

        System.out.println("Informe o remetente da mensagem:");
        String remetente = scanner.nextLine();

        System.out.println("Informe o conteúdo da mensagem:");
        String conteudo = scanner.nextLine();

        // Cria uma nova mensagem com as informações fornecidas pelo usuário
        Mensagem mensagem = new Mensagem();
        mensagem.setAssunto(assunto);
        mensagem.setDestinatario(destinatario);
        mensagem.setRemetente(remetente);
        mensagem.setConteudo(conteudo);
        mensagem.setData(LocalDate.now());
        mensagem.setPrioridade(1);

        // Inclui a mensagem no banco de dados
        dao.inclui(mensagem);

        System.out.println("Mensagem incluída com sucesso!");

        // Não se esqueça de fechar o Scanner quando terminar de usá-lo
        scanner.close();
    }
}
