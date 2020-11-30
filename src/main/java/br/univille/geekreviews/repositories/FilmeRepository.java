package br.univille.geekreviews.repositories;

import br.univille.geekreviews.domain.Filme;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    Filme findByTitulo(String name);

    @Query("FROM Filme f WHERE LOWER(f.titulo) like %:termo%")
    Page<Filme> filtrar(@Param("termo") String termo, Pageable pageable);

    @Query("FROM Filme f WHERE LOWER(f.titulo) like %:termo%")
    List<Filme> obterPorTitulo(@Param("termo") String termo);

}
