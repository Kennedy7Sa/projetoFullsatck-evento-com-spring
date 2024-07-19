package com.eventosapp.eventoapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//controllers são criados para controlar as paginas web no navegador
@Controller
public class IndexController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }
}
//aqui fazemos a requisição pra chamar o index da pagina que foi criado na pasta template