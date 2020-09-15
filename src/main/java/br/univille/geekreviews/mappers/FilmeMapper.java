package br.univille.geekreviews.mappers;

import br.univille.geekreviews.domain.Filme;
import br.univille.geekreviews.dtos.filme.FilmeDTO;
import br.univille.geekreviews.dtos.filme.FilmePesquisaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {CategoriaMapper.class, AvaliacaoMapper.class, ComentarioMapper.class})
public interface FilmeMapper {

    @Mappings({
            @Mapping(target = "categorias", source = "categorias"),
            @Mapping(target = "avaliacoes", source = "avaliacoes"),
            @Mapping(target = "notaMidia", expression = "java(entity.getNotaMidia())"),
    })
    FilmeDTO toDto(Filme entity);

    Filme toEntity(FilmeDTO dto);

    List<FilmeDTO> toDtos(List<Filme> filmes);

    FilmePesquisaDTO toPesquisaDto(Filme entity);

    List<FilmePesquisaDTO> toPesquisaDtos(List<Filme> filmes);
}
