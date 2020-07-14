package br.univille.geekreviews;

import br.univille.geekreviews.core.domain.TipoMidia;
import br.univille.geekreviews.domain.Filme;
import br.univille.geekreviews.domain.enums.Categoria;
import br.univille.geekreviews.repositories.filme.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Calendar;

@SpringBootApplication
public class GeekreviewsApplication implements CommandLineRunner {

    @Autowired
    private FilmeRepository filmeRepository;

    public static void main(String[] args) {
        SpringApplication.run(GeekreviewsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Filme filme1 = new Filme();
        filme1.setDataLancamento(Calendar.getInstance());
        filme1.setTipo(TipoMidia.FILME);
        filme1.setDescricao("DESCRIÇÃO DE VELOZES");
        filme1.setTitulo("Velozes e Furiosos 8");
        // filme1.setCategorias(Arrays.asList(Categoria.AVENTURA, Categoria.DRAMA));

        Filme filme2 = new Filme();
        filme2.setDataLancamento(Calendar.getInstance());
        filme2.setTipo(TipoMidia.FILME);
        filme2.setDescricao("DESCRIÇÃO DE VINGADORES");
        filme2.setTitulo("Vingadores");

        filmeRepository.saveAll(Arrays.asList(filme1, filme2));
    }
}
