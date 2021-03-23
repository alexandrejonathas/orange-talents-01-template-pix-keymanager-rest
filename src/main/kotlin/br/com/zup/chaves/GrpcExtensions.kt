package br.com.zup.chaves

import br.com.zup.ConsultaChavePixResponse

fun ConsultaChavePixResponse.toChaveCompleta(): ChaveCompletaResponse {
    return ChaveCompletaResponse(
        chaveId = if(!chaveId.isNullOrBlank()) chaveId.toLong() else null,
        clienteId = clienteId,
        chave = chave,
        tipoDaChave = tipoDaChave,
        titular = TitularResponse(
            cpf = titular.cpf,
            nome = titular.nome
        ),
        conta = ContaResponse(
            nomeInstituicao = conta.nome,
            agencia = conta.agencia,
            numero = conta.numero,
            tipoDaConta = conta.tipoDaConta
        ),
        criadoEm = criadoEm.toLocalDatetime()
    )
}