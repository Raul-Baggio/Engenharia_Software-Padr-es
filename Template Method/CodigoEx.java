// TEMPLATE METHOD 

// Classe abstrata que define o "Template Method"
abstract class Missao {

    // Template Method (final para impedir mudanças)
    public final void executarMissao() {
        preparar();
        viajar();
        acaoPrincipal(); 
        retornar();
        recompensar();
    }

    // Passos comuns
    protected void preparar() {
        System.out.println("Preparando equipamentos e suprimentos...");
    }

    protected void viajar() {
        System.out.println("Viajando até o local da missão...");
    }

    protected void retornar() {
        System.out.println("Retornando ao acampamento...");
    }

    protected void recompensar() {
        System.out.println("Recebendo a recompensa da missão!");
    }

    // Passo que varia conforme a classe concreta
    protected abstract void acaoPrincipal();
}

// Implementações concretas
class MissaoGuerreiro extends Missao {
    @Override
    protected void acaoPrincipal() {
        System.out.println("O Guerreiro luta bravamente contra monstros!");
    }
}

class MissaoMago extends Missao {
    @Override
    protected void acaoPrincipal() {
        System.out.println("O Mago conjura feitiços devastadores!");
    }
}

class MissaoLadrao extends Missao {
    @Override
    protected void acaoPrincipal() {
        System.out.println("O Ladrão realiza ações furtivas sem ser detectado!");
    }
}

// Demonstração
public class CodigoEx {
    public static void main(String[] args) {

        Missao guerreiro = new MissaoGuerreiro();
        Missao mago = new MissaoMago();
        Missao ladrao = new MissaoLadrao();

        System.out.println("=== Missão do Guerreiro ===");
        guerreiro.executarMissao();

        System.out.println("\n=== Missão do Mago ===");
        mago.executarMissao();

        System.out.println("\n=== Missão do Ladrão ===");
        ladrao.executarMissao();
    }
}
