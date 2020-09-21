package org.yosa.stapi.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.lang.NonNull;

import java.util.Collections;
import java.util.Set;

@Document
public class Account {
    @Id
    private String id;
    @NonNull
    private String username;
    @NonNull
    private String password;
    private Set<Role> roles;

    private String token;

    public Account() {
    }

    public Account(@NonNull String username, @NonNull String password) {
        this.username = username;
        this.password = password;
        this.roles = Collections.singleton(Role.ROLE_USER);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @NonNull
    public String getUsername() {
        return username;
    }

    public void setUsername(@NonNull String username) {
        this.username = username;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
