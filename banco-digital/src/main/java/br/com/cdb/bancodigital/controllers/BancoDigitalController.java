package br.com.cdb.bancodigital.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verdades")
public class BancoDigitalController {
    @GetMapping("/verdadeiras")
    public String teste()
    {
        return "O Edson é boboca";
    }
}
