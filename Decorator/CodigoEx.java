// DECORATOR

package Decorator;

// Componente base
interface Personagem {
    String getDescricao();
    int getPoder();
}

// Implementação concreta do componente
class Guerreiro implements Personagem {

    @Override
    public String getDescricao() {
        return "Guerreiro básico";
    }

    @Override
    public int getPoder() {
        return 10;
    }
}

// Decorator base
abstract class PersonagemDecorator implements Personagem {
    protected Personagem personagem;

    public PersonagemDecorator(Personagem personagem) {
        this.personagem = personagem;
    }

    @Override
    public String getDescricao() {
        return personagem.getDescricao();
    }

    @Override
    public int getPoder() {
        return personagem.getPoder();
    }
}

// Decorators concretos
class ArmaduraPesada extends PersonagemDecorator {

    public ArmaduraPesada(Personagem personagem) {
        super(personagem);
    }

    @Override
    public String getDescricao() {
        return personagem.getDescricao() + " + Armadura Pesada";
    }

    @Override
    public int getPoder() {
        return personagem.getPoder() + 15;
    }
}

class EspadaLonga extends PersonagemDecorator {

    public EspadaLonga(Personagem personagem) {
        super(personagem);
    }

    @Override
    public String getDescricao() {
        return personagem.getDescricao() + " + Espada Longa";
    }

    @Override
    public int getPoder() {
        return personagem.getPoder() + 8;
    }
}

class EscudoDeAco extends PersonagemDecorator {

    public EscudoDeAco(Personagem personagem) {
        super(personagem);
    }

    @Override
    public String getDescricao() {
        return personagem.getDescricao() + " + Escudo de Aço";
    }

    @Override
    public int getPoder() {
        return personagem.getPoder() + 5;
    }
}

// Demonstração (main)
public class CodigoEx {

    public static void main(String[] args) {

        Personagem guerreiro = new Guerreiro();
        System.out.println(guerreiro.getDescricao() + " | Poder: " + guerreiro.getPoder());

        guerreiro = new ArmaduraPesada(guerreiro);
        guerreiro = new EspadaLonga(guerreiro);
        guerreiro = new EscudoDeAco(guerreiro);

        System.out.println(guerreiro.getDescricao() + " | Poder: " + guerreiro.getPoder());
    }
}
