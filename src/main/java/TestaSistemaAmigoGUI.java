import java.util.Scanner;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args){
        SistemaAmigo sistema = new SistemaAmigo();
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos ammigos iram participar?");
        int quantPessoas = Integer.parseInt(sc.nextLine());

        for (int k=0; k<quantPessoas; k++){
            System.out.println("Informe o nome para cadastro?");
            String nome = sc.nextLine();
            System.out.println("Informe o email para cadastro?");
            String email = sc.nextLine();
            sistema.cadastraAmigo(nome, email);
        }
        sistema.enviarMensagemParaTodos("Ola", "Jose.com.br",false);

    }
}
