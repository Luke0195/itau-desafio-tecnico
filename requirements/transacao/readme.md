> ### Transação

> #### Caso de sucesso 

1. [ ] Recebe uma requisição do tipo post na rota /transação.
2. [ ] Valida os campos obrigatórios valor, dataHora.
3. [ ] Não permite que transações acontecam no futuro..
4. [ ] Valida a dataHora da transação em qualquer momento no passado.
5. [ ] Valida se o valor é negativo.
6. [ ] Valida se o valor é igual ou maior que zero.
7. [ ] Adiciona uma transação quantos os dados são informados com sucesso.
8. [ ] Retona 201 caso a transação seja executada com sucesso.

> #### Exceções

1. [ ] Retorna erro 404 se a API não existir.
2. [ ] Retorna erro 400 se o valor e a dataHora não forem informados pelo client.
3. [ ] Retorna erro 422 se a dataHora da transação não for válido.
4. [ ] Retorna erro 422 se o valor da transação for negativo.
5. [ ] Retorna eror 422 se o valor da transação for igual a zero.