package com.eventosapp.eventoapp.controller;

import com.eventosapp.eventoapp.models.Convidado;
import com.eventosapp.eventoapp.models.Evento;
import com.eventosapp.eventoapp.repository.ConvidadoRepository;
import com.eventosapp.eventoapp.repository.EventoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.hibernate.validator.constraints.NotEmpty;


//controllers são criados para controlar as paginas web no navegador
@Controller
public class IndexController {

    //pra ter uma injeção de dependencia e extanciar os eventos do repositorio
    @Autowired
    private EventoRepository er;
    @Autowired
    private ConvidadoRepository cr;

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
    @RequestMapping(value = "/{codigo}", method = RequestMethod.GET)
    public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo){
        Evento evento = er.findByCodigo(codigo);
        ModelAndView mv = new ModelAndView("evento/detalhesEvento"); //nome do template html a ser chamado
        mv.addObject("evento", evento);
        //para mostrar os convidados que estão relacionados ao evento
        Iterable <Convidado> convidados = cr.findByEvento(evento);
        mv.addObject("convidados",convidados );
        return mv;

    }
    //criando um metodo para cadastrar convidados validação ainda não esta funcionando 
    @RequestMapping(value = "/{codigo}", method = RequestMethod.POST)
    public String detalhesEventoPost(@PathVariable("codigo") long codigo,
                                     @Valid Convidado convidado,
                                     BindingResult result,
                                     RedirectAttributes attributes){
       if (result.hasErrors()){
           attributes.addFlashAttribute("mensagem","Verifique os campos !");
       return  "redirect:/{codigo}";
       }
           Evento evento = er.findByCodigo(codigo);
           convidado.setEvento(evento);
           cr.save(convidado);
           attributes.addFlashAttribute("mensagem", "convidado adicionado com sucesso!");
           return "redirect:/{codigo}";
       }
    @RequestMapping("/deletarConvidado")
    public String deletarConvidado(String rg){
        Convidado convidado = cr.findByRg(rg);
        cr.delete(convidado);

        Evento evento = convidado.getEvento();
        long codigoLong = evento.getCodigo();
        String codigo = "" + codigoLong;
        return "redirect:/" + codigo;
    }
    @RequestMapping("/deletar")
    public String deletarEvento(long codigo){
      Evento evento = er.findByCodigo(codigo);
      er.delete(evento);


        return "redirect:/";
    }

}

