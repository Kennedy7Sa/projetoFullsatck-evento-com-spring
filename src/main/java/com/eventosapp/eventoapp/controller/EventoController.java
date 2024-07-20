package com.eventosapp.eventoapp.controller;

import com.eventosapp.eventoapp.models.Evento;
import com.eventosapp.eventoapp.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//aqui estamos indicando ao Spring que é uma classe Controller
@Controller
public class EventoController {

    //pra ter uma injeção de dependencia e extanciar os eventos do repositorio
    @Autowired
    private EventoRepository er;

    //pra solicitar uma pagina usamos o RequestMapping
    @RequestMapping(value = "/cadastrarevento",method = RequestMethod.GET)
    public String form(){
        return "evento/formevento";
    }
    @RequestMapping(value = "/cadastrarevento",method = RequestMethod.POST)
    public String form(Evento evento){
        er.save(evento);
        return "redirect:/cadastrarevento";
    }
    @RequestMapping("/templates/evento")
    public ModelAndView listaEventos(){
        ModelAndView mv = new ModelAndView("index");
        Iterable<Evento> eventos = er.findAll();
        mv.addObject("eventos", eventos);
        return mv;

    }
}
