package org.yosa.stapi.dtos;

public class CharacterDto {
    private String id;
    private String name;
    private String race;

    public CharacterDto() {
    }

    public CharacterDto(String id, String name, String race) {
        this.id = id;
        this.name = name;
        this.race = race;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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
