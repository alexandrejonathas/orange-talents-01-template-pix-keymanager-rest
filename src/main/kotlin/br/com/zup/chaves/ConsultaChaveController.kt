package br.com.zup.chaves

import br.com.zup.ConsultaChavePixGrpcServiceGrpc
import br.com.zup.ConsultaChavePixRequest
import br.com.zup.ConsultaChavePixResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.PathVariable
import javax.inject.Inject

@Controller
class ConsultaChaveController(
    @Inject val gRpcClient: ConsultaChavePixGrpcServiceGrpc.ConsultaChavePixGrpcServiceBlockingStub
) {

    @Get("/api/clientes/{clienteId}/chaves/{chaveId}")
    fun consulta(@PathVariable chaveId: Long, @PathVariable clienteId: String): ChaveCompletaResponse{
        val request = ConsultaChavePixRequest.newBuilder()
            .setChaveId(ConsultaChavePixRequest.FiltroPorPixId.newBuilder()
                .setChaveId(chaveId)
                .setClienteId(clienteId).build()).build()
        val response = gRpcClient.consultar(request)
        return response.toChaveCompleta()
    }

    @Get("/api/chaves/{chave}")
    fun consulta(@PathVariable chave: String): ChaveCompletaResponse{
        val request = ConsultaChavePixRequest.newBuilder()
            .setChave(chave)
            .build()
        val response = gRpcClient.consultar(request)
        return response.toChaveCompleta()
    }
}