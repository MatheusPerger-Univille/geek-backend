package br.univille.geekreviews.services.usuario;

import br.univille.geekreviews.domain.Usuario;
import br.univille.geekreviews.dtos.usuario.UsuarioDTO;
import br.univille.geekreviews.dtos.usuario.UsuarioPesquisaDTO;
import br.univille.geekreviews.mappers.UsuarioMapper;
import br.univille.geekreviews.repositories.UsuarioRepository;
import br.univille.geekreviews.security.UserSS;
import br.univille.geekreviews.services.exception.ObjectNotFoundException;
import com.amazonaws.services.licensemanager.model.AuthorizationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private UsuarioMapper mapper;

    @Autowired
    private BCryptPasswordEncoder be;

    @Override
    public UsuarioDTO obterPorId(Long id) {

        UserSS user = getUsuarioLogado();

        if (user == null || !user.isAdmin() && !id.equals(user.getId()))
            throw new AuthorizationException("Acesso negado");

        Usuario entity = repo.findById(id).orElseThrow(() -> new ObjectNotFoundException("Nenhum registro encontrado"));
        return mapper.toDto(entity);
    }

    @Override
    public Page<UsuarioPesquisaDTO> filtrar(String search, Pageable p) {

        Page<Usuario> usuarios = repo.filtrar(search, p);
        Page<UsuarioPesquisaDTO> dtos = usuarios.map(v -> mapper.toPesquisaDto(v));

        return dtos;
    }

    @Override
    public void salvar(UsuarioDTO dto) {

        Usuario entity = mapper.toEntity(dto);
        entity.setSenha(be.encode(dto.getSenha()));
        repo.save(entity);
    }

    @Override
    public void atualizar(UsuarioDTO dto) {

        Usuario entity = mapper.toEntity(dto);
        repo.save(entity);
    }

    @Override
    public void excluir(Long id) {

        Usuario entity = repo.findById(id).orElseThrow(null);
        repo.delete(entity);
    }

    @Override
    public UsuarioDTO obterPorEmail(String email) {

        UserSS user = getUsuarioLogado();

        if (user == null || !user.isAdmin() && !email.equals(user.getUsername()))
            throw new AuthorizationException("Acesso negado!");

        Usuario entity = repo.findByEmail(email);

        if (entity == null) {
            throw new ObjectNotFoundException(
                    "Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Usuario.class.getName());
        }
        return mapper.toDto(entity);
    }

    /**
     * Método que retorna o usuário autenticado no sistema
     * @return UserSS
     */
    public static UserSS getUsuarioLogado() {
        try {
            return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        } catch (Exception e) {
            return null;
        }
    }
}
