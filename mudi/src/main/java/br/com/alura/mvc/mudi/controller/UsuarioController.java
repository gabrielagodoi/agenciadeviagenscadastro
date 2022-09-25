package br.com.alura.mvc.mudi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.mvc.mudi.model.RespostaModelo;
import br.com.alura.mvc.mudi.model.Usuario;
import br.com.alura.mvc.mudi.repository.UsuarioRepository;

@RestController
@RequestMapping("/api")
public class UsuarioController {

	@Autowired
	private UsuarioRepository acoes;

	// Listar
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
	public @ResponseBody List<Usuario> listar() {
		return acoes.findAll();
	}

	// Cadastrar
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/usuarios", method = RequestMethod.POST)
	public @ResponseBody Usuario cadastrar(@RequestBody Usuario usuario) {

		return acoes.save(usuario);
	}

	// Filtrar
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/usuarios/{codigo}", method = RequestMethod.GET)
	public @ResponseBody Usuario filtrar(@PathVariable Integer codigo) {
		return acoes.findByCodigo(codigo);
	}

	// Alterar
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/usuarios", method = RequestMethod.PUT)
	public @ResponseBody Usuario alterar(@RequestBody Usuario usuario) {
		return acoes.save(usuario);
	}

	// Remover
	@CrossOrigin(origins = "*")
	@RequestMapping(value = "/usuarios/{codigo}", method = RequestMethod.DELETE)
	public @ResponseBody RespostaModelo remover(@PathVariable Integer codigo) {

		RespostaModelo resposta = new RespostaModelo();

		try {

			Usuario usuario = filtrar(codigo);
			this.acoes.delete(usuario);
			resposta.setMensagens("Produto removido com sucesso");
		} catch (Exception e) {
			resposta.setMensagens("Falha ao deletar: " + e.getMessage());
		}

		return resposta;
	}

}
