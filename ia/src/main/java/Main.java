import java.util.Scanner;

public class Main{
    static class Ambiente {
        boolean[] quartos = new boolean[2];
        public Ambiente(boolean quarto1, boolean quarto2) {
            quartos[0] = quarto1;
            quartos[1] = quarto2;
        }
        public boolean isQuartoSujo(int index) {
            return quartos[index];
        }
        public void limparQuarto(int index) {
            quartos[index] = false;
            System.out.println("Quarto " + (index + 1) + " foi limpo.");
        }
    }
    static class Agente {
        int posicao; 

        public Agente(int posicaoInicial) {
            posicao = posicaoInicial;
        }

        public void percepcaoEAcao(Ambiente ambiente) {
            if (ambiente.isQuartoSujo(posicao)) {
                ambiente.limparQuarto(posicao);
            } else {
                posicao = (posicao == 0) ? 1 : 0;
                System.out.println("Movendo para o quarto " + (posicao + 1));
            }
        }
    }

    public static void main(String[] args) {
        Ambiente ambiente = new Ambiente(true, false);
        Agente agente = new Agente(0);

        Scanner scanner = new Scanner(System.in);
        String comando;
        while (true) {
            System.out.println("Estado do ambiente: Quarto 1 " + (ambiente.quartos[0] ? "sujo" : "limpo") + 
                                ", Quarto 2 " + (ambiente.quartos[1] ? "sujo" : "limpo"));
            System.out.println("Agente está no quarto " + (agente.posicao + 1));
            System.out.print("Pressione Enter para o agente tomar uma ação, ou 'q' para sair: ");
            comando = scanner.nextLine();
            if (comando.equalsIgnoreCase("q")) {
                break;
            }
            agente.percepcaoEAcao(ambiente);
        }

        scanner.close();
    }
}
