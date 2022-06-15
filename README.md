# Projeto de Desenvolvimento de Aplicações Corporativas (2022/1)

## Deploy

O deploy da aplicação foi realizado na plataforma Heroku e pode ser acessado **[neste endereço](https://devappcorp.herokuapp.com/)**.

## API

Os endpoints da API podem ser acessados a partir do endereço https://devappcorp.herokuapp.com/api/.

### User (/api/user)

Esse endpoints podem ser usados para listar, criar, editar e excluir os usuários do sistema. Essa entidade possui os seguintes atributos:

| Atributos | Tipo | Modificadores |
|---|---|---|
|Id|Integer|Identificador|
|Username|String|Único|
|Password|String|Obrigatório|
|ForceUpdate|Boolean||
|Role|Role|Obrigatório|

Os atributos devem ser usados nas requisições PUT e POST. **A função deverá ser criada antes da criação do usuário**.

#### GET /api/user

```
GET https://devappcorp.herokuapp.com/api/user
```
```javascript
[
    {
        "id": 1,
        "username": "user.xpto",
        "password": "...",
        "forceUpdate": true,
        "role": {
            "id": 1,
            "name": "XPTO"
        }
    },
    {
        "id": 2,
        "username": "user2.xpto",
        "password": "...",
        "forceUpdate": false,
        "role": {
            "id": 1,
            "name": "XPTO"
        }
    }
]
```

#### GET /api/user/{id}

```
GET https://devappcorp.herokuapp.com/api/user/{id}
```
```javascript
{
    "id": 1,
    "username": "user.xpto",
    "password": "...",
    "forceUpdate": true,
    "role": {
        "id": 1,
        "name": "XPTO"
    }
}
```

#### POST /api/user

```
POST https://devappcorp.herokuapp.com/api/user/
```
```javascript
{
    "id": 1,
    "username": "user.xpto",
    "password": "...",
    "forceUpdate": true,
    "role": {
        "id": 1,
        "name": "XPTO"
    }
}
```

#### PUT /api/user

```
PUT https://devappcorp.herokuapp.com/api/user/{id}
```
```javascript
{
    "id": 1,
    "username": "user.xpto",
    "password": "...",
    "forceUpdate": true,
    "role": {
        "id": 1,
        "name": "XPTO"
    }
}
```

#### DELETE /api/user/{id}

```
DELETE https://devappcorp.herokuapp.com/api/user/{id}
```
```
200 OK
```

### Role (/api/role)

Esses endpoints podem ser usados para listar, criar, editar e excluir as funções de usuário do sistema. Cada usuário deve possuir uma, e somente uma, função. Essa entidade possui os seguintes atributos:

| Atributos | Tipo | Modificadores |
|---|---|---|
|Id|Integer|Identificador|
|Name|String|Único|

Os atributos devem ser usados nas requisições PUT e POST.

#### GET /api/role

```
GET https://devappcorp.herokuapp.com/api/role
```
```javascript
[
    {
        "id": 1,
        "name": "XPTO"
    },
    {
        "id": 2,
        "name": "XPTO2"
    }
]
```

#### GET /api/role/{id}

```
GET https://devappcorp.herokuapp.com/api/role/{id}
```
```javascript
{
    "id": 1,
    "name": "XPTO"
}
```

#### POST /api/role

```
POST https://devappcorp.herokuapp.com/api/role/
```
```javascript
{
    "id": 1,
    "name": "XPTO"
}
```

#### PUT /api/role/{id}

```
PUT https://devappcorp.herokuapp.com/api/role/{id}
```
```javascript
{
    "id": 1,
    "name": "XPTO"
}
```

#### DELETE /api/role/{id}

```
DELETE https://devappcorp.herokuapp.com/api/role/{id}
```
```
200 OK
```

### Service (/api/service)

Esses endpoints podem ser usados para listar, criar, editar e excluir os serviços do sistema. Essa entidade possui os seguintes atributos:

| Atributos | Tipo | Modificadores |
|---|---|---|
|Id|Integer|Identificador|
|Name|String|Único|
|Query|String|Obrigatório|
|Image|Image||

Os atributos devem ser usados nas requisições PUT e POST.

#### GET /api/service

```
GET https://devappcorp.herokuapp.com/api/service
```
```javascript
[
    {
        "id": 1,
        "name": "xpto.app",
        "query": "..."
    },
    {
        "id": 2,
        "name": "xpto.website",
        "query": "..."
    }
]
```

#### GET /api/service/{id}

```
GET https://devappcorp.herokuapp.com/api/service/{id}
```
```javascript
{
    "id": 1,
    "name": "xpto.app",
    "query": "..."
}
```

#### POST /api/service

```
POST https://devappcorp.herokuapp.com/api/service/
```
```javascript
{
    "id": 1,
    "name": "xpto.app",
    "query": "..."
}
```

#### PUT /api/service/{id}

```
PUT https://devappcorp.herokuapp.com/api/service/{id}
```
```javascript
{
    "id": 1,
    "name": "xpto.app",
    "query": "..."
}
```

#### DELETE /api/service/{id}

```
DELETE https://devappcorp.herokuapp.com/api/service/{id}
```
```
200 OK
```

### SystemVariable (/api/sysvar)

Esses endpoints podem ser usados para listar, criar, editar e excluir as variáveis do sistema. Essa entidade possui os seguintes atributos:

| Atributos | Tipo | Modificadores |
|---|---|---|
|Id|Integer|Identificador|
|Name|String|Único|
|Value|String|Obrigatório|
|SystemVariableType|SystemVariableType|Obrigatório|

Os atributos devem ser usados nas requisições PUT e POST. **O tipo de variável deverá ser criada antes da criação da variável**.

#### GET /api/sysvar

```
GET https://devappcorp.herokuapp.com/api/sysvar
```
```javascript
[
    {
        "id": 1,
        "name": "var.xpto.sysname",
        "value": "...",
        "systemVariableType": {
            "id": 1,
            "name": "var.XPTO"
        }
    },
    {
        "id": 2,
        "name": "var.xpto.systoken",
        "value": "...",
        "systemVariableType": {
            "id": 1,
            "name": "var.XPTO"
        }
    }
]
```

#### GET /api/sysvar/{id}

```
GET https://devappcorp.herokuapp.com/api/sysvar/{id}
```
```javascript
{
    "id": 1,
    "name": "var.xpto.sysname",
    "value": "...",
    "systemVariableType": {
        "id": 1,
        "name": "var.XPTO"
    }
}
```

#### POST /api/sysvar

```
POST https://devappcorp.herokuapp.com/api/sysvar/
```
```javascript
{
    "id": 1,
    "name": "var.xpto.sysname",
    "value": "...",
    "systemVariableType": {
        "id": 1,
        "name": "var.XPTO"
    }
}
```

#### PUT /api/sysvar/{id}

```
PUT https://devappcorp.herokuapp.com/api/sysvar/{id}
```
```javascript
{
    "id": 1,
    "name": "var.xpto.sysname",
    "value": "...",
    "systemVariableType": {
        "id": 1,
        "name": "var.XPTO"
    }
}
```

#### DELETE /api/sysvar/{id}

```
DELETE https://devappcorp.herokuapp.com/api/sysvar/{id}
```
```
200 OK
```

### SystemVariableType (/api/sysvartype)

Esses endpoints podem ser usados para listar, criar, editar e excluir os tipos de variável do sistema. Cada variável do sistema deve possuir um, e somente um, tipo. Essa entidade possui os seguintes atributos:

| Atributos | Tipo | Modificadores |
|---|---|---|
|Id|Integer|Identificador|
|Name|String|Único|

Os atributos devem ser usados nas requisições PUT e POST.

#### GET /api/sysvartype

```
GET https://devappcorp.herokuapp.com/api/sysvartype
```
```javascript
[
    {
        "id": 1,
        "name": "var.XPTO"
    },
    {
        "id": 2,
        "name": "var.XPTO.two"
    }
]
```

#### GET /api/sysvartype/{id}

```
GET https://devappcorp.herokuapp.com/api/sysvartype/{id}
```
```javascript
{
    "id": 1,
    "name": "var.XPTO"
}
```

#### POST /api/sysvartype

```
POST https://devappcorp.herokuapp.com/api/sysvartype/
```
```javascript
{
    "id": 1,
    "name": "var.XPTO"
}
```

#### PUT /api/sysvartype/{id}

```
PUT https://devappcorp.herokuapp.com/api/sysvartype/{id}
```
```javascript
{
    "id": 1,
    "name": "var.XPTO"
}
```

#### DELETE /api/sysvartype/{id}

```
DELETE https://devappcorp.herokuapp.com/api/sysvartype/{id}
```
```
200 OK
```

### Image (/api/image)

Esses endpoints podem ser usados para listar, criar, editar e excluir o nome dos arquivos de imagem do sistema. Essa entidade possui os seguintes atributos:

| Atributos | Tipo | Modificadores |
|---|---|---|
|Id|Integer|Identificador|
|FileName|String|Único|

Os atributos devem ser usados nas requisições PUT e POST.

#### GET /api/image

```
GET https://devappcorp.herokuapp.com/api/image
```
```javascript
[
    {
        "id": 1,
        "filename": "image.XPTO"
    },
    {
        "id": 2,
        "filename": "image.XPTO.two"
    }
]
```

#### GET /api/image/{id}

```
GET https://devappcorp.herokuapp.com/api/image/{id}
```
```javascript
{
    "id": 1,
    "filename": "image.XPTO"
}
```

#### POST /api/image

```
POST https://devappcorp.herokuapp.com/api/image/
```
```javascript
{
    "id": 1,
    "filename": "image.XPTO"
}
```

#### PUT /api/image/{id}

```
PUT https://devappcorp.herokuapp.com/api/image/{id}
```
```javascript
{
    "id": 1,
    "filename": "image.XPTO"
}
```

#### DELETE /api/image/{id}

```
DELETE https://devappcorp.herokuapp.com/api/image/{id}
```
```
200 OK
```

### User Log (/api/userlog)

Esses endpoints podem ser usados para listar, criar, editar e excluir registros de acesso dos usuário do sistema. Essa entidade possui os seguintes atributos:

| Atributos | Tipo | Modificadores |
|---|---|---|
|Id|Integer|Identificador|
|User|User|Obrigatório|
|Timestamp|Timestamp|Obrigatório|

Os atributos devem ser usados nas requisições PUT e POST.

#### GET /api/userlog

```
GET https://devappcorp.herokuapp.com/api/userlog
```
```javascript
[
    {
        "id": 1,
        "user": {...},
        "timestamp": 1655333753154
    },
    {
        "id": 2,
        "user": {...},
        "timestamp": 1655333753154
    }
]
```

#### GET /api/userlog/{id}

```
GET https://devappcorp.herokuapp.com/api/userlog/{id}
```
```javascript
{
    "id": 1,
    "user": {...},
    "timestamp": 1655333753154
}
```

#### POST /api/userlog

```
POST https://devappcorp.herokuapp.com/api/userlog/
```
```javascript
{
    "id": 1,
    "user": {...},
    "timestamp": 1655333753154
}
```

#### PUT /api/userlog/{id}

```
PUT https://devappcorp.herokuapp.com/api/userlog/{id}
```
```javascript
{
    "id": 1,
    "user": {...},
    "timestamp": 1655333753154
}
```

#### DELETE /api/userlog/{id}

```
DELETE https://devappcorp.herokuapp.com/api/userlog/{id}
```
```
200 OK
```

### Service History (/api/servicehistory)

Esses endpoints podem ser usados para listar, criar, editar e excluir o número de reclamações dos serviços do sistema. Essa entidade possui os seguintes atributos:

| Atributos | Tipo | Modificadores |
|---|---|---|
|Id|Integer|Identificador|
|Service|Service|Obrigatório|
|Complaints|Integer|Obrigatório|
|collectionTimestamp|Timestamp|Obrigatório|

Os atributos devem ser usados nas requisições PUT e POST.

#### GET /api/servicehistory

```
GET https://devappcorp.herokuapp.com/api/servicehistory
```
```javascript
[
    {
        "id": 1,
        "service": {...},
        "complaints": 10,
        "collectionTimestamp": 1655333753154
    },
    {
        "id": 2,
        "service": {...},
        "complaints": 15,
        "collectionTimestamp": 1655333753154
    }
]
```

#### GET /api/servicehistory/{id}

```
GET https://devappcorp.herokuapp.com/api/servicehistory/{id}
```
```javascript
{
    "id": 1,
    "service": {...},
    "complaints": 10,
    "collectionTimestamp": 1655333753154
}
```

#### POST /api/servicehistory

```
POST https://devappcorp.herokuapp.com/api/servicehistory/
```
```javascript
{
    "id": 1,
    "service": {...},
    "complaints": 10,
    "collectionTimestamp": 1655333753154
}
```

#### PUT /api/servicehistory/{id}

```
PUT https://devappcorp.herokuapp.com/api/servicehistory/{id}
```
```javascript
{
    "id": 1,
    "service": {...},
    "complaints": 10,
    "collectionTimestamp": 1655333753154
}
```

#### DELETE /api/servicehistory/{id}

```
DELETE https://devappcorp.herokuapp.com/api/servicehistory/{id}
```
```
200 OK
```

## Participantes

* Gabriel Inácio dos Santos Moreira (gabrielinacio@id.uff.br)
* Ricardo de Freitas Carletti (ricardocarletti@id.uff.br)
* Rafael Lins Pinheiro (rafaellins@id.uff.br)
* Lucas de Oliveira Tenório (lucasot@id.uff.br)