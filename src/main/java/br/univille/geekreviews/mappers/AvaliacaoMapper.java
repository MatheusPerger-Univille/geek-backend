package br.univille.geekreviews.mappers;

import br.univille.geekreviews.domain.Avaliacao;
import br.univille.geekreviews.domain.Categoria;
import br.univille.geekreviews.dtos.AvaliacaoDTO;
import br.univille.geekreviews.dtos.CategoriaDTO;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AvaliacaoMapper {

    @Mappings({
            @Mapping(target = "userId", source = "usuario.id"),
            @Mapping(target = "userName", source = "usuario.nome")
    })
    AvaliacaoDTO toDto(Avaliacao entity);

    Avaliacao toEntity(AvaliacaoDTO dto);

    List<AvaliacaoDTO> toDtos(List<Avaliacao> entitys);
}
