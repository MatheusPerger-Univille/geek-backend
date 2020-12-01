package br.univille.geekreviews.repositories;

import br.univille.geekreviews.domain.Livro;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    Livro findByTitulo(String name);

    @Query("FROM Livro f WHERE LOWER(f.titulo) like %:termo%")
    Page<Livro> filtrar(@Param("termo") String termo, Pageable pageable);

    @Query("FROM Livro f WHERE LOWER(f.titulo) like %:termo%")
    List<Livro> obterPorTitulo(@Param("termo") String termo);

    @Query("FROM Livro f INNER JOIN f.categorias c WHERE c.id = :cat")
    List<Livro> obterPorCategoria(@Param("cat") Long cat);

}
