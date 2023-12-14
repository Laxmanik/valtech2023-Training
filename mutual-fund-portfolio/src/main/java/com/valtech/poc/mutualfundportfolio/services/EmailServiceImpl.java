package com.valtech.poc.mutualfundportfolio.services;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.valtech.poc.mutualfundportfolio.entities.User;

import freemarker.template.Configuration;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailServiceImpl implements EmailService {

	private static final Logger logger = (Logger) LoggerFactory.getLogger(EmailServiceImpl.class);

	@Autowired
	private JavaMailSender javaMailSender;
	@Autowired
	private Configuration configuration;

	public EmailServiceImpl(JavaMailSender javaMailSender, Configuration configuration) {
		super();
		this.javaMailSender = javaMailSender;
		this.configuration = configuration;
	}

	@Override
	public void sendSimpleMessage(User user) throws Exception {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
		helper.setSubject("Mutualfund-portfolio UserId");
		helper.setTo(user.getEmail());
		String emailContent = getEmailContent(user);
		helper.setText(emailContent, true);
		javaMailSender.send(mimeMessage);

	}

	@Override
	public String getEmailContent(User user) throws Exception {
		StringWriter stringWriter = new StringWriter();
		Map<String, Object> model = new HashMap<>();
		model.put("user", user);
		configuration.getTemplate("emailtemplate.ftlh").process(model, stringWriter);
		return stringWriter.getBuffer().toString();

	}

}
