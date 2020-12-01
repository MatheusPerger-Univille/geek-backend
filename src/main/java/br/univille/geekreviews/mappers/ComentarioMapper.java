package br.univille.geekreviews.mappers;

import br.univille.geekreviews.domain.Comentario;
import br.univille.geekreviews.dtos.ComentarioDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ComentarioMapper {

    @Mappings({
            @Mapping(target = "userId", source = "usuario.id"),
            @Mapping(target = "userName", source = "usuario.nome")
    })
    ComentarioDTO toDto(Comentario entity);

    Comentario toEntity(ComentarioDTO dto);

    List<ComentarioDTO> toDtos(List<Comentario> entitys);
}
