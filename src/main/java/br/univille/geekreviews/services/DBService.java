package br.univille.geekreviews.services;

import br.univille.geekreviews.core.domain.TipoMidia;
import br.univille.geekreviews.domain.*;
import br.univille.geekreviews.repositories.CategoriaRepository;
import br.univille.geekreviews.repositories.FilmeRepository;
import br.univille.geekreviews.repositories.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Calendar;

@Service
public class DBService {

    @Autowired
    private FilmeRepository filmeRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private SerieRepository serieRepository;

    public void instantiateTestDataBase() {

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
        filme1.setDirecao("Diretor do filme");
        filme1.setFaixaEtaria("DEZ");
        filme1.setElenco("Vin Diesel");
        filme1.setNascionalidade("EUA");
        filme1.setDuracao("2h 30m");
        filme1.setCategorias(Arrays.asList(cat13, cat8));
        filme1.setAvaliacoes(Arrays.asList(new Avaliacao(null, 4, filme1), new Avaliacao(null, 5, filme1)));
        filme1.setComentarios(Arrays.asList(new Comentario("Filme top!!", filme1), new Comentario("Melhor filme", filme1)));

        Filme filme2 = new Filme();
        filme2.setDataLancamento(Calendar.getInstance());
        filme2.setTipo(TipoMidia.FILME);
        filme2.setDescricao("DESCRIÇÃO DE VINGADORES");
        filme2.setTitulo("Vingadores");
        filme1.setDirecao("Diretor do filme");
        filme1.setFaixaEtaria("DEZ");
        filme1.setElenco("Homem de ferro");
        filme1.setNascionalidade("EUA");
        filme1.setDuracao("2h 30m");
        filme1.setCategorias(Arrays.asList(cat10, cat11));
        filme2.setAvaliacoes(Arrays.asList(new Avaliacao(null, 5, filme2)));
        filme1.setComentarios(Arrays.asList(new Comentario("Filme top!!", filme1), new Comentario("Melhor filme", filme1)));

        filmeRepository.saveAll(Arrays.asList(filme1, filme2));

        Serie serie = new Serie();
        serie.setDataLancamento(Calendar.getInstance());
        serie.setTipo(TipoMidia.SERIE);
        serie.setDescricao("DESCRIÇÃO DE THE BOYS");
        serie.setTitulo("The Boys");
        serie.setDirecao("Diretor do The Boys");
        serie.setFaixaEtaria("DEZOITO");
        serie.setElenco("Capitão Patria");
        serie.setNascionalidade("EUA");
        serie.setDuracao("1h 00m");
        serie.setNumeroEpisodios(8);
        serie.setNumeroTemporadas(2);
        serie.setCategorias(Arrays.asList(cat11, cat13));
        serie.setAvaliacoes(Arrays.asList(new Avaliacao(null, 10, serie)));
        serie.setComentarios(Arrays.asList(new Comentario("Série top!!", serie), new Comentario("Melhor série", serie)));

        serieRepository.saveAll(Arrays.asList(serie));
    }
}
