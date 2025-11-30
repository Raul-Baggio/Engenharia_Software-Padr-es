Padrões de Projeto – Abstract Factory, Decorator e Template Method

Este repositório reúne três exemplos de padrões de projeto amplamente utilizados no desenvolvimento de software: Abstract Factory, Decorator e Template Method.
Cada padrão está organizado em sua própria pasta, contendo:

Código-fonte completo

UML em PlantUML

README detalhado específico

O conteúdo conceitual foi baseado no catálogo de padrões de projeto do Refactoring Guru:
https://refactoring.guru/pt-br/design-patterns

A implementação e a documentação foram auxiliadas pela LLM ChatGPT (GPT-5.1).

Objetivo do Repositório

O objetivo deste projeto é demonstrar, na prática, como diferentes padrões de projeto podem ser aplicados em cenários simples, claros e independentes, permitindo:

Facilitar o estudo individual de cada padrão

Visualizar UML e código funcionando juntos

Comparar os padrões e entender quando aplicá-los

Servir como referência acadêmica ou profissional

Cada padrão implementa um problema e solução característicos, conforme descrito abaixo.

Padrões Implementados
1. Abstract Factory

Permite criar famílias de objetos relacionados sem acoplar o código a classes concretas.
No exemplo, diferentes fábricas produzem personagens, armas e montarias temáticas, mantendo compatibilidade entre os objetos criados.

2. Decorator

Permite adicionar responsabilidades dinamicamente a um objeto sem modificar sua classe original.
No exemplo, um personagem base recebe incrementos através de itens equipáveis como armaduras e armas.

3. Template Method

Define o esqueleto de um algoritmo e permite que subclasses personalizem passos específicos.
No exemplo, missões seguem uma estrutura fixa, mas cada personagem executa sua própria ação principal.

Estrutura do Repositório
/AbstractFactory
    CodigoEx.java
    Diagrama.puml
    README.md 

/Decorator
    CodigoEx.java
    Diagrama.puml
    README.md 

/TemplateMethod
    CodigoEx.java
    Diagrama.puml
    README.md 

README.md  (este arquivo)


Cada pasta contém uma implementação funcional, exemplos de execução e um README dedicado explicando o padrão em detalhes.

Como Executar os Exemplos

Abra a pasta do padrão desejado.

Compile os arquivos .java.

Execute o arquivo principal (CodigoEx.java).

Cada exemplo é independente e não possui dependências externas além do Java.

Referências

Refactoring Guru – Design Patterns
https://refactoring.guru/pt-br/design-patterns

Este repositório utilizou a LLM ChatGPT (GPT-5.1) como apoio na elaboração das implementações e documentações.