/*package bankApi.bank_api.security;

import bankApi.bank_api.entities.users.UserTwo;

import java.util.Collections;
import java.util.HashSet;

public class CustomUserDetails implements UserDetails{

    private UserTwo user;

    public Collection<? extends GrantedAuthority> getAuthorities(){
        Collections<GrantedAuthority> authorities = new HashSet<>();
        for(Role role: user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.getRole()))
        }
        return authorities;
    }
}*/
