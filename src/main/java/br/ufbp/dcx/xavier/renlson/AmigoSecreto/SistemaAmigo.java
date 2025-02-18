package br.ufbp.dcx.xavier.renlson.AmigoSecreto;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo(){
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    public void cadastraAmigo (String nomeAmigo, String emailAmigo){
        Amigo amigo = new Amigo(nomeAmigo, emailAmigo);
        this.amigos.add(amigo);
    }
    public Amigo pesquisaAmigo(String emailAmigo) {
        for (Amigo a: this.amigos){
            if (a.getEmail().equals(emailAmigo)){
                return a;
            }
        }
        return null;
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        Mensagem mensagem = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        this.mensagens.add(mensagem);
    }
    public void enviarMensagemParaAlguem(String texto,String emailRemetente,String emailDestinatario,boolean ehAnonima){
        Mensagem mensagem = new MensagemParaAlguem(texto,emailRemetente,emailDestinatario,ehAnonima);
        this.mensagens.add(mensagem);
    }
    public List<Mensagem> pesquisaMensagensAnonimas(){
        List<Mensagem> lista = new ArrayList<>();
        for (Mensagem mensagem:this.mensagens){
            if (mensagem.ehAnonima()){
                lista.add(mensagem);
            }
        } return lista;
    }
    public List<Mensagem> pesquisaTodasAsMensagens(){
        List<Mensagem> lista = new ArrayList<>();
        for (Mensagem mensagem:this.mensagens){
            lista.add(mensagem);
        }
        return lista;
    }
    public void configuraAmigoSecretoDe(String emailDaPessoa,String emailAmigoSorteado) throws AmigoInexistenteException{
        Amigo amigo;
        boolean verdade = true;
        for(Amigo a : this.amigos){
            if(a.getEmail().equalsIgnoreCase(emailDaPessoa)){
                amigo = a;
                amigo.setAmigoSorteado(emailAmigoSorteado);
                verdade = false;
            }
        }
        if(verdade) {
            throw new  AmigoInexistenteException("Não existe");
        }
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException{
        for (Amigo a : this.amigos){
            if (a.getEmail().equalsIgnoreCase(emailDaPessoa)) {
                if (a.getEmailAmigoSorteado() == null){
                    throw new AmigoNaoSorteadoException("br.ufbp.dcx.xavier.renlson.AmigoSecreto.Amigo não foi sorteado");
                }else {
                    return a.getEmailAmigoSorteado();
                }
            }
        }
        throw new AmigoInexistenteException("br.ufbp.dcx.xavier.renlson.AmigoSecreto.Amigo não existe");
    }
}
