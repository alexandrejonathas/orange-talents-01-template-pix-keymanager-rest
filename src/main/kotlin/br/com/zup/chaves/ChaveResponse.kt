package br.com.zup.chaves

import java.time.LocalDateTime

data class ChaveResponse(
    var chaveId: Long,
    var clienteId: String,
    var tipoDaChave: String,
    var chave: String,
    var tipoDaConta: String,
    var criadoEm: LocalDateTime
)

data class ChaveCompletaResponse(
    val chaveId: Long?,
    val clienteId: String,
    val tipoDaChave: String,
    val chave: String,
    val titular: TitularResponse,
    val conta: ContaResponse,
    val criadoEm: LocalDateTime
)

data class TitularResponse(
    val cpf: String,
    val nome: String
)

data class ContaResponse(
    val nomeInstituicao: String,
    val agencia: String,
    val numero: String,
    val tipoDaConta: String
)