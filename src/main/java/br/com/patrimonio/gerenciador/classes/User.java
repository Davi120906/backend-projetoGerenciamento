package br.com.patrimonio.gerenciador.classes;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private long id;
    private String nome;
    private UserRoles role;
    @Setter(AccessLevel.NONE)
    private String password;
}
