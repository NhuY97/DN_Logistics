package com.dn.logistics.controller;

import com.dn.logistics.modal.EmailInfo;
import com.dn.logistics.modal.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.internet.MimeMessage;
import javax.validation.Valid;

import static com.dn.logistics.constant.Constant.*;

@Controller
public class HomeController {

    @Autowired
    private JavaMailSender emailSender;

    @GetMapping(value = {"/", "/home", "/index"})
    public String welcome(Model model) {
        model.addAttribute("userInfo", new UserInfo());
        model.addAttribute("emailInfo", new EmailInfo());
        return "index";
    }
    
    @GetMapping(value = {"/about-us"})
    public String aboutUs(Model model) {
        model.addAttribute("emailInfo", new EmailInfo());
        return "about-us";
    }

    @GetMapping(value = {"/services"})
    public String services(Model model) {
        model.addAttribute("emailInfo", new EmailInfo());
        return "service";
    }

    @GetMapping(value = {"/contact"})
    public String contact(Model model) {
        model.addAttribute("userInfo", new UserInfo());
        model.addAttribute("emailInfo", new EmailInfo());
        return "contact";
    }

    @PostMapping("/gui-bao-gia")
    public String sendUserInfo(@Valid @ModelAttribute("userInfo") UserInfo userInfo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("sendUserInfoResult", BAD_REQUEST);
        }

        try {
            MimeMessage message = emailSender.createMimeMessage();

            boolean multipart = true;

            MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

            String htmlMsg = "<h3 style=\"color:#FF5733\">Customer information submitted from the website <a href=\"http://www.dnlogisticsvn.com\">www.dnlogisticsvn.com</a></h3>"
                    +"<div style=\"border: 1px solid #015F9C; border-radius:5px; padding:3px;\">" +
                    "<p><b>Name: </b>" + userInfo.getName() +"</p>" +
                    "<p><b>Email: </b>" + userInfo.getEmail() +"</p>" +
                    "<p><b>Phone: </b>" + userInfo.getPhone() +"</p>" +
                    "<p><b>Message: </b>" + userInfo.getMessage() +"</p>" +
                    "</div>";

            message.setContent(htmlMsg, "text/html; charset=utf-8");

            helper.setTo(MAIL_TO);

            helper.setSubject("Website - KHACH GUI BAO GIA - " + userInfo.getName());

            this.emailSender.send(message);

        } catch (Exception e) {
            System.out.println("User Info - Send email occurs Exception " +  e.getMessage());
            model.addAttribute("sendUserInfoResult", SERVER_ERROR);
        }


        model.addAttribute("sendUserInfoResult", SUCCESS);
        model.addAttribute("emailInfo", new EmailInfo());
        return "index";
    }

    @PostMapping("/dang-ky")
    public String sendEmailInfo(@Valid @ModelAttribute("emailInfo") EmailInfo emailInfo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("sendEmailInfoResult", BAD_REQUEST);
        }

        try {
            MimeMessage message = emailSender.createMimeMessage();

            boolean multipart = true;

            MimeMessageHelper helper = new MimeMessageHelper(message, multipart, "utf-8");

            String htmlMsg = "<h3 style=\"color:#FF5733\">Customer register email from the website <a href=\"http://www.dnlogisticsvn.com\">www.dnlogisticsvn.com</a></h3>"
                    +"<div" +
                    "<p><b>Email: </b>" + emailInfo.getEmail() +"</p>" +
                    "</div>";

            message.setContent(htmlMsg, "text/html");

            helper.setTo(MAIL_TO);

            helper.setSubject("Website - DANG KY EMAIL - " + emailInfo.getEmail());

            this.emailSender.send(message);

        } catch (Exception e) {
            System.out.println("Email Register - Send email occurs Exception " +  e.getMessage());
            model.addAttribute("sendEmailInfoResult", SERVER_ERROR);
        }


        model.addAttribute("sendEmailInfoResult", SUCCESS);
        model.addAttribute("userInfo", new UserInfo());
        return "index";
    }

}