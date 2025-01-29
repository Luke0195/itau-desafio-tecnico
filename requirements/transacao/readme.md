> ### Transação

> #### Caso de sucesso 

1. [X] Recebe uma requisição do tipo post na rota /transacao.
2. [X] Valida os campos obrigatórios valor, dataHora.
3. [X] Não permite que transações sejam lancadas com datas no futuro..
4. [X] Valida a dataHora da transação em qualquer momento no passado.
5. [X] Valida se o valor é negativo.
6. [X] Valida se o valor é igual ou maior que zero.
7. [X] Adiciona uma transação quantos os dados são informados com sucesso.
8. [X] Retorna 201 caso a transação seja executada com sucesso.
9. [ ] Recebe uma requisição do tipo delete / transacao
10.[ ] Remove todas as transações cadastradas.
 
> #### Exceções

1. [X] Retorna erro 404 se a API não existir.
2. [X] Retorna erro 400 se o valor e a dataHora não forem informados pelo cliente.
3. [X] Retorna erro 422 se a dataHora da transação não for válido.
4. [X] Retorna erro 422 se o valor da transação for negativo.
5. [X] Retorna eror 422 se o valor da transação for igual a zero.