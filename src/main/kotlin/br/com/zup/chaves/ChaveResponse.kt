package br.com.zup.chaves

import java.time.LocalDateTime

data class ChaveResponse(
    var chaveId: Long,
    var clienteId: String,
    var tipoDaChave: String,
    var chave: String,
    var tipoDaConta: String,
    var criadoEm: LocalDateTime
) {
}