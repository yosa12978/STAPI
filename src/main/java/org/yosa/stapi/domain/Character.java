package org.yosa.stapi.domain;

import javax.persistence.*;

@Entity
@Table(name = "character")
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String race;

    public Character() {

    }

    public Character(String name, String race) {
        this.name = name;
        this.race = race;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }
}
