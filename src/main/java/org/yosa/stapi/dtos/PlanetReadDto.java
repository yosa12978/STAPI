package org.yosa.stapi.dtos;

import java.util.List;

public class PlanetReadDto {
    public String title;
    public List<String> race;

    public PlanetReadDto() {
    }

    public PlanetReadDto(String title, List<String> race) {
        this.title = title;
        this.race = race;
    }
}
