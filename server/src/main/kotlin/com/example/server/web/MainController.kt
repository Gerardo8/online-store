package com.example.server.web

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class MainController {

    @GetMapping("/{path:[^\\.]*}")
    fun redirect() = "forward:/"

}
