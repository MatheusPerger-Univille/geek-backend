package br.univille.geekreviews.mappers;

import br.univille.geekreviews.domain.Plataforma;
import br.univille.geekreviews.dtos.game.plataforma.PlataformaDTO;
import br.univille.geekreviews.dtos.game.plataforma.PlataformaPesquisaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PlataformaMapper {

    PlataformaDTO toDto(Plataforma entity);

    Plataforma toEntity(PlataformaDTO dto);

    List<PlataformaDTO> toDtos(List<Plataforma> entitys);

    PlataformaPesquisaDTO toPesquisaDto(Plataforma entity);

    List<PlataformaPesquisaDTO> toPesquisaDtos(List<Plataforma> entitys);
}
