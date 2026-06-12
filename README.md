# 📚 Biblioteca Digital - Sistema de Gerenciamento de Acervo e Empréstimos

## 📌 Descrição
Este projeto foi desenvolvido como parte da disciplina de **Estrutura de Dados**, com o objetivo de simular o funcionamento de uma biblioteca digital.

O sistema gerencia livros, usuários e empréstimos utilizando **listas duplamente encadeadas, filas genéricas e tabelas hash**, permitindo organizar o acervo, gerenciar filas de espera e localizar livros rapidamente por ISBN.

---

## 🎯 Objetivo
- Implementar estruturas de dados na prática
- Simular um sistema real de biblioteca digital
- Trabalhar com conceitos como listas duplamente encadeadas, filas FIFO e tabelas hash
- Aplicar lógica de controle com menus interativos
- Utilizar generics (Tipos Genéricos) para reutilização de código

---

## ⚙️ Funcionamento do Sistema
O sistema permite ao usuário:

1. **Cadastrar livro**
   - Informando ISBN, título, autor e ano de publicação
   - O livro é inserido no acervo e no catálogo indexado

2. **Buscar livro por ISBN**
   - Localização instantânea usando tabela hash

3. **Listar acervo do início ao fim**
   - Navegação normal pela lista duplamente encadeada

4. **Listar acervo do fim ao início**
   - Navegação reversa pelos ponteiros anteriores

5. **Solicitar empréstimo**
   - Usuário + ISBN do livro
   - Se disponível: empréstimo concedido
   - Se indisponível: entra na fila de espera

6. **Devolver livro**
   - Livro é marcado como disponível
   - Se houver fila de espera: próximo usuário é atendido automaticamente

7. **Ver fila de espera de um livro**
   - Exibe todos os usuários aguardando por um determinado livro

8. **Sair**

---

## 🧱 Estruturas de Dados Utilizadas

### 🔹 Lista Duplamente Encadeada (ListaDupla)
Utilizada para armazenar o acervo de livros.
- Permite navegação nos dois sentidos
- Inserção e remoção no início e no fim
- Busca sequencial por ISBN

### 🔹 Fila Genérica (Fila<T>)
Utilizada para gerenciar filas de espera por empréstimo.
- Funcionamento FIFO (First In, First Out)
- Implementada com encadeamento simples (No<T>)

### 🔹 Tabela Hash (NossoHash<K,V>)
Utilizada para indexar o catálogo de livros por ISBN.
- Busca instantânea O(1) em média
- Tratamento de colisões por encadeamento externo
- Capacidade inicial: 16 posições

### 🔹 Nó Duplo (NoDuplo) e Nó Genérico (No<T>)
Estruturas auxiliares para encadeamento dos dados.

---

## 🗂️ Estrutura do Projeto
```
/codigo
├── BibliotecaDigital.java
├── Livro.java
├── Usuario.java
├── NoDuplo.java
├── ListaDupla.java
├── No.java
├── Fila.java
├── FilaVaziaException.java
├── GestorEmprestimos.java
├── Entrada.java
├── NossoHash.java
├── Catalogo.java
└── TesteListaDupla.java / TesteFila.java / TesteGestorEmprestimos.java

```

---

## 💻 Tecnologias Utilizadas
- Linguagem: **Java**
- Paradigma: **Orientação a Objetos**
- Estruturas: **Listas Encadeadas, Filas, Tabelas Hash**
- Execução: **Terminal (console)**

---

## ▶️ Como Executar

1. Compile os arquivos:
```bash
javac *.java

```
---

## 🧠 Conceitos Aplicados
- Estrutura de dados: Lista Duplamente Encadeada
- Estrutura de dados: Fila (FIFO)
- Estrutura de dados: Tabela Hash com encadeamento externo
- Generics (Tipos Genéricos) em Java
- Encapsulamento e organização de classes
- Tratamento de exceções (FilaVaziaException)
- Entrada de dados com Scanner
- Sobrescrita de métodos (toString, equals, hashCode)

---

## 👨‍🎓 Autores
- Abraão Castro de Araújo | `RA:` 1430482423054
- Eduardo Alves Dos Santos | `RA:` 1430482511004
- Kaique Miranda Santos | `RA:` 1430482513035
- Angelo Ribeiro Rodrigues dos Santos | `RA:` 1430642327026
- Matheus Sebrian de Souza| `RA: ` 1430482511008

---

## 🏫 Disciplina
- Estrutura de Dados

---



