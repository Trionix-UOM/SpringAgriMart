package com.trionix.agrimartorder.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class EmailController {
    @RequestMapping("/sendEmail")
    public String sendEmail(){
     return "Sendemail";
    }
}
