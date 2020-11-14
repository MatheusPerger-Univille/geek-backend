package br.univille.geekreviews.mappers;

import br.univille.geekreviews.domain.Game;
import br.univille.geekreviews.domain.Plataforma;
import br.univille.geekreviews.dtos.game.GameDTO;
import br.univille.geekreviews.dtos.game.GamePesquisaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = { Plataforma.class, Collectors.class },
        uses = {CategoriaMapper.class, AvaliacaoMapper.class, ComentarioMapper.class})
public interface GameMapper {

    @Mappings({
            @Mapping(target = "categorias", source = "categorias"),
            @Mapping(target = "avaliacoes", source = "avaliacoes"),
            @Mapping(target = "plataformas", expression = "java( entity.getPlataformas().stream().map(Plataforma::getId).collect(Collectors.toList()) )"),
            @Mapping(target = "notaMidia", expression = "java(entity.getNotaMidia())"),
    })
    GameDTO toDto(Game entity);

    @Mappings({
            @Mapping(target = "plataformas", ignore = true)
    })
    Game toEntity(GameDTO dto);

    List<GameDTO> toDtos(List<Game> entitys);

    GamePesquisaDTO toPesquisaDto(Game entity);

    List<GamePesquisaDTO> toPesquisaDtos(List<Game> entitys);
}
