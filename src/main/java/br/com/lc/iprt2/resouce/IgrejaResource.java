package br.com.lc.iprt2.resouce;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.lc.iprt2.model.Igreja;
import br.com.lc.iprt2.model.Membro;
import br.com.lc.iprt2.model.dtos.MembroDTO;
import br.com.lc.iprt2.repositories.IgrejaRepository;
import br.com.lc.iprt2.service.IgrejaService;

@RestController
@RequestMapping("/igrejas")
public class IgrejaResource {
	
	@Autowired
	private IgrejaRepository igrejaRepository;
	
	@Autowired
	private IgrejaService  igrejaService;
	
	
	@GetMapping
	public List<Igreja> listar(){
		return igrejaRepository.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Igreja> findById(@PathVariable Integer id){
		Igreja igrejaOBJ = igrejaService.findById(id);
		return ResponseEntity.ok().body(igrejaOBJ);
		
	}
	
	
	

}
