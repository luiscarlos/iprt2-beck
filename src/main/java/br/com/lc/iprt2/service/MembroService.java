package br.com.lc.iprt2.service;

import java.util.ArrayList;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lc.iprt2.model.Membro;
import br.com.lc.iprt2.model.dtos.MembroDTO;
import br.com.lc.iprt2.repositories.MembroRepository;
import br.com.lc.iprt2.service.exceptions.DataIntegrityViolationException;
import br.com.lc.iprt2.service.exceptions.HttpMessageNotReadableException;
import br.com.lc.iprt2.service.exceptions.ObjectNotFoundException;

@Service
public class MembroService {

	@Autowired
	private MembroRepository membroRepository;
	
	
	public Membro buscarPoId(Integer id) {
		java.util.Optional<Membro> membro = membroRepository.findById(id);
		return membro.orElseThrow(() -> new ObjectNotFoundException("Membro não encontrado! id: " + id));
	}


	public List<Membro> findAll() {
		return membroRepository.findAll();
		
	}


	public Membro create( MembroDTO membroDTO) {
		membroDTO.setId(null); //Evitar que venha um id na requisição e a aplicação entenda que é um update 
		validaPorEmail(membroDTO);
		Membro membro = new Membro(membroDTO);
		return membroRepository.save(membro);
	}


	private void validaPorEmail(MembroDTO membroDTO) throws DataIntegrityViolationException, HttpMessageNotReadableException{
		java.util.Optional<Membro> membro = membroRepository.findByEmail(membroDTO.getEmail());
		
		if(membro.isPresent() && membro.get().getId() != membroDTO.getId()) {
			
			
		    throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");	
		    
		}
	}
	
}
