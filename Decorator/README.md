Decorator – Exemplo com Equipamentos de Personagem

Este repositório demonstra o padrão de projeto Decorator, utilizando um cenário de jogo onde um personagem base (um guerreiro) pode receber melhorias através de itens adicionais, como armaduras, armas e escudos.

O conteúdo conceitual foi baseado no catálogo de padrões de projeto do Refactoring Guru:
https://refactoring.guru/pt-br/design-patterns/decorator

A implementação deste exemplo foi auxiliada pela LLM ChatGPT (GPT-5.1).

Objetivo do Padrão

O Decorator permite adicionar comportamentos e funcionalidades a um objeto de forma dinâmica, sem alterar sua classe principal. Assim, é possível compor objetos com múltiplas “camadas” de funcionalidades, mantendo o sistema flexível e aberto à extensão.

No contexto deste projeto:

O personagem base é um Guerreiro.

Ele pode receber incrementos de poder e descrição ao equipar itens adicionais.

Os itens são “decoradores”, que modificam o personagem original sem precisar criar subclasses para todas as combinações possíveis.

Problema

Em muitos jogos, personagens podem receber diferentes equipamentos:

Armaduras

Armas

Escudos

Acessórios diversos

Se cada combinação de itens fosse representada por uma nova classe, rapidamente surgiria um problema de explosão combinatória:

GuerreiroComEspada

GuerreiroComEscudo

GuerreiroComEspadaEArmadura

GuerreiroComArmaduraEEscudo

...

Isso resulta em:

Muitas classes desnecessárias

Código rígido

Dificuldade de manutenção

O Decorator resolve esse problema ao permitir montar combinações dinamicamente.

Solução com Decorator

O padrão organiza o sistema em três partes:

1. Componente Base

É a interface que define os métodos que podem ser decorados.
No exemplo:

Personagem

2. Componente Concreto

É o objeto principal que poderá ser decorado.

Guerreiro

3. Decorator Abstrato

Classe que mantém uma referência a um Personagem e repassa suas chamadas.

PersonagemDecorator

4. Decorators Concretos

Itens equipáveis que acrescentam comportamento ao personagem:

ArmaduraPesada

EspadaLonga

EscudoDeAco

Cada um adiciona descrição e poder extras.

UML (PlantUML)
@startuml Decorator

interface Personagem {
    +getDescricao(): String
    +getPoder(): int
}

class Guerreiro {
    +getDescricao(): String
    +getPoder(): int
}

abstract class PersonagemDecorator {
    -personagem: Personagem
    +getDescricao(): String
    +getPoder(): int
}

class ArmaduraPesada {
    +getDescricao(): String
    +getPoder(): int
}

class EspadaLonga {
    +getDescricao(): String
    +getPoder(): int
}

class EscudoDeAco {
    +getDescricao(): String
    +getPoder(): int
}

Personagem <|.. Guerreiro
Personagem <|.. PersonagemDecorator
PersonagemDecorator <|-- ArmaduraPesada
PersonagemDecorator <|-- EspadaLonga
PersonagemDecorator <|-- EscudoDeAco
PersonagemDecorator --> Personagem

@enduml

Código-Fonte Explicado
Personagem

Interface base que define a estrutura de qualquer personagem decorável.

Guerreiro

Implementação concreta e simples do personagem.

PersonagemDecorator

Classe abstrata que armazena um Personagem e repassa seus métodos.
Serve como base para todos os itens possíveis.

ArmaduraPesada, EspadaLonga, EscudoDeAco

Cada um modifica a descrição e incrementa o poder final do personagem.
Eles podem ser encadeados livremente.

Exemplo de Execução

Personagem inicial:

Guerreiro básico | Poder: 10


Após equipar todos os itens:

Guerreiro básico + Armadura Pesada + Espada Longa + Escudo de Aço | Poder: 38


O código cliente nunca precisa conhecer as classes concretas individuais.
Basta aplicar decoradores sobre o personagem conforme necessário.

Referências

Refactoring Guru – Decorator
https://refactoring.guru/pt-br/design-patterns/decorator

Este exemplo utilizou a LLM ChatGPT (GPT-5.1).