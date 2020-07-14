package br.univille.geekreviews.core.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@MappedSuperclass
public abstract class EntityBaseRoot implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    public abstract Long getId();

    public abstract void setId(Long id);

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Calendar dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Calendar dataAlteracao;

    public Calendar getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Calendar dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Calendar getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Calendar dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;

        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (!this.getClass().isAssignableFrom(obj.getClass()))
            return false;

        EntityBaseRoot other = (EntityBaseRoot) obj;

        if (this.getId() == null)
            return false;

        return this.getId().equals(other.getId());
    }

    @PrePersist
    protected void onCreate() {

        if (dataCriacao == null)
            dataCriacao = Calendar.getInstance();

        dataAlteracao = Calendar.getInstance();
    }

    @PreUpdate
    protected void onUpdate() {

        dataAlteracao = Calendar.getInstance();

        if (dataCriacao == null)
            dataCriacao = dataAlteracao;
    }
}
