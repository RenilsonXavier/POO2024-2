public class MensagemParaAlguem extends Mensagem {

    private String emailDestinatario;

    public MensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonima){
        super(texto, emailRemetente, anonima);
        this.emailDestinatario = emailDestinatario;
    }
    public String getEmailDestinatario(){
        return this.emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    @Override
    public String getTextoCompletoAExibir(){
        String textoCompleto;
        if (this.ehAnonima()) {
            textoCompleto = "Mensagem para " + this.emailDestinatario + "\n" + this.getTexto() + "\n de anonima";
        } else {
            textoCompleto = "Mensagem para "+ this.emailDestinatario + "\n"+ this.getTexto() +"\n de "+ this.getEmailRemetente();
        }
        return textoCompleto;
    }
}