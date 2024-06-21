package br.com.lc.iprt2.resouce;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import br.com.lc.iprt2.model.Membro;
import br.com.lc.iprt2.model.dtos.MembroDTO;
import br.com.lc.iprt2.repositories.MembroRepository;
import br.com.lc.iprt2.service.MembroService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/membros")
public class MembroResource {
	
	
	@Autowired
	private MembroRepository membroRepository;
	
	
	@Autowired
	private MembroService membroService;
	
	@GetMapping
	public ResponseEntity<List<MembroDTO>> listar(){
		List<Membro>  lista = membroService.findAll();
		List<MembroDTO> listaDTO = lista.stream().map(obj -> new MembroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(listaDTO);
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<MembroDTO> buscarPeloCodigo(@PathVariable Integer id) {
	Membro membro = this.membroService.buscarPoId(id);
	return ResponseEntity.ok().body(new MembroDTO(membro));
	}
	
	
	@PostMapping()
	public ResponseEntity<MembroDTO> create(@RequestBody MembroDTO  objDTO) {
		
		Membro membro = membroService.create(objDTO);
		
		MembroDTO membroDTO = new MembroDTO(membro);
	
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(membroDTO.getId()).toUri();
		
        //response.setHeader("Location", uri.toASCIIString());
		
		return ResponseEntity.created(uri).body(membroDTO);
	}

}
