package email;

import org.springframework.context.annotation.Bean;
import org.springframework.mail.MailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

public class RootConfig {

	    /**
	     * 配置邮件发送器
	     */
	    @Bean
	    public MailSender mailSender() {
	        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	        mailSender.setHost("smtp.qq.com");
	        mailSender.setPort(587);
	        mailSender.setUsername("2484811313@qq.com");
	        mailSender.setPassword("nkbyehhwjcmzdhgg");
	        return mailSender;
	    }

	}

