package com.example.server.security

import com.example.server.domain.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.core.userdetails.UserDetails

class CustomUserDetails(val user: User) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return AuthorityUtils.commaSeparatedStringToAuthorityList(this.user.authorities.joinToString { it.name })
    }

    override fun isEnabled() = true

    override fun getUsername() = this.user.username

    override fun isCredentialsNonExpired() = true

    override fun getPassword() = this.user.password

    override fun isAccountNonExpired() = true

    override fun isAccountNonLocked() = true
}
