package br.univille.geekreviews.mappers;

import br.univille.geekreviews.domain.Serie;
import br.univille.geekreviews.dtos.serie.SerieDTO;
import br.univille.geekreviews.dtos.serie.SeriePesquisaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {CategoriaMapper.class, AvaliacaoMapper.class, ComentarioMapper.class})
public interface SerieMapper {

    @Mappings({
            @Mapping(target = "categorias", source = "categorias"),
            @Mapping(target = "avaliacoes", source = "avaliacoes"),
            @Mapping(target = "notaMidia", expression = "java(entity.getNotaMidia())"),
    })
    SerieDTO toDto(Serie entity);

    Serie toEntity(SerieDTO dto);

    List<SerieDTO> toDtos(List<Serie> serie);

    SeriePesquisaDTO toPesquisaDto(Serie entity);

    List<SeriePesquisaDTO> toPesquisaDtos(List<Serie> series);
}
