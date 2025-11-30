Abstract Factory – Exemplo com NPCs em um Jogo

Este repositório demonstra o padrão de projeto Abstract Factory, utilizando um cenário de jogo com NPCs (personagens não jogáveis) pertencentes a diferentes facções, como Humanos e Orcs.

O conteúdo conceitual foi baseado no catálogo de padrões de projeto do Refactoring Guru https://refactoring.guru/pt-br/design-patterns.

A implementação do exemplo foi auxiliada pela LLM ChatGPT (GPT-5.1).

Objetivo do Padrão

O Abstract Factory permite criar famílias de objetos relacionados sem expor suas classes concretas, garantindo consistência entre eles.

No contexto deste projeto:

Cada facção representa uma família de NPCs.

Cada família possui guerreiro, arqueiro e curandeiro compatíveis entre si.

O jogo pode trocar de facção em tempo de execução sem alterar o código cliente.

Problema

Em jogos com diversas facções, é comum ter:

Humanos, Orcs, Elfos, etc.

Cada facção possui versões próprias de classes como Warrior, Archer e Healer.

Sem Abstract Factory, o código corre o risco de criar combinações inconsistentes:

Guerreiro Humano com Curandeiro Orc

Arqueiro Elfo com Guerreiro Goblin

Isso gera bugs e dificulta manutenção.

Solução com Abstract Factory

O padrão organiza o sistema em três camadas principais:

1. Fábrica Abstrata

Define quais tipos de objetos podem ser criados.
Exemplo do jogo:

createWarrior()

createArcher()

createHealer()

2. Fábricas Concretas

Uma fábrica por facção:

HumanFactory

OrcFactory

Cada uma cria versões compatíveis dos NPCs.

3. Produtos Abstratos e Concretos

Produtos abstratos:

Warrior

Archer

Healer

Implementações concretas:

HumanWarrior, OrcWarrior

HumanArcher, OrcArcher

HumanPriest, OrcShaman

4. Código Cliente (Game)

Recebe apenas a fábrica certa e cria NPCs sem saber qual classe concreta está sendo usada.

UML (PlantUML)

@startuml

title Abstract Factory - NPC Game

interface NPCFactory {
    createWarrior() : Warrior
    createArcher() : Archer
    createHealer() : Healer
}

class HumanFactory implements NPCFactory
class OrcFactory implements NPCFactory

HumanFactory --> HumanWarrior
HumanFactory --> HumanArcher
HumanFactory --> HumanPriest

OrcFactory --> OrcWarrior
OrcFactory --> OrcArcher
OrcFactory --> OrcShaman

interface Warrior {
    attack()
}

interface Archer {
    shoot()
}

interface Healer {
    heal()
}

class HumanWarrior implements Warrior
class HumanArcher implements Archer
class HumanPriest implements Healer

class OrcWarrior implements Warrior
class OrcArcher implements Archer
class OrcShaman implements Healer

class Game {
    - factory : NPCFactory
    - warrior : Warrior
    - archer : Archer
    - healer : Healer
    + Game(factory: NPCFactory)
    + createNPCs()
    + play()
}

Game --> NPCFactory
Game --> Warrior
Game --> Archer
Game --> Healer

@enduml

Código-Fonte Explicado

NPCFactory – Interface da Fábrica Abstrata

Define os tipos de personagens que todas as facções devem fornecer.

HumanFactory & OrcFactory – Fábricas Concretas

Criam personagens consistentes entre si (mesma facção).

Warrior, Archer, Healer – Produtos Abstratos

Garantem que todas as facções implementem comportamento compatível.

HumanWarrior, OrcWarrior... – Produtos Concretos

Cada facção tem sua própria implementação de habilidades.

Game – Código Cliente

O jogo depende apenas da fábrica abstrata, nunca das classes concretas.

Exemplo de Execução:
Guerreiro Orc golpeia com seu machado pesado!
Arqueiro Orc dispara uma flecha brutal!
Xamã Orc convoca espíritos para curar!


Se mudar a facção para “Human”, automaticamente:
Guerreiro Humano ataca com espada!
Arqueiro Humano dispara uma flecha precisa!
Sacerdote Humano lança uma cura divina!

Sem mudar o código do jogo — apenas a fábrica usada.

Referências

Refactoring Guru – Abstract Factory
https://refactoring.guru/pt-br/design-patterns/abstract-factory

Este exemplo utilizou a LLM ChatGPT (GPT-5.1).