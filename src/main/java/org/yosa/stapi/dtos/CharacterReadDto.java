package org.yosa.stapi.dtos;

import org.yosa.stapi.domain.Race;

public class CharacterReadDto {
    public String name;
    public String race;

    public CharacterReadDto() {
    }

    public CharacterReadDto(String name, String race) {
        this.name = name;
        this.race = race;
    }
}
