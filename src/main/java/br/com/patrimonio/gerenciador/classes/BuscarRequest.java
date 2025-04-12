package br.com.patrimonio.gerenciador.classes;


public class BuscarRequest {
    private final String tipoBusca;
    private final String busca;
    public BuscarRequest(String tipoBusca, String busca){
        this.tipoBusca = tipoBusca;
        this.busca = busca;
    }
    public String getBusca(){
        return this.busca;
    }
    public String getTipoBusca(){
        return this.tipoBusca;
    }
}
