# cwi-reset-03
Repositório para exercícios do Reset

# Desafio resetflix - Parte 2

## Acabou a moleza :fire:

Com a nossa API configurada, vamos começar a mapear nossos serviços, a final já temos regras de negócio implementadas não é mesmo? :heart_eyes:

Vamos as definições de contratos então para nossas funcionalidades já implementadas:

### 1. Elenco

#### 1.2. Listar atores em atividade

- Assinatura
    - `GET /atores/em_atividade`
- Contrato
    - Classe: AtorController | Retorno: List< AtorEmAtividade > | Método: listarAtoresEmAtividade(String filtroNome)
- Parâmetros de entrada:
    - filtroNome (query parameter)
- Saída esperada em caso de sucesso:
    - Status: `200 OK`
    - Body:
        - List< AtorEmAtividade >
            - id
            - nome
            - dataNascimento
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - Mesmas regras definidas na etapa 1

### 2. Direção

#### 2.2. Listar diretores

- Assinatura
    - `GET /diretores`
- Contrato
    - Classe: DiretorController | Retorno: List< Diretor > | listarDiretores(String filtroNome)
- Parâmetros de entrada:
    - filtroNome (query parameter)
- Saída esperada em caso de sucesso:
    - Status: `200 OK`
    - Body:
        - List< Diretor >
            - id
            - nome
            - dataNascimento
            - anoInicioAtividade
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - Mesmas regras definidas na etapa 1

## Acho que ainda está fácil, bora colocar mais lenha nesta fogueira :fire::fire::fire:

### 3. Estúdio

#### 3.2. Listar Estúdio

- Assinatura
    - `GET /estudios`
- Contrato
    - Classe: EstudioController | Retorno: List< Estudio > | Método: consultarEstudios(String filtroNome)
- Parâmetros de entrada:
    - filtroNome (query parameter)
- Saída esperada em caso de sucesso:
    - Status: `200 OK`
    - Body:
        - List< Estudio >
            - id
            - nome
            - descricao
            - dataCriacao
            - StatusAtividade statusAtividade
                - EM_ATIVIDADE
                - ENCERRADO
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - O campo filtroNome é opcional, quando informado deve filtrar por qualquer match na sequência do nome, 
        Exemplo: filtroNome -> vel
                estúdio encontrado -> Marvel Studios
    - Caso não exista nenhum estúdio cadastrado deve retornar erro
        - Mensagem de erro: "Nenhum estúdio cadastrado, favor cadastar estúdios."
    - Caso não seja encontrado nenhum estúdio com o filtro informado deve retornar erro
        - Mensagem de erro: "Estúdio não encontrato com o filtro {filtro}, favor informar outro filtro."

### 4. Filmes

#### 4.1. Cadastrar Filmes

- Assinatura
    - `POST /filmes`
- Contrato
    - Classe: FilmeController | Retorno: void | Método: criarFilme(FilmeRequest filmeRequest)
- Parâmetros de entrada:
    - FilmeRequest
        - nome*
        - anoLancamento*
        - capaFilme*
        - List< Genero > generos
            - ACAO
            - AVENTURA
            - COMEDIA
            - DOCUMENTARIO
            - DRAMA
            - ESPIONAGEM
            - FICCAO_CIENTIFICA
            - GUERRA
            - MISTERIO
            - MUSICAL
            - POLICIAL
            - ROMANCE
            - TERROR
        - idDiretor*
        - idEstudio*
        - resumo*
        - List< PersonagemRequest > personagens*
            - idAtor*
            - nomePersonagem*
            - descricaoPersonagem*
            - TipoAtuacao tipoAtuacao
                - PRINCIPAL
                - COADJUVANTE
