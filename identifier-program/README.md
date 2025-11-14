# Estudo de Casos de Testes - Programa Identifier

---

O presente projeto dispõe de uma simples classe denominada `Identifier`, destinada para criação de identificadores válidos com base em alguns requerimentos.
Esse projeto tem como objetivo apresentar as práticas necessárias para se desenvolver casos de testes, implementá-los e automatizá-los através de uma pipeline
com o GitHub workflow.


### Especificação do Programa
O programa deve determinar se um identificador é válido ou não.
Um identificador válido:
- Deve começar com uma letra (a-z ou A-Z);
- Pode conter apenas letras ou dígitos;
- Deve ter de 1 a 6 caracteres de comprimento (inclusive).

A função `validateIdentifier` será a função que utilizaremos nesses casos de teste, onde o retorno será True ou False (válido ou inválido).

### Classes de Equivalência

| ID   | Descrição da Partição            | Válida/Inválida | Valores         |
|------|----------------------------------|-----------------|-----------------| 
| CE1  | Comprimento abaixo do mínimo     | Inválida        | < 1             |
| CE2  | Comprimento dentro do intervalo  | Válida          | 1 <= x <=6      | 
| CE3  | Comprimento acima do máximo      | Inválida        | x > 6           |
| CE4  | Inicia com letra                 | Válida          | (a - z ou A-Z)  |
| CE5  | Não inicia com letra             | Inválida        |                 |
| CE6  | Contém letras ou dígitos         | Válida          | (a-zA-Z ou 0-9) |
| CE7  | Contém caracteres especiais      | Inválida        | (!%$*&#@)       |


### Valores limites

| ID  | Limite | Valores de Teste   |
|-----|--------|--------------------|
| VL1 | Mínimo | 0 e 1              |
| VL2 | Máximo | 6 e 7              |




### Casos de Teste

| ID  | Nome do Teste                                     | Critérios       | Entrada | Saída Esperada | Status             |
|-----|---------------------------------------------------|-----------------|---------|----------------|--------------------|
| TC1 | testIdentifierEmpty                               | CE1/VL1         |         | False          | :white_check_mark: | 
| TC2 | testIdentifierStartedWithDigitMinLength           | CE2/CE5/VL1     | 0       | False          | :white_check_mark: |
| TC3 | testIdentifierStartedWithLetterMinLength          | CE2/CE4/VL1     | O       | True           | :white_check_mark: |
| TC4 | testIdentifierWithOnlyLettersMaxLength            | CE2/CE4/VL2     | olala2  | True           | :white_check_mark: | 
| TC5 | testIdentifierWithLettersAndDigitsExceedingLength | CE3/CE4/VL2     | o123456 | False          | :white_check_mark: | 
| TC6 | testIdentifierWithLettersAndDigitsUntilMaxLength  | CE2/CE6/CE7/VL2 | olala!  | False          | :white_check_mark: | 