import java.util.Scanner;
import java.util.Random;

// Enumeração para os estágios de crescimento do Tamagotchi
enum Stage {
    BEBÊ,
    ADOLESCENTE,
    ADULTO
}

// Classe principal Tamagotchi
class Tamagotchi {
    private String nome;
    private int idade;
    private int energia;
    private int fome;
    private int felicidade;
    private boolean doente;
    private Stage stage;

    // Construtor
    public Tamagotchi(String nome) {
        this.nome = nome;
        this.idade = 0;
        this.energia = 100;
        this.fome = 0;
        this.felicidade = 100;
        this.doente = false;
        this.stage = Stage.BEBÊ;
    }

    // Método para alimentar o Tamagotchi
    public void alimentar() {
        fome -= 20;
        if (fome < 0) fome = 0;
        energia += 10;
        if (energia > 100) energia = 100;
    }

    // Método para brincar com o Tamagotchi
    public void brincar() {
        felicidade += 20;
        if (felicidade > 100) felicidade = 100;
        energia -= 15;
        if (energia < 0) energia = 0;
    }

    // Método para fazer o Tamagotchi dormir
    public void dormir() {
        energia += 30;
        if (energia > 100) energia = 100;
        fome += 10;
        if (fome > 100) fome = 100;
    }

    // Método para verificar o status do Tamagotchi
    public void verificarStatus() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Energia: " + energia);
        System.out.println("Fome: " + fome);
        System.out.println("Felicidade: " + felicidade);
        System.out.println("Estágio: " + stage);
        System.out.println("Doente: " + (doente ? "Sim" : "Não"));
    }

    // Método para simular o ciclo de vida do Tamagotchi
    public void cicloDeVida() {
        idade++;
        if (idade <= 5)
            stage = Stage.BEBÊ;
        else if (idade <= 10)
            stage = Stage.ADOLESCENTE;
        else
            stage = Stage.ADULTO;

        // Simular eventos aleatórios
        Random random = new Random();
        int evento = random.nextInt(100);
        if (evento < 5) { // 5% de chance de ficar doente
            doente = true;
            System.out.println(nome + " está doente!");
        }
    }
}

// Classe principal do programa
public class Main {
    public static void main(String[] args) {
        Tamagotchi tamagotchi = new Tamagotchi("Tama");
        Scanner scanner = new Scanner(System.in);

        // Loop para interação com o usuário
        while (true) {
            System.out.println("\nEscolha uma ação:");
            System.out.println("1. Alimentar");
            System.out.println("2. Brincar");
            System.out.println("3. Fazer dormir");
            System.out.println("4. Verificar status");
            System.out.println("5. Sair");

            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    tamagotchi.alimentar();
                    break;
                case 2:
                    tamagotchi.brincar();
                    break;
                case 3:
                    tamagotchi.dormir();
                    break;
                case 4:
                    tamagotchi.verificarStatus();
                    break;
                case 5:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Escolha inválida!");
            }

            // Simulação do ciclo de vida a cada interação
            tamagotchi.cicloDeVida();
        }
    }
}
