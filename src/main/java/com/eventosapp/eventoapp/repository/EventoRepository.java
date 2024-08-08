package com.eventosapp.eventoapp.repository;

import com.eventosapp.eventoapp.models.Evento;
import org.springframework.data.repository.CrudRepository;

//usando a extenção crudrepository temos metodos prontos de CRUD
public interface EventoRepository extends CrudRepository<Evento,String> {


}
