package br.com.lc.iprt2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.lc.iprt2.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Integer> {

}
