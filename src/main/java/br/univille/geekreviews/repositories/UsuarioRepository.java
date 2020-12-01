package br.univille.geekreviews.repositories;

import br.univille.geekreviews.domain.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findByEmail(String email);

    @Query("FROM Usuario u WHERE LOWER(u.nome) like %:termo%")
    Page<Usuario> filtrar(@Param("termo") String termo, Pageable pageable);
}
