package br.com.lc.iprt2.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lc.iprt2.model.Igreja;
import br.com.lc.iprt2.model.Membro;
import br.com.lc.iprt2.model.dtos.IgrejaDTO;
import br.com.lc.iprt2.model.dtos.MembroDTO;
import br.com.lc.iprt2.repositories.IgrejaRepository;
import br.com.lc.iprt2.repositories.MembroRepository;
import br.com.lc.iprt2.service.exceptions.DataIntegrityViolationException;
import br.com.lc.iprt2.service.exceptions.ObjectnotFoundException;


@Service
public class IgrejaService {

	@Autowired
	private IgrejaRepository igrejaRepository;
	


	public List<Igreja> findAll() {
		return igrejaRepository.findAll();
		
	}

	public Igreja findById(Integer id) {
		java.util.Optional<Igreja> igreja = igrejaRepository.findById(id);
		return igreja.orElseThrow(() -> new ObjectnotFoundException("Igreja não encontrado! id: " + id));
	}
	
	
	public List<Igreja> listar() {
		return igrejaRepository.findAll();
		 
	}


	
}
