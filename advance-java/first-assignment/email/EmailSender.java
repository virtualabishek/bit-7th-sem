import java.util.Properties;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;

public class EmailSender {
    public static void main(String[] args) {
        String smtpHost = getEnvOrDefault("SMTP_HOST", "smtp.gmail.com");
        String smtpPort = getEnvOrDefault("SMTP_PORT", "465");
        String smtpUser = getEnvOrDefault("SMTP_USER", "codewithabishek@gmail.com");
        String smtpPass = System.getenv("SMTP_PASS");

        if (smtpPass == null || smtpPass.isBlank()) {
            System.err.println("SMTP_PASS is missing. Set it as an environment variable.");
            return;
        }

        // Usage: java EmailSender <toEmail> <subject> <message>
        String toEmail = args.length > 0 ? args[0] : smtpUser;
        String subject = args.length > 1 ? args[1] : "Test Email from Java";
        String body = args.length > 2 ? args[2] : "Hello! This email was sent using Java Mail API over SMTP.";

        Properties props = new Properties();
        props.put("mail.smtp.host", smtpHost);
        props.put("mail.smtp.port", smtpPort);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.ssl.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(smtpUser, smtpPass);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(smtpUser));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(body);

            Transport.send(message);
            System.out.println("Email sent successfully to: " + toEmail);
        } catch (MessagingException e) {
            System.err.println("Failed to send email: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String getEnvOrDefault(String key, String defaultValue) {
        String value = System.getenv(key);
        if (value == null || value.isBlank()) {
            return defaultValue;
        }
        return value;
    }
}
