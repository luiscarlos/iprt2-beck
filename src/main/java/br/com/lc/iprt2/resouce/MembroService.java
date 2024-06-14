package br.com.lc.iprt2.resouce;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lc.iprt2.model.Membro;
import br.com.lc.iprt2.repositories.MembroRepository;

@Service
public class MembroService {

	@Autowired
	private MembroRepository membroRepository;
	
	
	public Membro buscarPoId(Integer id) {
		java.util.Optional<Membro> membro = membroRepository.findById(id);
		return membro.orElse(null);
	}
	
	
}
