package br.univille.geekreviews.services.avaliacao;

import br.univille.geekreviews.dtos.AvaliacaoDTO;

public interface AvaliacaoService {

    void salvar(AvaliacaoDTO dto);

    void atualizar(AvaliacaoDTO dto);

    void excluir(Long id);
}
