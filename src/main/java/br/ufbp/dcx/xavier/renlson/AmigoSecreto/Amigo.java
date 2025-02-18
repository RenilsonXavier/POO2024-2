package br.ufbp.dcx.xavier.renlson.AmigoSecreto;

public class Amigo {
    private String nome;
    private String email;
    private String emailAmigoSorteado;

    public Amigo(String nome, String email){
        this.nome = nome;
        this.email = email;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmailAmigoSorteado(){
        return this.emailAmigoSorteado;
    }
    public void setAmigoSorteado(String emailAmigoSorteado){
        this.emailAmigoSorteado = emailAmigoSorteado;
    }
}

