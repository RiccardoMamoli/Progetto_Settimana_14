package riccardomamoli.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "catalogo")
@Inheritance(strategy = InheritanceType.JOINED)

public abstract class elementoBaseCatalogo {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    protected UUID id;

    @Column(name = "Titolo")
    protected String titolo;

    @Column(name = "Anno Pubblicazione")
    protected LocalDate anno_pubblicazione;

    @Column(name = "Numero Pagine")
    protected int numero_pagine;

    public elementoBaseCatalogo(){}

    public elementoBaseCatalogo(String titolo, LocalDate anno_pubblicazione, int numero_pagine) {
        this.titolo = titolo;
        this.anno_pubblicazione = anno_pubblicazione;
        this.numero_pagine = numero_pagine;
    }

    public UUID getId() {
        return id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public LocalDate getAnno_pubblicazione() {
        return anno_pubblicazione;
    }

    public void setAnno_pubblicazione(LocalDate anno_pubblicazione) {
        this.anno_pubblicazione = anno_pubblicazione;
    }

    public int getNumero_pagine() {
        return numero_pagine;
    }

    public void setNumero_pagine(int numero_pagine) {
        this.numero_pagine = numero_pagine;
    }

    @Override
    public String toString() {
        return "elementoBaseCatalogo{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", anno_pubblicazione=" + anno_pubblicazione +
                ", numero_pagine=" + numero_pagine +
                '}';
    }
}
