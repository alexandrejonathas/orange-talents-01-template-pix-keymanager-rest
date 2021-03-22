package br.com.zup.chaves

import br.com.zup.CadastraChavePixGrpcServiceGrpc
import br.com.zup.DeletaChavePixGrpcServiceGrpc
import br.com.zup.ListaChavePixGrpcServiceGrpc
import io.grpc.ManagedChannel
import io.micronaut.context.annotation.Factory
import io.micronaut.grpc.annotation.GrpcChannel
import javax.inject.Singleton

@Factory
class GrpcClientFactory {

    @Singleton
    fun cadastraChavePixClientStub(
        @GrpcChannel("pix") channel: ManagedChannel
    ) : CadastraChavePixGrpcServiceGrpc.CadastraChavePixGrpcServiceBlockingStub
        = CadastraChavePixGrpcServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun listaChavePixClientStub(
        @GrpcChannel("pix") channel: ManagedChannel
    ): ListaChavePixGrpcServiceGrpc.ListaChavePixGrpcServiceBlockingStub
     = ListaChavePixGrpcServiceGrpc.newBlockingStub(channel)

    @Singleton
    fun deletaChavePixClientStub(
        @GrpcChannel("pix") channel: ManagedChannel
    ): DeletaChavePixGrpcServiceGrpc.DeletaChavePixGrpcServiceBlockingStub
        = DeletaChavePixGrpcServiceGrpc.newBlockingStub(channel)

}