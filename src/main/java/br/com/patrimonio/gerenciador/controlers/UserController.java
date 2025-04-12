package br.com.patrimonio.gerenciador.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.patrimonio.gerenciador.classes.User;
import br.com.patrimonio.gerenciador.services.UserService;

@RestController
@RequestMapping("api/usuario")
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping
    public List<User> getAllUser(){
        return userService.getAllUser();
    }
}
