package br.univille.geekreviews;

import br.univille.geekreviews.core.domain.TipoMidia;
import br.univille.geekreviews.domain.Categoria;
import br.univille.geekreviews.domain.Filme;
import br.univille.geekreviews.domain.enums.Categoriaoo;
import br.univille.geekreviews.repositories.CategoriaRepository;
import br.univille.geekreviews.repositories.FilmeRepository;
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

    @Autowired
    private CategoriaRepository categoriaRepository;

    public static void main(String[] args) {
        SpringApplication.run(GeekreviewsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Categoria cat1 = new Categoria("PS4");
        Categoria cat2 = new Categoria("XBOXONE");
        Categoria cat3 = new Categoria("SWITCH");
        Categoria cat4 = new Categoria("AVENTURA");
        Categoria cat5 = new Categoria("ACAO");
        Categoria cat6 = new Categoria("SUSPENSE");
        Categoria cat7 = new Categoria("TERROR");
        Categoria cat8 = new Categoria("DRAMA");
        Categoria cat9 = new Categoria("ROMANCE");
        Categoria cat10 = new Categoria("COMPUTACAO");
        Categoria cat11 = new Categoria("FANTASIA");
        Categoria cat12 = new Categoria("HORROR");
        Categoria cat13 = new Categoria("FICCAO");

        categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4, cat5, cat6, cat7, cat8, cat9, cat10, cat11, cat12, cat13));

        Filme filme1 = new Filme();
        filme1.setDataLancamento(Calendar.getInstance());
        filme1.setTipo(TipoMidia.FILME);
        filme1.setDescricao("DESCRIÇÃO DE VELOZES");
        filme1.setTitulo("Velozes e Furiosos 8");
        // filme1.setCategorias(Arrays.asList(cat13, cat8));
        filme1.getCategorias().addAll(Arrays.asList(cat13, cat8));

        Filme filme2 = new Filme();
        filme2.setDataLancamento(Calendar.getInstance());
        filme2.setTipo(TipoMidia.FILME);
        filme2.setDescricao("DESCRIÇÃO DE VINGADORES");
        filme2.setTitulo("Vingadores");

        filmeRepository.saveAll(Arrays.asList(filme1, filme2));
    }
}
