package org.yosa.stapi.dtos;

public class StarshipDto {
    private String id;
    private String title;
    private String registry;
    private String status;

    public StarshipDto() {
    }

    public StarshipDto(String id, String title, String registry, String status) {
        this.id = id;
        this.title = title;
        this.registry = registry;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegistry() {
        return registry;
    }

    public void setRegistry(String registry) {
        this.registry = registry;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
