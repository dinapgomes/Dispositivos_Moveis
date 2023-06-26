# Projeto de App com Flutter

## Descrição

Implementar um app (livre escolha) com base nas seguintes regras:

- Seu desenvolvimento se dará com Flutter ou Android Nativo
- A aplicação deve possuir no mínimo três telas
- A aplicação deve, necessariamente, consumir dados de uma API
  - Essa API pode ser externa (feita por terceiros) ou implementada pelo grupo
- A aplicação deve, necessariamente, persistir seus dados localmente
  - Sugestão: realizar operações CRUD e sincronização de dados entre o serviço e o dispositivo móvel

## Escolha do app

Nós escolhemos implementar um jogo de adivinhação, onde o usuário tem que adivinhar um número entre 1 e 100. O app vai dar dicas se o número é maior ou menor que o palpite do usuário, e contar quantas tentativas foram necessárias para acertar.

## Telas do app

O app possui três telas:

- Tela inicial: onde o usuário pode iniciar um novo jogo ou ver o histórico de jogos anteriores
- Tela de jogo: onde o usuário digita seu palpite e recebe feedback do app
- Tela de resultado: onde o usuário vê se acertou ou errou o número, e quantas tentativas foram usadas