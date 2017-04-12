package com.dianmei.auth.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

/**
 * Created by lout on 2017/4/12.
 */
@Entity
@Table(name = "user")
public class User implements UserDetails{

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "USERNAME", length = 50, unique = true)
    @NotNull
    @Size(min = 4, max = 50)
    private String username;

    @Column(name = "PASSWORD", length = 100)
    @NotNull
    @Size(min = 4, max = 100)
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() { return null; }

    @Override
    public String getPassword() { return null; }

    @Override
    public String getUsername() { return null; }

    @Override
    public boolean isAccountNonExpired() { return false; }

    @Override
    public boolean isAccountNonLocked() { return false; }

    @Override
    public boolean isCredentialsNonExpired() { return false; }

    @Override
    public boolean isEnabled() { return false; }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(int id) { this.id = id; }

    public int getId() { return id; }
}
