package br.com.zup.chaves

import com.google.protobuf.Timestamp
import com.google.protobuf.TimestampProto
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZoneOffset

fun Timestamp.toLocalDatetime(): LocalDateTime {
    return LocalDateTime.ofEpochSecond(this.seconds, this.nanos, ZoneOffset.UTC)
}