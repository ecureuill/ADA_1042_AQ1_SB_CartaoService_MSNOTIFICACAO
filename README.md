# ADA_1042_AQ1_SB_CartaoService_MSNOTIFICACAO

## Features

- [Criação de Conta](#criação-de-conta-)
- [Nova compra](#nova-compra-)
- [Envio de Fatura](#envia-fatura-de-conta)

## Contratos

### Criação de conta. 
**Método**: POST <br>
**Endpoint**: `/send/newaccount` <br>
**Descrição**: Envia uma notificação para ativação de conta.

- Request body (json)/:
<details>
  <summary>id: UUID</summary>

- **Descrição**: Identificador único no formato UUID.
- **Validação**: Deve ser um UUID válido.
</details>

<details>
  <summary>document: String</summary>

- **Descrição**: Documento único do usuário.
- **Validação**: Deve ser um documento válido (apenas números). Deve ter obrigatoriamente o tamanho de 11 caracteres numéricos.
</details>

<details>
  <summary>email: String</summary>

- **Descrição**: Email único do usuário.
- **Validação**: Deve ser um email válido.
</details>

<details>
   <summary>phone: String</summary>

- **Descrição**: Número de contato único do usuário.
- **Validação**: Deve ser um número de telefone ou celular válido. Apenas números, com o DDD.
</details>

<details>
   <summary>channel: Enum</summary>

- **Descrição**: 0: Email, 1: SMS - Só aceita e-mail por enquanto.
</details>

<details>
   <summary>code: String</summary>

- **Descrição**: Código de ativação gerado com a geração da conta, será enviado no email.
- **Validação**: Deve ser um código de seis digitos. 
</details>

<details>
     <summary>name: String</summary>

- **Descrição**: Nome do usuário.
- **Validação**: Deve ter pelo menos dois caracteres e não conter números.
</details>

<details>
     <summary>credit_card: String</summary>

- **Descrição**: Apenas últimos quatro digitos do cartão.
- **Validação**: Deve obrigatoriamente ter 4 caracteres númericos.

</details>

<details>
<summary>dependents: Array de objetos</summary>

- **Descrição**: Um array dos dependentes criados na conta, com o nome e documento dos dependentes.
- **Validação**: A mesma de nome e de documento.
</details>

``` json

// exemplo
{
    "id": "6f7b5937-0b3a-4a24-8b94-56a36e6a04a7",
    "document": "12345678901",
    "email": "usuario@example.com",
    "phone": "98764321234",
    "channel": 0,
    "code": "123456",
    "name": "João da Silva",
    "credit_card": "1234",
    "dependents": [
        {
            "name": "Maria da Silva",
            "document": "98765432101"
        },
        {
            "name": "Pedro da Silva",
            "document": "45678912301"
        }
    ]
}

```

- **Responses**:
<details>

<summary>Success: 201</summary>

```json
{
  "subject": "Account creation",
  "result": "Message was sent with success.",
  "channel": "E-mail",
  "recipient": "usuario@example.com",
  "name": "João da Silva"
}
```
</details>

### Nova Compra. 
**Método**: POST <br>
**Endpoint**: `/send/purchase` <br>
**Descrição**: Envia um e-mail indicando que uma compra foi realizada e será adicionada a fatura.

- Request body (json)

<details>
  <summary>id</summary>

- **Descrição**: Identificador único da compra.
- **Validação**: Deve ser um UUID válido.
</details>

<details>
  <summary>document: String</summary>

- **Descrição**: Documento único do USUÁRIO que receberá a notificação, não de quem fez a compra.
- **Validação**: Deve ser um documento válido (apenas números). Deve ter obrigatoriamente o tamanho de 11 caracteres numéricos.
</details>

<details>
  <summary>buyer_name: String</summary>

- **Descrição**: Nome do dono do cartão de crédito que executou a compra (pode ser o dependente).
- **Validação**: Deve ser um nome válido.
</details>

<details>
  <summary>buyer_document: String</summary>

- **Descrição**: Documento único do comprador, pode ser dependente ou não.
- **Validação**: Deve ser um documento válido (apenas números). Deve ter obrigatoriamente o tamanho de 11 caracteres numéricos.
</details>

<details>
  <summary>buyer_card: String</summary>

- **Descrição**: Últimos quatro digitos do cartão que executou a compra.
- **Validação**: Deve ser um nome válido.
</details>

<details>
   <summary>value: BigDecimal</summary>

- **Descrição**: Valor da compra em reais.
- **Validação**: Deve ser um valor válido.
</details>

<details>
   <summary>date: Instant</summary>

- **Descrição**: Timestamp exato com milisegundos de quando a compra foi realizada.
- **Validação**: Deve ser uma data timestamp com milissegundos.
</details>

```json
//exemplo: 
{
  "id": "6f7b5937-0b3a-4a24-8b94-56a36e6a04a7",
  "document": "12345678901",
  "buyer_name": "Maria da Silva",
  "buyer_document": "98765432101",
  "buyer_card": "1234",
  "value": 100.50,
  "date": "2023-09-06T15:30:00.000Z"
}
``` 

- Responses: 
<details>

<summary>Success: 201</summary>

```json 
{
  "id": "6f7b5937-0b3a-4a24-8b94-56a36e6a04a7",
  "document": "12345678901",
  "buyer_name": "Maria da Silva",
  "buyer_document": "98765432101",
  "buyer_card": "1234",
  "value": 100.50,
  "date": "2023-09-06T15:30:00.000Z"
}
```
</details>

### Envia fatura de conta.
**Método**: POST <br>
**Endpoint**: `/send/invoice` <br>
**Descrição**: Envia uma notificação para ativação de conta.

- Request Body (json)
