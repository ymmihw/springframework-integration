package com.ymmihw.springframework.email;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.mail.MessagingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import freemarker.template.TemplateException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class EmailServiceImplTest {

  @Autowired
  EmailService emailService;

  @Test
  public void whenSpringContextIsBootstrapped_thenNoExceptions() {}

  @Test
  public void testSendSimpleMessage() {
    emailService.sendSimpleMessage("whimmy@126.com", "SimpleMessage", "SimpleMessage");
  }

  @Test
  public void testSendSimpleMessageUsingTemplate() {
    emailService.sendSimpleMessageUsingTemplate("whimmy@126.com", "SimpleMessageUsingTemplate", "SimpleMessageUsingTemplate");
  }

  @Test
  public void testSendMessageWithAttachment() {
    emailService.sendMessageWithAttachment("whimmy@126.com", "MessageWithAttachment", "MessageWithAttachment","attachment.txt");
  }
  
  @Test
  public void testSendMessageUsingThymeleafTemplate() throws IOException, MessagingException {
    Map<String,Object> templateModel = new HashMap<>();
    templateModel.put("recipientName", "whimmy");
    templateModel.put("text", "text");
    templateModel.put("senderName", "wang");
    emailService.sendMessageUsingThymeleafTemplate("whimmy@126.com", "MessageUsingThymeleafTemplate",templateModel);
  }
  
  @Test
  public void testSendMessageUsingFreemarkerTemplate() throws  TemplateException, IOException, MessagingException {
    Map<String,Object> templateModel = new HashMap<>();
    templateModel.put("recipientName", "whimmy");
    templateModel.put("text", "text");
    templateModel.put("senderName", "wang");
    emailService.sendMessageUsingFreemarkerTemplate("whimmy@126.com", "MessageUsingFreemarkerTemplate",templateModel);
  }
}
