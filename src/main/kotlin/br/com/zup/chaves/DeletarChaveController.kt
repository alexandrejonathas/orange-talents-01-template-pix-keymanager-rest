package br.com.zup.chaves

import br.com.zup.DeletaChavePixGrpcRequest
import br.com.zup.DeletaChavePixGrpcServiceGrpc
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.PathVariable
import javax.inject.Inject

@Controller
class DeletarChaveController(
    @Inject val gRpcClient: DeletaChavePixGrpcServiceGrpc.DeletaChavePixGrpcServiceBlockingStub
) {

    @Delete("/api/chaves/{chaveId}/cliente/{clienteId}")
    fun deleta(@PathVariable chaveId: Long, @PathVariable clienteId: String){

        if(chaveId == null || clienteId.isNullOrBlank())
            throw IllegalStateException("A chaveId e o clienteId são obrigatórios")

        var request = DeletaChavePixGrpcRequest.newBuilder()
            .setChaveId(chaveId)
            .setClienteId(clienteId).build()

        gRpcClient.deletar(request)

    }

}