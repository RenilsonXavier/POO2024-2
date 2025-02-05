import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public void cadastraAmigo (String nomeAmigo, String emailAmigo){
        Amigo amigo = new Amigo(nomeAmigo, emailAmigo);
        this.amigos.add(amigo);
    }
    public Amigo pesquisaAmigo(String emailAmigo) {
        for (Amigo a: this.amigos){
            if (a.getEmailAmigoSorteado().equals(emailAmigo)){
                return a;
            }
        }
        return null;
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        Mensagem mensagem = new Mensagem(texto, emailRemetente, ehAnonima);
        this.mensagens.add(mensagem);
    }
    public void enviarMensagemParaAlguem(String texto,String emailRemetente,String emailDestinatario,boolean ehAnonima){
        Mensagem mensagem = new Mensagem(texto,emailRemetente,emailDestinatario,ehAnonima);
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
        }return lista;
    }
    public void configuraAmigoSecretoDe(String emailDaPessoa,String emailAmigoSorteado){

    }
}
