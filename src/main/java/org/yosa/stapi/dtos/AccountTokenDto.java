package org.yosa.stapi.dtos;

public class AccountTokenDto {
    private String id;
    private String username;
    private String token;

    public AccountTokenDto() {
    }

    public AccountTokenDto(String id, String username, String token) {
        this.id = id;
        this.username = username;
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
