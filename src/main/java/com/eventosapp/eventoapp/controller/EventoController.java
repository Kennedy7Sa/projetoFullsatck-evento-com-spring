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
    @RequestMapping(value = "/cadastrarevento",method = RequestMethod.GET) //definindo metodo get para retornnar o formulario
    public String form(){
        return "evento/formevento";
    }

    //para mostrar os dados salvos aqui usamos o requestMethod.POST
    @RequestMapping(value = "/cadastrarevento",method = RequestMethod.POST) //requisição de salvar no bd , metodo para cadastrar incluir dados
    public String form(Evento evento){
        er.save(evento);
        return "redirect:/cadastrarevento";
    }
    @RequestMapping("/eventos")
    public ModelAndView listaEventos(){
        ModelAndView mv = new ModelAndView("index");
        //busca de eventos em lista com o interable
        Iterable<Evento> eventos = er.findAll(); // metodo de busca com o repositorio de eventos
        mv.addObject("eventos", eventos);
        return mv;

    }
}
