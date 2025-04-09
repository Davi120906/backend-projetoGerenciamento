package br.com.patrimonio.gerenciador.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuario")
public class UserController {
    @GetMapping
    public String teste(){
        return "lowwwwww";
    }
}
