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
	        mailSender.setHost("smtp.qq.com");//指定用来发送Email的邮件服务器主机名
	        mailSender.setPort(587);//默认端口，标准的SMTP端口
	        mailSender.setUsername("2484811313@qq.com");//用户名
	        mailSender.setPassword("nkbyehhwjcmzdhgg");//密码
	        return mailSender;
	    }

	}

