# THE HOME API - Controle de Orçamentos

# Comandos básicos para executar o projeto
- Compilação: mvn clean install
- Subir aplicação: ./mvnw compile quarkus:dev
- Dev UI:  http://localhost:8080/q/dev-ui/extensions
- Swagger: http://localhost:8080/q/swagger-ui/

# Tecnologias necessárias para execução do projeto

- Java - Versão 11. Disponível em: https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html
- Maven - Versão 3.9.4. Disponível em: https://dlcdn.apache.org/maven/maven-3/3.9.4/source/apache-maven-3.9.4-src.zip
- Se necessário, A SDK do java e o Maven usados para execução da aplicação estão disponíveis no link: https://drive.google.com/drive/folders/1YlBRBejkEQ1FW5CJEUrov1tkdmFIC4_p?usp=sharing

# Passos para executar o projeto utilizando linhas de comandos (Ambiente Windows)

- O primeiro passso aqui é ter o Java e o Maven configurados nas variavéis de ambiente do windows.
- Acesse as configurações de variáveis de ambiente
- ![img_9.png](src/main/resources/readme/img_9.png)
- ![img_10.png](src/main/resources/readme/img_10.png)
- Na parte de variáveis do sistema, clique em Novo e configure os diretórios onde estão o JAVA e o MAVEN da seguinte forma:
- ![img_11.png](src/main/resources/readme/img_11.png)
- Faça uma edição no Path para configurar o bin:
- ![img_12.png](src/main/resources/readme/img_12.png)
- ![img_13.png](src/main/resources/readme/img_13.png)
- Clique em OK em todas as telas para encerrar a configuração
- Para testar a configuração do Java abra o cmd e digite: **java -version**
- ![img_14.png](src/main/resources/readme/img_14.png)
- Para testar a configuração do Maven abra o cmd e digite: **mvn**
- ![img_15.png](src/main/resources/readme/img_15.png)
- Agora vamos executar alguns comandos para iniciar a aplicação
- Abra o diretório raiz do projeto clonado e abra como um terminal do GitBash por exemplo. Link downnload GitBash: https://git-scm.com/downloads
- ![img.png](src/main/resources/readme/img-01.png)
- ![img_3.png](src/main/resources/readme/img_3-3.png)
- Execute o comando **mvn clean install** para gerar o build completo da aplicação, inclusive com os testes.
- ![img_2.png](src/main/resources/readme/img_2-2.png)
- Devemos ter o seguinte resultado:
- ![img_4.png](src/main/resources/readme/img_4-4.png)
- Para finalmente iniciar a aplicação. Execute o seguinte comando: **./mvnw compile quarkus:dev**
- Temos como resultado:
- ![img_5.png](src/main/resources/readme/img_5-5.png)
- Utilize o seguinte link acessar o Dashboard do Quarkus: http://localhost:8080
- Link do Swagger http://localhost:8080/q/swagger-ui/
- ![img.png](src/main/resources/readme/img-10.png)

# Passos para executar o projeto utilizando IntelliJ IDEA no idioma inglês

- Clonar o projeto **[worst-movie-api](https://github.com/wesleyeduardodev/worst-movie-api.git)** em algum diretório na máquina. (Para essa aplicação foi usado Windows como ambiente de desenvolvimento)
- Baixar e instalar versão gratuita IntelliJ IDEA Ultimate por 30 dias. https://www.jetbrains.com/idea/download/?section=windows
- Ao iniciar a IDE, selecionar a Opção File -> Open
- ![img.png](src/main/resources/readme/img.png)
- Procure e selecione o diretório onde o projeto foi clonado:
- ![img_1.png](src/main/resources/readme/img_1.png)
- Para configurar o Java selecione a opção File -> Project Structure
- ![img_2.png](src/main/resources/readme/img_2.png)
- Na aba project, opção SDK procure e selecione a SDK do Java 11 presente no diretório da sua máquina
- ![img_3.png](src/main/resources/readme/img_3.png)
- Para configurar o maven, selecione a opção File -> Settings
- ![img_4.png](src/main/resources/readme/img_4.png)
- Pesquisar por maven e configure conforme imagem
- ![img_6.png](src/main/resources/readme/img_6.png)
- Na aba do maven na parte superior da lateral direita, execute o clean e install para baixar as dependências do projeto.
- ![img_7.png](src/main/resources/readme/img_7.png)
- Após finalizar com sucesso essa ação. na parte superior da lateral direita, clique no botão para executar o projeto:
- ![img_8.png](src/main/resources/readme/img_8.png)
- Utilize o seguinte link acessar o Dashboard do Quarkus: http://localhost:8080 
- Link do Swagger http://localhost:8080/q/swagger-ui/
- ![img_1.png](src/main/resources/readme/img_1-11.png) 

# Passos para executar os testes de integração

- Para testar usando o Dashboard do Quarkus, inicialize a aplicação conforme já detalhado.
- Acessando o link: http://localhost:8080
- ![img_5.png](src/main/resources/readme/img_5-20.png)
- Clique em "VISIT THE DEV UI"
- Selecione a aba "Continuos Testing" e clique em Start
- ![img_7.png](src/main/resources/readme/img_7-22.png)
- O resultado dos testes é apresentado conforme imagem
- ![img.png](src/main/resources/readme/img-2090.png)
- Os testes presentes na classe AwardsRangeResourceTest testam se as rotas do AwardsRangeResourceAPI retornam requisição realizada com sucesso (status 200) ao acessar seus endpoints. Além disso também realizam testes comparando se os resultados das faixas de prêmios presentes no arquivo CSV importado ao iniciar a aplicaçao são iguais ao mocks que foram criados na classe para realizar essa comparação. Reforço que **alterações** no arquivo CSV tem grandes chances de provocar falhas nos testes dessa classe. Sabendo disso em seguinte irei explicar os testes na classes de AwardsRangeServiceTest, que possibilitam uma flexibilidade maior de testes.
- Os testes presentes na classe AwardsRangeServiceTest fazem um mock de um rank de faixa de prêmios e compara o resultado5 com outro mock. Dessa forma podemos montar qualquer cenário de teste.
- Para executar o teste via IntelliJ IDEA, entre na classes de teste e clique no botão conforme imagem de exemplo:
![img_3.png](src/main/resources/readme/img_3-2093.png)
- Para executar os testes via comando, abra o terminal do gitBash nas raiz do projeto execute o comando: **mvn clean install -DskipUnitTests**
- O resultado pode ser verificado conforma imagem
![img_2.png](src/main/resources/readme/img_2-2092.png)
- Os testes presentes no pacote security verificam se determinados endpoints estão acessíveis ou não dependendo da configuração de autenticação repassada no teste da requisição.
