package com.eventosapp.eventoapp.repository;

import com.eventosapp.eventoapp.models.Convidado;
import com.eventosapp.eventoapp.models.Evento;
import org.springframework.data.repository.CrudRepository;

public interface ConvidadoRepository extends CrudRepository<Convidado,String> {
    Iterable<Convidado>findByEvento(Evento evento); // vai buscar
    Convidado findByRg(String rg);

}
