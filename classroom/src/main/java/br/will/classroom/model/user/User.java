package br.will.classroom.model.user;

import java.util.Collection;
import java.util.List;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import br.will.classroom.model.utils.UsuarioRole;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements UserDetails {
    
    @Id
    //  @GeneratedValue(strategy = GenerationType.IDENTITY)
    public String id;
    public String nome;
    public String senha;
    public String email;
    //SENDO USADO NO OVVERRIDEKKKKK
    public static UsuarioRole UsuarioLogin;


    public User(String id, String nome, String senha, String email){
        this.id = id;
        this. nome = nome;
        this.email = email;
    }

    public User() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (UsuarioLogin == UsuarioRole.COORDINATOR) {
            return List.of(
                new SimpleGrantedAuthority("SENHACOORDENADOR"),
                new SimpleGrantedAuthority("SENHAPROFESSOR")); 
        }else{
            return List.of(new SimpleGrantedAuthority("NOVA SENHAPROFESSOR"));
        }
    }
    @Override
    public String getPassword() {
        return senha;
    }
    @Override
    public String getUsername() {
        return nome;
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

    public String getNome() {
        return nome;
    }
}