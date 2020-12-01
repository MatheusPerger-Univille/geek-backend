package br.univille.geekreviews.mappers;

import br.univille.geekreviews.domain.Usuario;
import br.univille.geekreviews.dtos.usuario.UsuarioDTO;
import br.univille.geekreviews.dtos.usuario.UsuarioLogadoDTO;
import br.univille.geekreviews.dtos.usuario.UsuarioPesquisaDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel="spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsuarioMapper {

    UsuarioDTO toDto(Usuario entity);

    Usuario toEntity(UsuarioDTO dto);

    List<UsuarioDTO> toDtos(List<Usuario> usuarios);

    UsuarioPesquisaDTO toPesquisaDto(Usuario entity);

    List<UsuarioPesquisaDTO> toPesquisaDtos(List<Usuario> usuarios);

    UsuarioLogadoDTO toLogadoDto(Usuario entity);
}
