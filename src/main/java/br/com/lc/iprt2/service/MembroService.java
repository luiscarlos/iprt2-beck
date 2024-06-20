package br.com.lc.iprt2.service;

import java.util.List;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lc.iprt2.model.Membro;
import br.com.lc.iprt2.model.dtos.MembroDTO;
import br.com.lc.iprt2.repositories.MembroRepository;
import br.com.lc.iprt2.service.exceptions.ObjectNotFoundException;

@Service
public class MembroService {

	@Autowired
	private MembroRepository membroRepository;
	
	
	public Membro buscarPoId(Integer id) {
		java.util.Optional<Membro> membro = membroRepository.findById(id);
		return membro.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id));
	}


	public List<Membro> findAll() {
		return membroRepository.findAll();
		
	}


	public Membro create(MembroDTO membroDTO) {
		membroDTO.setId(null);
		Membro membro = new Membro(membroDTO);
		return membroRepository.save(membro);
	}
	
	
}
