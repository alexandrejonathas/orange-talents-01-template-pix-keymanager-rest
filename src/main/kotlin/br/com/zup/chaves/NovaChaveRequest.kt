package br.com.zup.chaves

import br.com.zup.TipoDaChave
import br.com.zup.TipoDaConta
import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Introspected
data class NovaChaveRequest(
    @field:NotBlank
    val clientId: String,
    @field:NotNull
    val tipoDaChave: TipoDaChave?,
    @field:Size(max = 77)
    val chave: String,
    @field:NotNull
    val tipoDaConta: TipoDaConta?
)
