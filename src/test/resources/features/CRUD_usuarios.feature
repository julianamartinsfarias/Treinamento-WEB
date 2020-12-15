# language: pt
# charset: UTF-8
@wip
Funcionalidade: CRUD de usuários

  @CREATE
  Cenário: Criar um novo usuário
    Dado que o usuário está no sistema Agapito Server
    E o usuário escolhe o menu Usuários
    E o usuário clica no botão novo usuário
    E o usuário preenche o campo "login" com "Juliana Martins"
    E o usuário preenche o campo "nome completo" com "Juliana Martins"
    E o usuário preenche o campo "email" com "Juliana Martins"
    E o usuário preenche o campo "idade" com "29"
    Quando o usuário clicar em salvar
    Então o usuário deveria ver a mensagem "Usuário foi criado com sucesso."

  @READ
  Cenário: Consultar um novo usuário
    Dado que o usuário está no sistema Agapito Server
    E o usuário escolhe o menu Usuários
    E o usuário clica no botão novo usuário
    E o usuário preenche o campo "login" com "julianamartins"
    E o usuário preenche o campo "nome completo" com "Juliana Martins de Farias"
    E o usuário preenche o campo "email" com "juliana.martinsfarias@gmail.com"
    E o usuário preenche o campo "idade" com "29"
    E o usuário clicar em salvar
    E o usuário clicar em voltar
    Quando o usuário consultar o último usuário cadastrado
    Então o usuário deveria ver "login" com "julianamartins"
    E o usuário deveria ver "nome completo" com "Juliana Martins de Farias"
    E o usuário deveria ver "email" com "juliana.martinsfarias@gmail.com"
    E o usuário deveria ver "idade" com "29"


  @UPDATE
  Cenário: Alterar um usuário
    Dado que o usuário está no sistema Agapito Server
    E o usuário escolhe o menu Usuários
    E o usuário clica no botão novo usuário
    E o usuário preenche o campo "login" com "julianamartins"
    E o usuário preenche o campo "nome completo" com "Juliana Martins de Farias"
    E o usuário preenche o campo "email" com "juliana.martinsfarias@gmail.com"
    E o usuário preenche o campo "idade" com "29"
    E o usuário clicar em salvar
    E o usuário clicar em voltar
    Quando o usuário editar o último usuário cadastrado
    E o usuário preenche o campo "nome completo" com "Minha mãe é linda" na Edição
    E o usuário clicar em salvar na Edição
    E o usuário clicar em voltar
    E o usuário consultar o último usuário cadastrado
    Então o usuário deveria ver "login" com "julianamartins"
    E o usuário deveria ver "nome completo" com "Minha mãe é linda"
    E o usuário deveria ver "email" com "juliana.martinsfarias@gmail.com"
    E o usuário deveria ver "idade" com "29"

  @DELETE
  Cenário: Deletar um usuário
    Dado que o usuário está no sistema Agapito Server
    E o usuário escolhe o menu Usuários
    E o usuário clica no botão novo usuário
    E o usuário preenche o campo "login" com "julianamartins"
    E o usuário preenche o campo "nome completo" com "Juliana Martins de Farias"
    E o usuário preenche o campo "email" com "juliana.martinsfarias@gmail.com"
    E o usuário preenche o campo "idade" com "29"
    E o usuário clicar em salvar
    E o usuário clicar em voltar
    Quando o usuário deleta o último usuário cadastrado
    E o usuário confirma a deleção
    Então o usuário não deveria ver o registro deletado

  @esquema
  Esquema do Cenario: Exemplo de scenario outline - <id>

    Dado que o usuário está no sistema Agapito Server
    E o usuário escolhe o menu Usuários
    E que o usuário acabou de cadastrar o código "<id>"
    E o usuário consultar o último usuário cadastrado
    Então o usuário deveria ver "login" com "<Login>"

    Exemplos:
      | id   | Login        |
      | 3740 | cafe2        |
      | 3741 | cafe2        |
      | 3742 | thiagokeller |

  @sintético
  Cenário: Criar um novo usuário sintético
    Dado que o usuário está no sistema Agapito Server
    E o usuário escolhe o menu Usuários
    Quando o usuário criar um novo registro
    Então o usuário deveria ver a mensagem "Usuário foi criado com sucesso."


