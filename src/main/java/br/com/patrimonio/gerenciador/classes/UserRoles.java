package br.com.patrimonio.gerenciador.classes;

public enum UserRoles {
    ADMIN("admin"),
    USER("user");
    private String role;
    UserRoles(String role){
        this.role = role;
    }
    public String getRole(){
        return role;
    }
}
