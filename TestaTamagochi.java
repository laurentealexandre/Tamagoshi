import java.util.Scanner;

// Classe principal do programa
public class TestaTamagochi {
    public static void main(String[] args) {
         
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Digite o nome do Tamagotchi:"); // Pede para o usuário digitar o nome do Tamagotchi
        String nomeTamagotchi = sc.nextLine();

        Tamagotchi tamagotchi = new Tamagotchi(nomeTamagotchi); //Cria um objeto da classe Tamagotchi

        // Cria um loop infinito para interagir com o Tamagochi
        while (true) {
            System.out.println("\nEscolha uma ação:");
            System.out.println("1. Alimentar");
            System.out.println("2. Brincar");
            System.out.println("3. Fazer dormir");
            System.out.println("4. Dar remédio");
            System.out.println("5. Verificar status");
            System.out.println("6. Sair");

            int escolha = sc.nextInt();

            switch (escolha) {
                case 1: //Caso escolha 1 alimenta
                    tamagotchi.alimentar();
                    System.out.println("\nAlimentado");
                    break;
                case 2: //Caso escolha 2 brinca
                    tamagotchi.brincar();
                    System.out.println("\nBrincou");
                    break;
                case 3: //Caso escolha 3 dorme
                    tamagotchi.dormir();
                    System.out.println("\nDormiu");
                    break;
                case 4: //Caso escolha 3 da remédio
                    tamagotchi.darRemedio();
                    System.out.println("\nTomou remédio");
                    break;
                case 5: //Caso escolha 5 imprime status
                    tamagotchi.verificarStatus();
                    break;
                case 6: //Caso escolha 6 encerra o programa
                    System.out.println("Saindo...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Escolha inválida!");
            }

            // Simulação do ciclo de vida a cada interação
            tamagotchi.cicloDeVida(escolha);
        }
    }
}
