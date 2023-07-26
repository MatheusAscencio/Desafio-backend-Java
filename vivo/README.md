Instale a ferramenta docker-compose para ver o projeto.

Agora utilize o comando: --> sudo docker-compose up

Isto Criará instancias dos containers dos micro-serviços.

# Links para Acesso

    1° - localhost:8761 - Eureka-Server
    2° - localhost:8765 - Gateway
    3° - localhost:8080 - App
    4° - localhost:8080/h2-console - DB Console
    5° - localhost:15672 - Rabbit Mq


# Um Pedido
    
    Acesse o 5° link, do Rabbit Mq e crie uma queue(fila) com o nome de orders-issuance, este eco-sistema de micro-serviços trabalha com mensageria e infelizmente não descobri como criar uma queue(fila) automaticamente.

    user: user
    password: docker


# Modo de Testar
    Acesse o primeiro link(localhost:8761) e utilize as seguintes credenciais:

    user: eureka-server-vivo
    password: abc123
    
    E acesse o dashboard do eureka server para checar as instancias dos micro-serviços. Foi utilizado nivel de proteção básico para acesso dos micro-serviços ao eco-sistema do desafio, apenas com usuário e senha é possível acessar o ambiente e se alinhar a ele.

    Clique no microserviço ORDERS e na barra de busca do navegador, substitua os prefixo 49a63f28a625:8080/actuator/info por localhost:8080/actuator/info, para checar a funcionalidade do actuator.

    Agora acesse o dashboard do H2, banco de dados volátil utilizado no projeto, volátil significa que os dados só ficam salvos durante o uso do aplicativo, por se tratar de uma demonstração e de acordo com as requisições do desafio onde se pede a utilização de recursos disponibilizados para Spring Boot, o banco de dados H2 foi minha escolha, ele atende muito bem tanto a proposta do desafio quanto as necessidades.

    Para acessar o console do H2, acesse o 4° link, ou simplesmente substitua o caminho "/actuator/info" por "/h2-console" na url do seu browser no link do actuator.

    utilize o comando: --> sudo docker-compose logs app

    Isto é para acessar aos logs do container e adquirir a URL de acesso ao banco de dados, a cada nova instancia ou inicio do projeto, a URL muda.

    procure por um LOG parecido com:

    vivo-back  | 2023-07-26T22:44:52.256Z  INFO 7 --- [           main] o.s.b.a.h2.H2ConsoleAutoConfiguration    : H2 console available at '/h2-console'. Database available at 'jdbc:h2:mem:d661c83f-f1fd-4341-a5ce-475903b43faa'

    e copie oque está escrito entre as aspas simples 'jdbc:h2 ...'.

    Agora cole esta URL no campo JDBC URL no formulário de login do H2, não se preocupe com senha, esta não será necessária para demonstração, apenas clique em "Connect".

    Agora você tem acesso ao Dashboard do H2, e logo estará com os primeiros pedidos.

    Utilize Postman ou Insominia para envio de dados. Os modelos de dados utilizados foram os mesmos propostos pelo desafio no arquivo de README.md.

    Agora envie os valores propostos e veja o software acontecer.