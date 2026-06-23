# projeto_inter_III
Trabalho final da matéria Projeto Interdisciplinar III

O projeto foi desenvolvido como trabalho final da disciplina Projeto Interdisciplinar III e consiste na implementação de um sistema CRUD (Create, Read, Update e Delete) para cadastro de veículos, com interface gráfica e integração com banco de dados PostgreSQL.

O sistema permite o cadastro, atualização, exclusão e consulta de veículos, oferecendo diferentes formas de busca, como por placa, por proprietário (único dono) e a listagem completa de todos os registros cadastrados.

A aplicação foi estruturada em diferentes pacotes com o objetivo de organizar o código e separar responsabilidades. O pacote view é responsável pela interface gráfica do sistema, implementada com Java Swing. O pacote model contém as classes de domínio, como a classe Veiculo, que define os atributos e métodos de acesso (getters e setters). O pacote main contém a classe principal responsável pela inicialização da aplicação.

O pacote dao é responsável por todas as operações de persistência de dados, incluindo comandos SQL para inserção, atualização, remoção e consultas no banco de dados. Dentro deste pacote também há a classe responsável pela geração de arquivos texto, que registra os dados dos veículos em um arquivo .txt após cada cadastro realizado.

O pacote database contém a configuração da conexão com o banco de dados PostgreSQL, incluindo URL de acesso, usuário e senha. Já o pacote lib armazena o driver JDBC necessário para a comunicação entre a aplicação Java e o banco de dados.

No banco de dados foram implementadas estruturas auxiliares para facilitar consultas e organização das informações. Foram criadas views para a visualização de veículos cadastrados e para consultas específicas de veículos de único dono. Além disso, também foi implementada uma função responsável por retornar a quantidade total de veículos registrados no sistema.

O sistema foi desenvolvido com o objetivo de aplicar na prática conceitos de programação orientada a objetos, manipulação de banco de dados relacional e construção de interfaces gráficas em Java.