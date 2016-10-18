package com.lxl.sendmail;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by lxl on 16/7/19.
 */
@Controller
public class EmailController {

    private static final Logger logger = LoggerFactory.getLogger(EmailController.class);
    @Autowired
    private JavaMailSender javaMailSender;

    @RequestMapping(value = "/send", method = RequestMethod.POST)
    @ResponseBody
    public void sendEmail(HttpServletRequest request, @RequestBody Email email) throws Exception {
        Assert.notNull(email, "Email must not be null");
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(email.getTo());
        helper.setSubject(email.getSubject());
        helper.setText(email.getText(), true);
        helper.setFrom("jw@lxl.com");
        javaMailSender.send(message);
    }

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public void sendEmail(String to, String subject, String text) throws Exception {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(text, true);
        helper.setFrom("jw@lxl.com");
        javaMailSender.send(message);
    }

}