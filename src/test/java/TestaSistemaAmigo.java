import br.ufbp.dcx.xavier.renlson.AmigoSecreto.AmigoInexistenteException;
import br.ufbp.dcx.xavier.renlson.AmigoSecreto.AmigoNaoSorteadoException;
import br.ufbp.dcx.xavier.renlson.AmigoSecreto.Mensagem;
import br.ufbp.dcx.xavier.renlson.AmigoSecreto.SistemaAmigo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestaSistemaAmigo {

    SistemaAmigo sistema;

    @BeforeEach
    void setUp() {
        this.sistema = new SistemaAmigo();
    }

    @Test
    void questão1() {
        sistema.cadastraAmigo("Jose", "Jose.com.br");
        sistema.cadastraAmigo("Maria", "Maria.com.br");
        try{
            sistema.configuraAmigoSecretoDe("Jose.com.br", "Maria.com.br");
            sistema.configuraAmigoSecretoDe("Maria.com.br", "Jose.com.br");
        } catch (AmigoInexistenteException a){
            fail();
        }
        sistema.enviarMensagemParaAlguem("Olá", "Maria.com.br", "Jose.com.br", true);
        sistema.enviarMensagemParaTodos("Olá a Todos", "Maria.com.br", true);
        for(Mensagem m: sistema.pesquisaMensagensAnonimas()){
            System.out.println(m.getTextoCompletoAExibir());
        }
            try {
                if (sistema.pesquisaAmigoSecretoDe("Jose.com.br").equals("Maria.com.br"))
                    System.out.println("ok");
            } catch (AmigoInexistenteException | AmigoNaoSorteadoException e){
                fail("NÃO É PARA LANCAR EXCECAO");
            }
        assertThrows(AmigoInexistenteException.class, ()-> sistema.configuraAmigoSecretoDe("ose.com.br", "Maria.com.br"));

    }

    @Test
    void questâo2() {

    }


}
