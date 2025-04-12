package br.com.patrimonio.gerenciador.testes;

import org.springframework.stereotype.Component;

@Component
public class ItensTest {
    public boolean isFormatValid(String np){
        return np.matches("\\d{8}-\\d");
    }
}
