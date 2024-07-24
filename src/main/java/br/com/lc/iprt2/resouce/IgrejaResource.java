package br.com.lc.iprt2.resouce;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

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
import br.com.lc.iprt2.model.dtos.IgrejaDTO;
import br.com.lc.iprt2.model.dtos.MembroDTO;
import br.com.lc.iprt2.repositories.IgrejaRepository;
import br.com.lc.iprt2.service.IgrejaService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/igrejas")
public class IgrejaResource {
	
	
	
	@Autowired
	private IgrejaService  igrejaService;
	
	
	@GetMapping
	public ResponseEntity<List<IgrejaDTO>> listar(){
          List<Igreja> igrejaObj = igrejaService.listar();
          List<IgrejaDTO> igrejaDTO = igrejaObj.stream().map(obj -> new IgrejaDTO(obj)).collect(Collectors.toList());
          return ResponseEntity.ok().body(igrejaDTO);
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<IgrejaDTO> findById(@PathVariable Integer id){
		Igreja igrejaObj = igrejaService.findById(id);
		return ResponseEntity.ok().body(new IgrejaDTO(igrejaObj));
		
	}
	
	
	
	
	
	
	

}
