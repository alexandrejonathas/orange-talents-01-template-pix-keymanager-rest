package br.com.zup.exceptionhandler

import io.grpc.Status
import io.grpc.StatusRuntimeException
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.hateoas.JsonError
import io.micronaut.http.server.exceptions.ExceptionHandler
import javax.inject.Singleton

@Singleton
class GrpcExceptionHandler: ExceptionHandler<StatusRuntimeException, HttpResponse<Any>> {
    override fun handle(request: HttpRequest<*>?, e: StatusRuntimeException?)
        : HttpResponse<Any> {
        val (status, message) = when(e?.status?.code){
            Status.INVALID_ARGUMENT.code -> Pair(HttpStatus.BAD_REQUEST, e?.status?.description)
            Status.ALREADY_EXISTS.code -> Pair(HttpStatus.UNPROCESSABLE_ENTITY, e?.status?.description)
            Status.NOT_FOUND.code -> Pair(HttpStatus.NOT_FOUND, e?.status?.description)
            Status.FAILED_PRECONDITION.code -> Pair(HttpStatus.UNPROCESSABLE_ENTITY, e?.status?.description)
            else -> Pair(HttpStatus.INTERNAL_SERVER_ERROR, "Erro desconhecido")
        }
        return HttpResponse.status<JsonError>(status).body(JsonError(message))
    }
}
