package br.univille.geekreviews.services.usuario;

import br.univille.geekreviews.dtos.usuario.UsuarioDTO;
import br.univille.geekreviews.dtos.usuario.UsuarioPesquisaDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UsuarioService {

    UsuarioDTO obterPorId(Long id);

    Page<UsuarioPesquisaDTO> filtrar(String search, Pageable p);

    void salvar(UsuarioDTO dto);

    void atualizar(UsuarioDTO dto);

    void excluir(Long id);

    UsuarioDTO obterPorEmail(String email);
}
