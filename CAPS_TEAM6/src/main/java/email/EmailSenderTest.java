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
	         SimpleMailMessage message = new SimpleMailMessage();//消息构造器
	         message.setFrom("2484811313@qq.com");//发件人
	         message.setTo("g82447088@163.com");//收件人
	         message.setSubject("Spring Email Test");//主题
	         message.setText("h5555!!");//正文
//	         try {
	         mailSender.send(message);
//	         }catch (MailException ex) {
//	            System.err.println("发送失败:" + ex.getMessage());
//	           }
	         System.out.println("邮件发送完毕");
	     }

	 }
//
//  
// 
//
//@RunWith(SpringJUnit4ClassRunner.class)
//public class EmailSenderTest {
//    public static void main(String[] args) {
//        //
//        sendTextEmail();
//    }
//    public static void sendTextEmail() {
//        //
//        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
//        // 参考QQ邮箱帮助中心
//        mailSender.setHost("smtp.qq.com"); // QQ邮箱smtp发送服务器地址
//        //mailSender.setPort(465); // QQ这个端口不可用
//        mailSender.setPort(587);// 端口号
//        mailSender.setUsername("2484811313@qq.com"); // 使用你自己的账号
//        mailSender.setPassword("nkbyehhwjcmzdhgg"); // 授权码-发短信获取
//        // 邮件信息
//        SimpleMailMessage msg = new SimpleMailMessage();
//        msg.setFrom("2484811313@qq.com"); // 发件人邮箱
//        msg.setTo("g82447088@163.com"); // 收件人邮箱
//        msg.setSubject("测试Spring邮件"); // 标题
//        msg.setText("您的订单号码: 20181120075; 请勿告诉别人!"); // 文本信息
//        try {
//            mailSender.send(msg);
//            System.out.println("邮件发送成功!"); // 没有报错就是好消息 :-)
//        } catch (MailException ex) {
//            System.err.println("发送失败:" + ex.getMessage());
//        }
//    }
//}
