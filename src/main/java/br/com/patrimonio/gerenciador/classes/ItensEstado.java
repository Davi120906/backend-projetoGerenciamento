package br.com.patrimonio.gerenciador.classes;

public enum ItensEstado {
    OCIOSO("ocioso"),
    QUEBRADO("quebrado"),
    NAOENCONTRADO("nao encontrado"),
    SEMPLAQUETA("sem plaqueta");
    private String state;
    ItensEstado(String state){
        this.state = state;
    }
    public String getState(){
        return this.state;
    }
    public void setState(String state){
        this.state = state;
    }

}
