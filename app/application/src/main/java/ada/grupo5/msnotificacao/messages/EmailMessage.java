package ada.grupo5.msnotificacao.messages;

import ada.grupo5.msnotificacao.usecases.accounts.contracts.AccountNotificationRequest;
import ada.grupo5.msnotificacao.usecases.accounts.contracts.DependentRequestDto;

public class EmailMessage {

    public static String createAccountActivationEmail(AccountNotificationRequest user) {
        StringBuilder emailBody = new StringBuilder();
        emailBody.append("<html><body>");
        emailBody.append("<h1>Parabéns, sua conta no CardService foi criada!</h1>");
        emailBody.append("<p>Olá ").append(user.name()).append(",</p>");
        emailBody.append("<p>Sua conta foi criada com sucesso. Aqui estão os detalhes:</p>");
        emailBody.append("<ul>");
        emailBody.append("<li><strong>Nome do usuário:</strong> ").append(user.name()).append("</li>");
        emailBody.append("<li><strong>CPF:</strong> ").append(user.document()).append("</li>");
        emailBody.append("<li><strong>Final do cartão criado:</strong> ").append(user.creditCard()).append("</li>");
        emailBody.append("</ul>");
        emailBody.append("<p>Aqui estão os detalhes dos dependentes:</p>");
        emailBody.append("<table border=\"1\">");
        emailBody.append("<tr><th>Nome do Dependente</th><th>CPF</th><th>Final do Cartão</th></tr>");

        for (DependentRequestDto dependent : user.dependents()) {
            emailBody.append("<tr>");
            emailBody.append("<td>").append(dependent.name()).append("</td>");
            emailBody.append("<td>").append(dependent.document()).append("</td>");
            emailBody.append("<td>").append(dependent.creditCard()).append("</td>");
            emailBody.append("</tr>");
        }

        emailBody.append("</table>");
        emailBody.append("<p>Para ativar sua conta, use o seguinte código de 6 dígitos:</p>");
        emailBody.append("<h2>").append(user.code()).append("</h2>");
        emailBody.append("<p>Obrigado por escolher o CardService!</p>");
        emailBody.append("</body></html>");

        return emailBody.toString();
    }
}

