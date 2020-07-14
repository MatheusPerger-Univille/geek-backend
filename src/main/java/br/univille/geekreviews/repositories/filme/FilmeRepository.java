package br.univille.geekreviews.repositories.filme;

import br.univille.geekreviews.domain.Filme;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

    Filme findByTitulo(String name);

}
