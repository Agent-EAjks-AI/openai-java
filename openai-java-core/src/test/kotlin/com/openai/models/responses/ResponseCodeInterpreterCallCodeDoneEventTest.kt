// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseCodeInterpreterCallCodeDoneEventTest {

    @Test
    fun create() {
        val responseCodeInterpreterCallCodeDoneEvent =
            ResponseCodeInterpreterCallCodeDoneEvent.builder()
                .code("code")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        assertThat(responseCodeInterpreterCallCodeDoneEvent.code()).isEqualTo("code")
        assertThat(responseCodeInterpreterCallCodeDoneEvent.itemId()).isEqualTo("item_id")
        assertThat(responseCodeInterpreterCallCodeDoneEvent.outputIndex()).isEqualTo(0L)
        assertThat(responseCodeInterpreterCallCodeDoneEvent.sequenceNumber()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseCodeInterpreterCallCodeDoneEvent =
            ResponseCodeInterpreterCallCodeDoneEvent.builder()
                .code("code")
                .itemId("item_id")
                .outputIndex(0L)
                .sequenceNumber(0L)
                .build()

        val roundtrippedResponseCodeInterpreterCallCodeDoneEvent =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseCodeInterpreterCallCodeDoneEvent),
                jacksonTypeRef<ResponseCodeInterpreterCallCodeDoneEvent>(),
            )

        assertThat(roundtrippedResponseCodeInterpreterCallCodeDoneEvent)
            .isEqualTo(responseCodeInterpreterCallCodeDoneEvent)
    }
}
