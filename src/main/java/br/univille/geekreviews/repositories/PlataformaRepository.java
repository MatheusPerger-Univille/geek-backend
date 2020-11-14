package br.univille.geekreviews.repositories;

import br.univille.geekreviews.domain.Plataforma;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma, Long> {

    Plataforma findByNome(String name);

    @Query("FROM Plataforma f WHERE LOWER(f.nome) like %:termo%")
    Page<Plataforma> filtrar(@Param("termo") String termo, Pageable pageable);
}
