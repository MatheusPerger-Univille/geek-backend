package br.univille.geekreviews.repositories;

import br.univille.geekreviews.domain.Serie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SerieRepository extends JpaRepository<Serie, Long> {

    Serie findByTitulo(String name);

    @Query("FROM Serie s WHERE LOWER(s.titulo) like %:termo%")
    Page<Serie> filtrar(@Param("termo") String termo, Pageable pageable);

    @Query("FROM Serie s WHERE LOWER(s.titulo) like %:termo%")
    List<Serie> obterPorTitulo(@Param("termo") String termo);
}
