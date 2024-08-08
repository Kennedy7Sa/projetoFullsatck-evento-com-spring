package com.eventosapp.eventoapp.controller;

import com.eventosapp.eventoapp.models.Evento;
import com.eventosapp.eventoapp.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
//controllers são criados para controlar as paginas web no navegador
@Controller
public class IndexController {

    //pra ter uma injeção de dependencia e extanciar os eventos do repositorio
    @Autowired
    private EventoRepository er;

    // para aparecer todos os registros do banco de dados na pagina principal (index)
    @RequestMapping("/")
    public ModelAndView listaEventos() {
        ModelAndView mv = new ModelAndView("index");
        //busca de eventos em lista com o interable
        Iterable<Evento> eventos = er.findAll(); // metodo de busca com o repositorio de eventos
        mv.addObject("eventos", eventos);
        return mv;

    }
    //para salvar um novo evento
    @RequestMapping(value = "/",method = RequestMethod.POST) //requisição de salvar no bd , metodo para cadastrar incluir dados
    public String form(Evento evento){
        er.save(evento);
        return "redirect:/";
    }
    //criando um metodo para detalhar o evento clicado
    @RequestMapping("/{codigo}")
    public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo){
        Evento evento = er.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("detalhes");
        mv.addObject("evento", evento);
        return mv;

    }

}

