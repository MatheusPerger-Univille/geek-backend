package br.univille.geekreviews.mappers;

import br.univille.geekreviews.domain.Livro;
import br.univille.geekreviews.dtos.livro.LivroDTO;
import br.univille.geekreviews.dtos.livro.LivroPesquisaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, uses = {CategoriaMapper.class, AvaliacaoMapper.class, ComentarioMapper.class})
public interface LivroMapper {

    @Mappings({
            @Mapping(target = "categorias", source = "categorias"),
            @Mapping(target = "avaliacoes", source = "avaliacoes"),
            @Mapping(target = "notaMidia", expression = "java(entity.getNotaMidia())"),
    })
    LivroDTO toDto(Livro entity);

    Livro toEntity(LivroDTO dto);

    List<LivroDTO> toDtos(List<Livro> livros);

    LivroPesquisaDTO toPesquisaDto(Livro entity);

    List<LivroPesquisaDTO> toPesquisaDtos(List<Livro> livros);
}
