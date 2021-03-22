package br.com.zup.chaves

import br.com.zup.CadastraChavePixRequest
import br.com.zup.CadastraChavePixGrpc
import br.com.zup.CadastraChavePixGrpcServiceGrpc
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import org.slf4j.LoggerFactory
import javax.inject.Inject
import javax.validation.Valid

@Validated
@Controller
class CadastraChaveController(
    @Inject val gRpcClient: CadastraChavePixGrpcServiceGrpc.CadastraChavePixGrpcServiceBlockingStub
) {

    val logger = LoggerFactory.getLogger(this::class.java)

    @Post("/api/chaves")
    fun cadastra(@Body @Valid novaChaveRequest: NovaChaveRequest){

        logger.info("Request: $novaChaveRequest")

        var request = CadastraChavePixRequest.newBuilder()
            .setClientId(novaChaveRequest.clientId)
            .setTipoDaChave(novaChaveRequest.tipoDaChave)
            .setChave(novaChaveRequest.chave)
            .setTipoDaConta(novaChaveRequest.tipoDaConta)
            .build()

        gRpcClient.cadastrar(request);
    }

}