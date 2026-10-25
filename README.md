# Cadastro de Usuários — Android

Aplicativo Android desenvolvido em Java para praticar conceitos de programação e desenvolvimento mobile, utilizando `ArrayList` para armazenar e gerenciar usuários durante a execução do aplicativo.

O projeto permite cadastrar usuários, visualizar suas informações e realizar operações básicas de gerenciamento por meio de uma interface desenvolvida no Android Studio.

## Funcionalidades

- **Cadastro de usuários:** registro de nome, endereço, CPF e cargo.
- **Validação de campos:** impede o cadastro quando algum campo obrigatório está vazio.
- **Listagem de usuários:** exibe os usuários cadastrados em um `ListView`.
- **Visualização de informações:** permite selecionar um usuário para consultar seus dados.
- **Exclusão de usuários:** permite remover um cadastro mediante confirmação.
- **Pesquisa por nome:** localiza usuários já cadastrados utilizando o nome informado.
- **Contador de usuários:** exibe a quantidade de usuários cadastrados e atualiza o valor após operações de cadastro e exclusão.

## Tecnologias utilizadas

- **Java:** linguagem de programação utilizada na lógica do aplicativo.
- **Android Studio:** ambiente de desenvolvimento integrado (IDE).
- **XML:** criação e organização dos elementos da interface.
- **ArrayList:** armazenamento e gerenciamento dos objetos `Usuario`.
- **ArrayAdapter:** integração dos dados com o `ListView`.
- **ListView:** exibição dos usuários cadastrados.
- **Toast:** apresentação de mensagens ao usuário.
- **AlertDialog:** exibição de caixas de diálogo para confirmação de exclusão.

## Estrutura do projeto

Os principais componentes utilizados no desenvolvimento são:

| Componente | Responsabilidade |
|---|---|
| `MainActivity.java` | Controla os eventos da interface e as operações com os usuários. |
| `Usuario.java` | Representa um usuário e armazena seus dados. |
| `activity_main.xml` | Define a interface da tela principal. |
| `ArrayList<Usuario>` | Armazena os objetos de usuários cadastrados durante a execução. |

## Como executar o projeto

1. Clone o repositório:

   ```bash
   git clone https://github.com/Menezes-Gabs/PRM_ArrayList.git
   ```

2. Abra o Android Studio.

3. Selecione a opção para abrir um projeto existente e escolha a pasta `PRM_ArrayList`.

4. Aguarde a sincronização do projeto com o Gradle.

5. Execute o aplicativo em um emulador Android ou em um dispositivo físico configurado para depuração USB.

## Conceitos praticados

O desenvolvimento deste projeto permite praticar conceitos fundamentais de programação e desenvolvimento Android, como:

- Programação orientada a objetos (POO).
- Criação e utilização de classes e objetos.
- Manipulação de coleções com `ArrayList`.
- Recuperação de dados de campos de entrada.
- Tratamento de eventos de clique.
- Estruturas condicionais e de repetição.
- Validação de dados.
- Atualização de componentes da interface.
- Manipulação de listas e exclusão de elementos.

## Armazenamento dos dados

Os usuários são armazenados em um `ArrayList` durante a execução do aplicativo. Portanto, os dados mantidos nessa coleção não são persistidos automaticamente após o encerramento do aplicativo.

O projeto tem finalidade educacional e demonstra operações básicas de gerenciamento de dados em uma aplicação Android.

## Objetivo do projeto

Praticar o desenvolvimento de aplicações Android utilizando Java, com foco na manipulação de objetos, gerenciamento de listas e interação entre os componentes da interface gráfica.

---

**Desenvolvido por [Menezes-Gabs](https://github.com/Menezes-Gabs).**
