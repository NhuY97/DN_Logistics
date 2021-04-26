package com.dn.logistics.controller;

import com.dn.logistics.modal.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

import static com.dn.logistics.constant.Constant.BAD_REQUEST;
import static com.dn.logistics.constant.Constant.SUCCESS;

@Controller
public class HomeController {

    @GetMapping(value = {"/", "/home", "/index"})
    public String welcome(Model model) {
        model.addAttribute("userInfo", new UserInfo());
        return "index";
    }

    @PostMapping("gui-bao-gia")
    public String sendUserInfo(@Valid @ModelAttribute("userInfo") UserInfo userInfo, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("sendUserInfoResult", BAD_REQUEST);
            return "index";
        }

        model.addAttribute("sendUserInfoResult", SUCCESS);
        return "index";
    }

}