package br.com.smarttec.message;

import java.util.Properties;

import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;

public class EmailMessage {

	private final String account = "phamtecnologia@outlook.com";
	private final String password = "Sistema123";
	private final String smtp = "smtp-mail.outlook.com";
	private final Integer port = 587;
			
	
	public void sendMessage(final String emailTo, final String subject, final String message) throws Exception{
		
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		senderImpl.setUsername(account);
		senderImpl.setPassword(password);
		senderImpl.setHost(smtp);
		senderImpl.setPort(port);
		
		
		Properties properties = new Properties();
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.auth", "true" );
		properties.put("mail.smtp.transport.protocol", "smtp");
		senderImpl.setJavaMailProperties(properties);
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
			
			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {
				
				MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
				helper.setFrom(account);
				helper.setTo(emailTo);
				helper.setSubject(subject);
				helper.setText(message);
				
			}
		};
		
		senderImpl.send(preparator);
		
	}
	


}
