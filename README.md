# Operações Bancárias

## Descrição 

- Este projeto consiste em construir uma camada de serviço, para uma operação muito realizada em bancos, para emissão de extrato bancário.

- ## Requisitos do Projeto

- [x] A api fornecer os dados de transferência de acordo com o número da conta bacária.
- [x] Caso não seja informado nenhum filtro, retornar  todos os dados de transferência. 
- [x] Caso seja informado um período de tempo, retornar todas as transferências relacionadas à aquele período de tempo.
- [x] Caso seja informado o nome do operador da transação, retornar todas as transferências relacionados à aquele operador.
- [x] Caso todos os filtros sejam informados, retornar todas as transferências com base no período de tempo informado e o nome do operador.
- [x] Operador de transação nada mais é que, o nome do responsável de destino da transação caso seja uma operação de transferência de saida ou o nome do responsável de onde se originou a transação caso seja uma operação de transferência de entrada.
- [x] Os valores devem ser de ponto flutuante, e deve-se considerar apenas duas casas decimais.
- [x] As transações devem ser exibidas junto com o saldo total e o saldo total no período de acordo com o protótipo do documento.



## Arquitetura

### Clean Architecture
<img src="https://github.com/guilhermewt/assets/blob/main/clean%20archtecture/cleanarchtecture.png">

Uma abordagem para projetar sistemas de software de maneira altamente modular, independente de frameworks e testável. A ideia por trás da Clean Architecture 
é criar sistemas que sejam flexíveis, escaláveis e de fácil manutenção, ao mesmo tempo que possuem uma estrutura clara que separa as preocupações e mantém a
lógica de negócios centralizada e independente das camadas externas.

<img src="https://github.com/guilhermewt/assets/blob/main/clean%20archtecture/cleanarquitecture.png">

 No decorre do desenvolvimento do projeto foi tomada três decisões sobre a arquitetura cada uma delas coloca em um commit.
  
  1 - A primeira foi uma mais simplista, dividindo o projeto aenas por packages.
  
  2 - A segunda abordagem foi desenvolvida usando os conceitos da clean architecture e dividindo o projeto em modulos sendo eles o (core) para conter a lógica principaldo sistema e deixa-lo livre de dependências externas e principalmente de frameworks, (data Provider) para o que sistema se comunique com apis e banco de dados, e para
  o sistema exportar suas funcinalidades o modulo de entry point.
  
  3 - A terceira abordagem também foi desenvolvida com clean architecture mas contendo apenas um modulo sendo assim ao invés do core,data provider e entry point serem modulos,eles serão apenas packages. 

## API
    http://localhost:9090/accountNumber=1
Lista de filtros
- accountNumber: numero da conta.
- startDate: data de inicio do filtro (yyyy-mm-dd)
- endDate: data final de filtro (yyyy-mm-dd)
- operatorName: nome de quem enviou a transferencia ou recebeu

resposta
###
    {
      "periodBalance":33636.19,
      "transfers":[
          {
          "id":1,
          "transferDate":"2019-01-01T07:00:00-02:00",
          "value":30895.46,
          "operatorName":null,
          "type":"DEPOSITO"
          }
      ]
    }

## Como executar a aplicação 

- Você pode executar a aplicação da maneira que quiser e utilizando a IDE de sua preferência. 
- Caso queira executar a aplicação via linha de comando, execute primeiramente o comando:

                   ./mvnw clean package  para linux.

                   .\mvnw clean package  para windows.
- Após isso execute o comando: 

                             java -jar <...caminhoParaSeuJar>

## Requisitos de sistema

- Possuir a JDK 11 
- Uma IDE ou editor de sua preferência
