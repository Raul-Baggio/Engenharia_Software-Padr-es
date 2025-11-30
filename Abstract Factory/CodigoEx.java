// ABSTRACT FACTORY – Exemplo: Jogo com facções de NPCs

// FÁBRICA ABSTRATA
interface NPCFactory {
    Warrior createWarrior();
    Archer createArcher();
    Healer createHealer();
}

// FÁBRICAS CONCRETAS

// Facção Humana
class HumanFactory implements NPCFactory {

    @Override
    public Warrior createWarrior() {
        return new HumanWarrior();
    }

    @Override
    public Archer createArcher() {
        return new HumanArcher();
    }

    @Override
    public Healer createHealer() {
        return new HumanPriest();
    }
}

// Facção Orc
class OrcFactory implements NPCFactory {

    @Override
    public Warrior createWarrior() {
        return new OrcWarrior();
    }

    @Override
    public Archer createArcher() {
        return new OrcArcher();
    }

    @Override
    public Healer createHealer() {
        return new OrcShaman();
    }
}

// PRODUTOS ABSTRATOS
interface Warrior {
    void attack();
}

interface Archer {
    void shoot();
}

interface Healer {
    void heal();
}

// PRODUTOS CONCRETOS – HUMANOS
class HumanWarrior implements Warrior {
    @Override
    public void attack() {
        System.out.println("Guerreiro Humano ataca com espada!");
    }
}

class HumanArcher implements Archer {
    @Override
    public void shoot() {
        System.out.println("Arqueiro Humano dispara uma flecha precisa!");
    }
}

class HumanPriest implements Healer {
    @Override
    public void heal() {
        System.out.println("Sacerdote Humano lança uma cura divina!");
    }
}

// PRODUTOS CONCRETOS – ORCS
class OrcWarrior implements Warrior {
    @Override
    public void attack() {
        System.out.println("Guerreiro Orc golpeia com seu machado pesado!");
    }
}

class OrcArcher implements Archer {
    @Override
    public void shoot() {
        System.out.println("Arqueiro Orc dispara uma flecha brutal!");
    }
}

class OrcShaman implements Healer {
    @Override
    public void heal() {
        System.out.println("Xamã Orc convoca espíritos para curar!");
    }
}

// CÓDIGO CLIENTE (O JOGO)
class Game {

    private final NPCFactory factory;
    private Warrior warrior;
    private Archer archer;
    private Healer healer;

    public Game(NPCFactory factory) {
        this.factory = factory;
    }

    public void createNPCs() {
        warrior = factory.createWarrior();
        archer = factory.createArcher();
        healer = factory.createHealer();
    }

    public void play() {
        warrior.attack();
        archer.shoot();
        healer.heal();
    }
}

// EXEMPLO DE USO
public class CodigoEx {

    public static void main(String[] args) {

        String faction = "Orc";

        NPCFactory factory;

        if (faction.equals("Human")) {
            factory = new HumanFactory();
        } else if (faction.equals("Orc")) {
            factory = new OrcFactory();
        } else {
            throw new RuntimeException("Facção desconhecida!");
        }

        Game game = new Game(factory);
        game.createNPCs();
        game.play();
    }
}

