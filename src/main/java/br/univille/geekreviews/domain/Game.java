package br.univille.geekreviews.domain;

import br.univille.geekreviews.core.domain.Midia;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@DynamicUpdate
public class Game extends Midia {

    private String desenvolvedora;

    private boolean opcaoOnline;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Plataforma> plataformas;

    public Game() {
    }

    public String getDesenvolvedora() {
        return desenvolvedora;
    }

    public void setDesenvolvedora(String desenvolvedora) {
        this.desenvolvedora = desenvolvedora;
    }

    public boolean isOpcaoOnline() {
        return opcaoOnline;
    }

    public void setOpcaoOnline(boolean opcaoOnline) {
        this.opcaoOnline = opcaoOnline;
    }

    public List<Plataforma> getPlataformas() {
        return plataformas;
    }

    public void setPlataformas(List<Plataforma> plataformas) {
        this.plataformas = plataformas;
    }
}
