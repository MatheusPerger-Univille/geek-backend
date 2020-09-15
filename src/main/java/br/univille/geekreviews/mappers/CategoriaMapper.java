package br.univille.geekreviews.mappers;

import br.univille.geekreviews.domain.Categoria;
import br.univille.geekreviews.dtos.CategoriaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CategoriaMapper {

    CategoriaDTO toDto(Categoria entity);

    Categoria toEntity(CategoriaDTO dto);

    List<CategoriaDTO> toDtos(List<Categoria> entitys);
}
