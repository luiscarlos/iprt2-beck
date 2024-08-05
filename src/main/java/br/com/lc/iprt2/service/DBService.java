package br.com.lc.iprt2.service;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.lc.iprt2.model.Endereco;
import br.com.lc.iprt2.model.EscalaCulto;
import br.com.lc.iprt2.model.Evento;
import br.com.lc.iprt2.model.Igreja;
import br.com.lc.iprt2.model.Membro;
import br.com.lc.iprt2.model.Servico;
import br.com.lc.iprt2.model.ennums.Departamento;
import br.com.lc.iprt2.model.ennums.Dizimista;
import br.com.lc.iprt2.model.ennums.Presenca;
import br.com.lc.iprt2.model.ennums.Seguimento;
import br.com.lc.iprt2.model.ennums.Status;
import br.com.lc.iprt2.model.ennums.UserRole;
import br.com.lc.iprt2.repositories.EnderecoRepository;
import br.com.lc.iprt2.repositories.EscalaCultoRepository;
import br.com.lc.iprt2.repositories.EventoRepository;
import br.com.lc.iprt2.repositories.IgrejaRepository;
import br.com.lc.iprt2.repositories.MembroRepository;
import br.com.lc.iprt2.repositories.ServicoRepository;



@Service
public class DBService {
	
	

		@Autowired
		private MembroRepository membroRepository;

		@Autowired
		private IgrejaRepository igrejaRepository; 
		
		@Autowired
		private EnderecoRepository enderecoRepository;

		@Autowired
		private ServicoRepository servicoRepository;
		
		@Autowired
		private EventoRepository eventoRepository;
		
		@Autowired
		private EscalaCultoRepository escalaCultoRepository;

		public void instanciaDB(){
			
			Endereco endereco = new Endereco();
			endereco.setLogradouro("Rua exemplo");
			endereco.setNumero("123");
			endereco.setCidade("Cidade exemplo");
			endereco.setEstado("Estado exemplo");
			
			Membro me = new Membro(null, "luis", "luis@gmail.com", "123", "84469655", UserRole.ADMIN, Dizimista.SIM, endereco ,LocalDate.now(), LocalDate.now());
			//dev.addRole(UserRole.ADMIN);

			
			
			//dev.addRole(UserRole.ADMIN);

			Servico ser = new Servico(null, LocalDate.now(), "Teste", me, Presenca.FALTOU);
			
			//Evento ev = new Evento(null, "Encontro de mulheres", LocalDate.now(), LocalDate.now(), Status.ABERTO, Departamento.HOMENS, "Teste evento", me, ig);
			
			EscalaCulto esc = new EscalaCulto(null, LocalDate.now(), me, Seguimento.CEIA, Departamento.HOMENS, "Ediel");
			//Igreja ig = new Igreja(null, "luis", LocalDate.now(), LocalDate.now(), LocalDate.now(), endereco);
			//membroRepository.saveAll(Arrays.asList(me));
			//igrejaRepository.saveAll(Arrays.asList(ig));
			//servicoRepository.saveAll(Arrays.asList(ser));
			//eventoRepository.saveAll(Arrays.asList(ev));
			//escalaCultoRepository.saveAll(Arrays.asList(esc));
			//enderecoRepository.saveAll(Arrays.asList(endereco1));
	}

}
