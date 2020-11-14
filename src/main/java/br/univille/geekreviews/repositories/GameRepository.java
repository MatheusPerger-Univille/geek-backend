package br.univille.geekreviews.repositories;

import br.univille.geekreviews.domain.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface GameRepository extends JpaRepository<Game, Long> {

    Game findByTitulo(String name);

    @Query("FROM Game f WHERE LOWER(f.titulo) like %:termo%")
    Page<Game> filtrar(@Param("termo") String termo, Pageable pageable);

}
