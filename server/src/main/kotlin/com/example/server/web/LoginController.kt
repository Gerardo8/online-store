package com.example.server.web

import com.example.server.security.CustomUserDetails
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(VERSION)
class LoginController {

    @GetMapping("/login")
    fun login(@AuthenticationPrincipal customUserDetails: CustomUserDetails) = customUserDetails
}