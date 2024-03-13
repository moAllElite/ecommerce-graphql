package com.groupeisi.ecommercegraphql.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "utilisateur")
public class User  implements UserDetails , Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String email;
    private  String nom;
    private  String password;
    private boolean actived ;
    @OneToOne(cascade = {CascadeType.ALL})
    private  Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_"+this.role.getLibelle()));
    }
    @Override
    public String getPassword() {
        return this.password;
    }
    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.actived;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.actived;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.actived;
    }

    @Override
    public boolean isEnabled() {
        return this.actived;
    }
}
