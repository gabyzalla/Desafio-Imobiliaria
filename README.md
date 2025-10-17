# Projeto Imobiliaria Console

Este é um projeto simples em Java para console, desenvolvido como um exercício para aplicar conceitos de Programação Orientada a Objetos (POO). Ele simula o cadastro e aluguel de imóveis (Casas, Apartamentos e Comércios), focando nos pilares de Herança, Polimorfismo e Encapsulamento.

## Objetivo

Demonstrar a aplicação dos conceitos fundamentais da POO em um sistema de console funcional para gerenciamento básico de imóveis.

## Funcionalidades Atuais (Versão Simplificada)

* Cadastro de Imóveis (Casa, Apartamento, Comercio) com informações essenciais (endereço, proprietário, aluguel base, taxa de manutenção, permite pets).
* Aluguel e Disponibilização de Imóveis (marcando como alugado/disponível).
* Cálculo Simples do Aluguel (Aluguel Base + Taxa de Manutenção * Meses).
* Listagem de todos os imóveis cadastrados.
* Listagem apenas dos imóveis alugados.
* Deleção de imóveis disponíveis.
* Interação via menu de console.

## Estrutura do Projeto

O projeto utiliza uma estrutura simplificada com todos os arquivos `.java` na mesma pasta (pacote padrão):

* `Imovel.java` (Classe abstrata base)
* `Casa.java`, `Apartamento.java`, `Comercio.java` (Subclasses)
* `Proprietario.java`, `Inquilino.java` (Composição)
* `GerenciadorImoveis.java` (Lógica de negócio e lista em memória)
* `MenuImobiliaria.java` (Interface do console)
* `CalculaAluguel.java` (Classe para cálculo)
* `Main.java` (Ponto de entrada)

## Pontos de Melhoria Futuros
Ideias para futuras implementações incluem:

* Aplicar Princípios SOLID: Refatorar o código para seguir SOLID. Organizar o código em pacotes.
* Identificação Única (ID): Substituir a identificação por endereço/número por um ID numérico único para cada imóvel.
* Cálculos Mais Completos: Introduzir taxas como condomínio e caução no cálculo do aluguel.
* Previsão de Disponibilidade:** Adicionar a funcionalidade de calcular e exibir a data em que um imóvel alugado ficará disponível.
