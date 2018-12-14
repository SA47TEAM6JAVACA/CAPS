package email;
import static org.junit.Assert.assertEquals;
 
 import org.junit.Test;
 import org.junit.runner.RunWith;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.context.ApplicationContext;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.test.context.ContextConfiguration;
 import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

 
 @RunWith(SpringJUnit4ClassRunner.class)
 @ContextConfiguration(classes={RootConfig.class})
 @WebAppConfiguration
 public class EmailSenderTest {

	     @Autowired
	     private JavaMailSender mailSender;

	     @Test
	     public void sendSimpleEmail(){
	         SimpleMailMessage message = new SimpleMailMessage();
	         message.setFrom("2484811313@qq.com");
	         message.setTo("g82447088@163.com");
	         message.setSubject("Test");
	         message.setText("Enroll Successfule");
	         try {
	         mailSender.send(message);}
             catch (MailException ex) {http://localhost:8080/CAPS_TEAM6/common/login/admin
	            System.err.println("Fail Send" + ex.getMessage());
	           }
	         System.out.println("Email Send");
	     }

	 }
 

