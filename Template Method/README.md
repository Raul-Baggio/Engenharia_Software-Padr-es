Template Method – Exemplo com Missões de Personagem

Este repositório demonstra o padrão de projeto Template Method, utilizando um cenário de jogo onde diferentes tipos de personagens (Guerreiro, Mago e Ladrão) executam missões seguindo uma sequência fixa de passos, mas cada um com sua própria ação principal.

O conteúdo conceitual foi baseado no catálogo de padrões de projeto do Refactoring Guru:
https://refactoring.guru/pt-br/design-patterns/template-method

A implementação deste exemplo foi auxiliada pela LLM ChatGPT (GPT-5.1).

Objetivo do Padrão

O Template Method define o esqueleto de um algoritmo em um método da classe base, permitindo que subclasses redefinam partes específicas do processo sem modificar a estrutura geral.

No contexto deste projeto:

Toda missão segue etapas comuns como preparar, viajar, retornar e receber recompensa.

A única etapa variável é a ação principal, que muda conforme o tipo de personagem.

Assim, garantimos consistência no fluxo, permitindo personalizações apenas onde necessário.

Problema

Em um jogo, vários personagens podem realizar missões semelhantes, mas:

O Guerreiro luta diretamente.

O Mago usa feitiços.

O Ladrão age furtivamente.

Se cada tipo de missão precisasse reimplementar todo o fluxo, teríamos:

Código duplicado

Possíveis inconsistências

Manutenção mais difícil

O Template Method evita isso ao definir o fluxo completo na classe abstrata e deixar os detalhes variáveis para as subclasses.

Solução com Template Method

O padrão organiza o comportamento em três partes:

1. Classe Abstrata (Template)

Define o método final que executa toda a missão, e também os passos comuns:

preparar()

viajar()

retornar()

recompensar()

acaoPrincipal() (abstrato)

Exemplo:
Missao

2. Subclasses Concretas

Cada classe implementa apenas a parte variável:

MissaoGuerreiro

MissaoMago

MissaoLadrao

Somente o método acaoPrincipal() é sobrescrito.

UML (PlantUML)
@startuml TemplateMethod

abstract class Missao {
    +executarMissao()
    +preparar()
    +viajar()
    +acaoPrincipal()
    +retornar()
    +recompensar()
}

class MissaoGuerreiro {
    +acaoPrincipal()
}

class MissaoMago {
    +acaoPrincipal()
}

class MissaoLadrao {
    +acaoPrincipal()
}

Missao <|-- MissaoGuerreiro
Missao <|-- MissaoMago
Missao <|-- MissaoLadrao

@enduml

Código-Fonte Explicado
Missao

Classe abstrata que define toda a estrutura da missão.
O método executarMissao() é final para garantir que a sequência não seja alterada.

MissaoGuerreiro, MissaoMago, MissaoLadrao

Subclasses que implementam apenas a ação específica da missão.

Isso permite reutilizar toda a lógica comum sem duplicação.

Exemplo de Execução
=== Missão do Guerreiro ===
Preparando equipamentos e suprimentos...
Viajando até o local da missão...
O Guerreiro luta bravamente contra monstros!
Retornando ao acampamento...
Recebendo a recompensa da missão!

=== Missão do Mago ===
Preparando equipamentos e suprimentos...
Viajando até o local da missão...
O Mago conjura feitiços devastadores!
Retornando ao acampamento...
Recebendo a recompensa da missão!

=== Missão do Ladrão ===
Preparando equipamentos e suprimentos...
Viajando até o local da missão...
O Ladrão realiza ações furtivas sem ser detectado!
Retornando ao acampamento...
Recebendo a recompensa da missão!


O código cliente apenas chama executarMissao() sem precisar conhecer os detalhes específicos de cada missão.

Referências

Refactoring Guru – Template Method
https://refactoring.guru/pt-br/design-patterns/template-method

Este exemplo utilizou a LLM ChatGPT (GPT-5.1).