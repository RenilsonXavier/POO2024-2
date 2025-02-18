public class MensagemParaTodos extends Mensagem {
    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima){
        super(texto, emailRemetente, anonima);
    }

    @Override
    public String getTextoCompletoAExibir() {
        String textoCompleto;
        if (this.ehAnonima()) {
            textoCompleto = "Mensagem para todos \n" + this.getTexto() + "\n de anonima";
        } else {
            textoCompleto = "Mensagem para todos \n" + this.getTexto() +"\n de "+ this.getEmailRemetente();
        }
        return textoCompleto;
    }
}
