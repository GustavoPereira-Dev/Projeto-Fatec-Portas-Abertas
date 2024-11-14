# Projeto Fatec Portas Abertas

Bem-vindo ao repositório do projeto Fatec Portas Abertas! Este projeto está sendo desenvolvido por uma equipe de 15 alunos com o objetivo de criar uma experiência de entretenimento e aprendizado durante o evento anual Fatec Portas Abertas. No evento, os visitantes terão acesso a um menu com jogos interativos, desenvolvidos e customizados especialmente para o público.

## Instruções para os integrantes

- Lembrando que tudo é feito na sua linha de comando favorita (cmd, powershell, bash, etc.) e você deve ter o Git instalado e configurado na sua máquina


### Processo para mandar sua alteração no repositório

Clonar o repositório:

<code>git clone https://github.com/GustavoPereira-Dev/Projeto-Fatec-Portas-Abertas</code>


Adicionar as alterações para commit:

<code>git add .</code>


Fazer o commit:

<code>git commit -m "Mensagem" </code> 

Dar push (passar as alterações do seu repositório do pc para o do Github):

<code>git push origin main</code> 

### Erro na hora de dar commit (Git não está reconhecendo o usuário que está fazendo a alteração)

<code> git config --global user.name "nomeusuariogithub" </code>

<code>git config --global user.email "emaildogithub@provedor"</code>

<i>Nota: se estiver em um computador público de algum local e queira que essas credenciais não fiquem salvas nele (mesmo que o da Fatec por padrão os remova ao reiniciar/desligar o pc), após dar o git push, entre em "Gerenciador de Credenciais", vá para "Credenciais do Windows", procure a credencial genérica do github e clique em remover</i>



### Erro na hora de dar push (repositório local colidindo com o do sistema)

<code>git pull origin main</code>

<i>Obs.: Cuidado na hora alterar arquivos que não fazem parte da sua tarefa, pois se não esse comando não funcionará (o arquivo x no repositório remoto é diferente do local)</i>

# Divisões de tarefas

### [Jogo da Forca](./src/forca/)

@NicolasDomingos09, @Joaoftito e @Lia Fernandes 

### [Jogo da Velha](./src/jogovelha/)

@DaianeTararam, @rafinhakenzo200 e @JM

### [Jogo de Xadrez](./src/xadrez/)

@GustavoPereira-Dev, @stormyy2, @GustavoCLacerd e @Carlos Augusto

### [Jogo da Memória](./src/jogomemoria/)
@Cauã Fernandes, @Stephani, @Paulo, @Rafael Silva

<i>Nota: eu mantive uma pasta chamada "[Projeto](./src/projeto/)" dentro da src com a arquitetura MVC (Model, View, Controller), que é como a estrutura do projeto vai parecer mais ou menos depois de tudo estiver organizado, contudo para evitar problemas de colisões de arquivos e especialmente dúvidas para quem não conhece ainda isso, deixei ela avulsa (mas quem saber melhor da estrutura pode converter a pasta de seu jogo para o modelo MVC depois ou perguntar a mim ou outros no que consiste essa estrutura de 3 camadas)</i>

Aliás, qualquer dúvida, estou aqui ou no grupo para sanar ela


