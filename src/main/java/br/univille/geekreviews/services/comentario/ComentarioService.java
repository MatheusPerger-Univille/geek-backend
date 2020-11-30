package br.univille.geekreviews.services.comentario;

import br.univille.geekreviews.dtos.ComentarioDTO;

public interface ComentarioService {

    void salvar(ComentarioDTO dto);

    void atualizar(ComentarioDTO dto);

    void excluir(Long id);

}