- Saída esperada em caso de sucesso:
    - Status: `201 CREATED`
    - Body: `N/A`
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - Campos com * são campos obrigatórios
        - Mensagem de erro: "Campo obrigatório não informado. Favor informar o campo {campo}."
    - Caso não exista nenhum estúdio cadastrado para o id informado deve retornar erro
        - Mensagem de erro: "Nenhum estúdio encontrado com o parâmetro id={}, favor verifique os parâmetros informados."
    - Caso não exista nenhum diretor cadastrado para o id informado deve retornar erro
        - Mensagem de erro: "Nenhum diretor encontrado com o parâmetro id={}, favor verifique os parâmetros informados."
    - Caso não exista nenhum ator cadastrado para o id informado deve retornar erro
        - Mensagem de erro: "Nenhum ator encontrado com o parâmetro id={campo}, favor verifique os parâmetros informados."
    - Não é permitido cadastrar filmes que apresentem duas vezes o mesmo gênero na lista informada na requisição, caso encontrado gêneros duplicados deve retornar mensagem de erro, exemplo:
        - List< Generos > generos : ["ACAO", "TERROR", "COMEDIA", "ACAO"] | não permitido
        - List< Generos > generos : ["ACAO", "TERROR", "COMEDIA", "ESPIONAGEM"] | permitido
        - Mensagem de erro: "Não é permitido informar o mesmo gênero mais de uma vez para o mesmo filme."
    - Não é permitido cadastrar o mesmo personagem com o mesmo ator mais de uma vez, caso seja informado o mesmo ator para o mesmo personagem deve retornar erro, exemplo:
        - List< PersonagemRequest > personagens : [{"idAtor": 1, "nomePersonagem": "meu personagem"}, {"idAtor": 2, "nomePersonagem": "outro personagem"}, {"idAtor": 1, "nomePersonagem": "meu personagem"}] | não permitido
        - List< PersonagemRequest > personagens : [{"idAtor": 1, "nomePersonagem": "meu personagem"}, {"idAtor": 2, "nomePersonagem": "outro personagem"}, {"idAtor": 3, "nomePersonagem": "meu personagem"}] | permitido
        - Mensagem de erro: "Não é permitido informar o mesmo ator/personagem mais de uma vez para o mesmo filme."
    - Os ids do filme e do personagem devem ser gerados automáticamente de forma sequencial

#### 4.2. Consultar Filmes

- Assinatura
    - `GET /filmes`
- Contrato
    - Classe: FilmeController | Retorno: List< Filme > | Método: consultarFilmes(String nomeFilme, String nomeDiretor, String nomePersonagem, String nomeAtor)
- Parâmetros de entrada:
    - nomeFilme (query parameter)
    - nomeDiretor (query parameter)
    - nomePersonagem (query parameter)
    - nomeAtor (query parameter)
- Saída esperada em caso de sucesso:
    - Status: `200 OK`
    - Body:
        - List< Filme >
            - id
            - nome
            - anoLancamento
            - capaFilme
            - List< Genero > generos
                - ACAO
                - AVENTURA
                - COMEDIA
                - DOCUMENTARIO
                - DRAMA
                - ESPIONAGEM
                - FICCAO_CIENTIFICA
                - GUERRA
                - MISTERIO
                - MUSICAL
                - POLICIAL
                - ROMANCE
                - TERROR
            - Diretor diretor
            - Estudio estudio
            - List< PersonagemAtor > personagens
            - resumo
- Saída esperada em caso de erro:
    - Status: `400 BAD REQUEST`
    - Body: Conforme padrão de erro apresentado no exemplo
- Regras:
    - Todos os parâmetros de filtro são opcionais, e devem retornar qualquer match na sequência dos seus referentes campos
        - nomeFilme -> Classe Filme | Campo nome
        - nomeDiretor -> Classe Diretor | Campo nome
        - nomePersonagem -> Classe PersonagemAtor | Campo nomePersonagem
        - nomeAtor -> Classe Ator | Campo nome
    - Caso não encontrado nenhum filme para os filtros informados deve retornar erro
        - Mensagem de erro: "Ator não encontrato com os filtros nomeFilme={nomeFilme}, nomeDiretor={nomeDiretor}, nomePersonagem={nomePersonagem}, nomeAtor={nomeAtor}, favor informar outros filtros."
    - Caso não exista nenhum filme cadastrado, deve retornar erro
        - Mensagem de erro: "Nenhum filme cadastrado, favor cadastar filmes."
