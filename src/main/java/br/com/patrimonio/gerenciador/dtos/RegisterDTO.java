package br.com.patrimonio.gerenciador.dtos;

import br.com.patrimonio.gerenciador.classes.UserRoles;

public record RegisterDTO(String id, String nome, String password, UserRoles role) {
}