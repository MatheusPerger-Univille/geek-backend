package br.univille.geekreviews.domain;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;

@Entity
@DynamicUpdate
public class Filme extends FilmeSerie {

}
