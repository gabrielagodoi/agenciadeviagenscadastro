package br.com.alura.mvc.mudi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.mvc.mudi.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	// Listar
	List<Usuario> findAll();

	// Pesquisar
	Usuario findByCodigo(int codigo);

	// Remover
	void delete(Usuario usuario);

	// Cadastrar / Alterar
	<UsuarioMod extends Usuario> UsuarioMod save(UsuarioMod usuario);
}
