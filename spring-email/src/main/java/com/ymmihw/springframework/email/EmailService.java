package com.ymmihw.springframework.email;

import java.io.IOException;
import java.util.Map;


import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;

/**
 * Created by Olga on 8/22/2016.
 */
public interface EmailService {
  void sendSimpleMessage(String to, String subject, String text);

  void sendSimpleMessageUsingTemplate(String to, String subject, String... templateModel);

  void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment);

  void sendMessageUsingThymeleafTemplate(String to, String subject,
      Map<String, Object> templateModel) throws IOException, MessagingException;

  void sendMessageUsingFreemarkerTemplate(String to, String subject,
      Map<String, Object> templateModel) throws IOException, TemplateException, MessagingException;
}
