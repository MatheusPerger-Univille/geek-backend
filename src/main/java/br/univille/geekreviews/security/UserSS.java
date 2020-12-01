package br.univille.geekreviews.security;

import br.univille.geekreviews.domain.enums.Permissao;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

public class UserSS implements UserDetails {

    private  static  final long serialVersionUID = 1L;

    private Long id;
    private String email;
    private String senha;
    private Collection<? extends GrantedAuthority> authorities;

    public UserSS() {
    }

    public UserSS(Long id, String email, String senha, Permissao permissao) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        // this.authorities = perfis.stream().map(x -> new SimpleGrantedAuthority(x.getDescricao())).collect(Collectors.toList());
        this.authorities = Arrays.asList(new SimpleGrantedAuthority(permissao.getDescricao()));
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public boolean isAdmin() {
        return getAuthorities().contains(new SimpleGrantedAuthority(Permissao.ADMINISTRADOR.getDescricao()));
    }

    public boolean isRedator() {
        return getAuthorities().contains(new SimpleGrantedAuthority(Permissao.REDATOR.getDescricao()));
    }

    public boolean isAdminOrRedator() {
        return isAdmin() || isRedator();
    }
}
