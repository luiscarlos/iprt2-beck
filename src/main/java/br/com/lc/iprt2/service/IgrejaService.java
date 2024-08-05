package br.com.lc.iprt2.service;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lc.iprt2.model.Igreja;
import br.com.lc.iprt2.model.dtos.IgrejaDTO;

import br.com.lc.iprt2.repositories.IgrejaRepository;

import br.com.lc.iprt2.service.exceptions.ObjectnotFoundException;


@Service
public class IgrejaService {

	@Autowired
	private IgrejaRepository igrejaRepository;
	


	public List<Igreja> listar() {
		return igrejaRepository.findAll();
		 
	}

	public Igreja findById(Integer id) {
		java.util.Optional<Igreja> igreja = igrejaRepository.findById(id);
		return igreja.orElseThrow(() -> new ObjectnotFoundException("Igreja não encontrado! id: " + id));
	}
	
	
	public Igreja create(IgrejaDTO objDTO) {
		objDTO.setId(null);
		Igreja igrejaObj = new Igreja(objDTO);
		return igrejaRepository.save(igrejaObj);
		
	}

	public Igreja update(Integer id, @Valid IgrejaDTO igrejaDTO) {
		igrejaDTO.setId(id);
		Igreja igrejaObj = findById(id);
		igrejaObj = new Igreja(igrejaDTO);
		
		return igrejaRepository.save(igrejaObj);
	}
	
}
