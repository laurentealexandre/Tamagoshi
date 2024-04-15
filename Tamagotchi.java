import java.util.Random;

// Classe principal Tamagotchi
class Tamagotchi {
    private String nome;
    private int idade;
    private int energia;
    private int fome;
    private int felicidade;
    private boolean doente;
    private Estagios estagio;

    // Construtor
    public Tamagotchi(String nome) {
        this.nome = nome;
        this.idade = 0;
        this.energia = 50;
        this.fome = 50;
        this.felicidade = 50;
        this.doente = false;
        this.estagio = Estagios.BEBÊ;
    }

    // Método para alimentar o Tamagotchi
    public void alimentar() { 
        fome -= 20; //Diminui 20 da fome a cada vez que é alimentado  
        if (fome < 0) fome = 0; //If para garantir que a fome não fique negativa      
        energia += 20; //Aumenta 20 de energia cada vez que é alimentado 
        if (energia > 100) energia = 100; //If para garntir que a energia não ultrapasse 100       
    }

    // Método para brincar com o Tamagotchi
    public void brincar() {
        felicidade += 20; //Aumenta 20 de felicidade cada vez que ele brinca
        if (felicidade > 100) felicidade = 100; //If para garantir que a felicidade não ultrapasse 100         
        energia -= 30; //Diminui 30 de energia cada vez que ele brinca 
        if (energia < 0) energia = 0; //If para garantir que a energia não fique negativa      
    }

    // Método para fazer o Tamagotchi dormir
    public void dormir() {
        energia += 30; //Aumenta 30 de energia cada vez que ele dorme 
        if (energia > 100) energia = 100; //If para garantir que a energia não ultrapasse 100       
        fome += 20; //Aumenta 20 de fome cada vez que ele dorme
        if (fome > 100) fome = 100; //If para garantir que a fome não ultrapasse 100         
    }

    // Método para dar remédio 
    public void darRemedio() {
        if (doente) { // Se der remédio ele cura
            doente = false; 
            System.out.println(nome + " foi curado!");
        } else { // Avisa que ele não precisa de remédio
            System.out.println(nome + " não está doente. Não é necessário dar remédio.");
        }
    }

    // Método para verificar o status do Tamagotchi
    public void verificarStatus() { //Imprime na tela as informações do Tamagotchi 
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Energia: " + energia);
        System.out.println("Fome: " + fome);
        System.out.println("Felicidade: " + felicidade);
        System.out.println("Estágio: " + estagio);
        System.out.println("Doente: " + (doente ? "Sim" : "Não"));
    }

    // Método para simular o ciclo de vida do Tamagotchi
    public void cicloDeVida(int escolha) {

        // Verifica se a energia chegou a 0
        if (energia == 0) { // Se a energia for igual a 0 ele morre
        System.out.println(nome + " morreu por falta de energia.");
        System.out.println("Saindo... Fim de jogo"); 
        System.exit(0);
    }

        // Verifica se a fome chegou a 100
        if (fome == 100) { // Se a fome for igual a 100 ele morre
        System.out.println(nome + " morreu de fome.");
        System.out.println("Saindo... Fim de jogo"); 
        System.exit(0); 
    }
        if (escolha != 5) { // If para que se a opção for 5(exibir Status) não aumente a idade
            idade++; // Aumenta a idade do Tamagotchi a cada interação com ele
        }        
        if (idade <= 3) // Se a idade for menor ou igual a 3 ele é bebê
            estagio = Estagios.BEBÊ; //estagio recebe BEBÊ
        else if (idade <= 6) // Se a idade for menor ou igual a 6 ele é adolescente
            estagio = Estagios.ADOLESCENTE; //estagio recebe ADOLESCENTE
        else  // Se a idade for maior que 5 ele é adulto
            estagio = Estagios.ADULTO; //estagio recebe ADULTO

        // Método aleatorio para definir se está doente
        Random random = new Random();
        int evento = random.nextInt(100); //Faz um sorteio de 0 a 100
        if (evento < 15) { // Se o resultado for menor que 15 ele está doente
            doente = true;
            System.out.println(nome + " está doente!"); //Imprime que ele está doente
        }
    }
}
