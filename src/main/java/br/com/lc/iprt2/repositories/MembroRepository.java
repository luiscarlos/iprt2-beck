package br.com.lc.iprt2.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import br.com.lc.iprt2.model.Membro;

public interface MembroRepository extends JpaRepository<Membro, Integer>{


	 java.util.Optional<Membro> findByEmail(String email);
//Optional<Membro> findById(Integer id);







}
