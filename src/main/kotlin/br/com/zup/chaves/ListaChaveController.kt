package br.com.zup.chaves

import br.com.zup.ListaChavePixGrpcServiceGrpc
import br.com.zup.ListaChavePixRequest
import br.com.zup.ListaChavePixResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import org.slf4j.LoggerFactory
import java.lang.IllegalStateException
import javax.inject.Inject

@Controller
class ListaChaveController(
    @Inject val gRpcClient:
    ListaChavePixGrpcServiceGrpc.ListaChavePixGrpcServiceBlockingStub
) {

    val logger = LoggerFactory.getLogger(this::class.java)

    @Get("/api/clientes/{clienteId}/chaves")
    fun lista(@PathVariable clienteId: String): List<ChaveResponse>{

        if(clienteId == null)
            throw IllegalStateException("O clienteId é obrigatório")

        var request = ListaChavePixRequest.newBuilder()
            .setClienteId(clienteId).build()

        var response = gRpcClient.listar(request) as ListaChavePixResponse

        logger.info("Response: $response")

        return response.chavesList.map { chavePix ->
            ChaveResponse(
                chavePix.chaveId,
                chavePix.clienteId,
                chavePix.tipoDaChave,
                chavePix.chave,
                chavePix.tipoDaConta,
                chavePix.criadoEm.toLocalDatetime()
            )
        }
    }

}