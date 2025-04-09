package br.com.patrimonio.gerenciador.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.patrimonio.gerenciador.classes.Itens;
import br.com.patrimonio.gerenciador.services.ItensService;

@RestController
@RequestMapping("api/itens")
public class ItensController {
    @Autowired
    ItensService itensService;
    @GetMapping
    public Itens teste(){
       return itensService.getAllItens().get(0);
    }
}
