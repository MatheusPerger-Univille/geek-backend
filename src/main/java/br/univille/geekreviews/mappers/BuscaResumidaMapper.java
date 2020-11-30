package br.univille.geekreviews.mappers;

import br.univille.geekreviews.domain.Filme;
import br.univille.geekreviews.domain.Game;
import br.univille.geekreviews.domain.Livro;
import br.univille.geekreviews.domain.Serie;
import br.univille.geekreviews.dtos.BuscaResumidaMidiaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BuscaResumidaMapper {

    @Mappings({
            @Mapping(target = "urlImagem", source = "urlCapa"),
            @Mapping(target = "responsavel", source = "direcao"),
    })
    BuscaResumidaMidiaDTO toDto(Filme entity);

    List<BuscaResumidaMidiaDTO> toDtosFilme(List<Filme> entitys);

    @Mappings({
            @Mapping(target = "urlImagem", source = "urlCapa"),
            @Mapping(target = "responsavel", source = "direcao"),
    })
    BuscaResumidaMidiaDTO toDto(Serie entity);

    List<BuscaResumidaMidiaDTO> toDtosSerie(List<Serie> entitys);

    @Mappings({
            @Mapping(target = "urlImagem", source = "urlCapa"),
            @Mapping(target = "responsavel", source = "autor"),
    })
    BuscaResumidaMidiaDTO toDto(Livro entity);

    List<BuscaResumidaMidiaDTO> toDtosLivro(List<Livro> entitys);

    @Mappings({
            @Mapping(target = "urlImagem", source = "urlCapa"),
            @Mapping(target = "responsavel", source = "desenvolvedora"),
    })
    BuscaResumidaMidiaDTO toDto(Game entity);

    List<BuscaResumidaMidiaDTO> toDtosGame(List<Game> entitys);
}
