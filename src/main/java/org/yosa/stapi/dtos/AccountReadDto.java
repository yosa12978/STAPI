package org.yosa.stapi.dtos;

public class AccountReadDto {
    public String username;
    public String password;

    public AccountReadDto() {
    }

    public AccountReadDto(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
