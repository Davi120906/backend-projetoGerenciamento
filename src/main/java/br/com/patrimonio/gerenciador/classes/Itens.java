package br.com.patrimonio.gerenciador.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "itens")
public class Itens{
    @Id
    private String nPatrimonio;
    private String nAntigo;
    private String descricao;
    private String conservacao;
    private float valorBem;
    private ItensEstado state;
    private String foto;
    private String salaRegistrada;
    private String salaAtual;
    
    public Itens(String nPatrimonio, String nAntigo, String descricao, String conservacao, float valorBem, String foto, String salaRegistrada, String salaAtual) {
        this.nPatrimonio = nPatrimonio;
        this.nAntigo = nAntigo;
        this.descricao = descricao;
        this.conservacao = conservacao;
        this.valorBem = valorBem;
        this.foto = foto;
        this.salaRegistrada = salaRegistrada;
        this.salaAtual = salaAtual;
    }
}
