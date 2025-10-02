// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.realtime

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.emptyHandler
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.realtime.calls.CallAcceptParams
import com.openai.models.realtime.calls.CallHangupParams
import com.openai.models.realtime.calls.CallReferParams
import com.openai.models.realtime.calls.CallRejectParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class CallServiceImpl internal constructor(private val clientOptions: ClientOptions) : CallService {

    private val withRawResponse: CallService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CallService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CallService =
        CallServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun accept(params: CallAcceptParams, requestOptions: RequestOptions) {
        // post /realtime/calls/{call_id}/accept
        withRawResponse().accept(params, requestOptions)
    }

    override fun hangup(params: CallHangupParams, requestOptions: RequestOptions) {
        // post /realtime/calls/{call_id}/hangup
        withRawResponse().hangup(params, requestOptions)
    }

    override fun refer(params: CallReferParams, requestOptions: RequestOptions) {
        // post /realtime/calls/{call_id}/refer
        withRawResponse().refer(params, requestOptions)
    }

    override fun reject(params: CallRejectParams, requestOptions: RequestOptions) {
        // post /realtime/calls/{call_id}/reject
        withRawResponse().reject(params, requestOptions)
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CallService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CallService.WithRawResponse =
            CallServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val acceptHandler: Handler<Void?> = emptyHandler()

        override fun accept(
            params: CallAcceptParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("callId", params.callId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("realtime", "calls", params._pathParam(0), "accept")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { acceptHandler.handle(it) }
            }
        }

        private val hangupHandler: Handler<Void?> = emptyHandler()

        override fun hangup(
            params: CallHangupParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("callId", params.callId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("realtime", "calls", params._pathParam(0), "hangup")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { hangupHandler.handle(it) }
            }
        }

        private val referHandler: Handler<Void?> = emptyHandler()

        override fun refer(params: CallReferParams, requestOptions: RequestOptions): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("callId", params.callId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("realtime", "calls", params._pathParam(0), "refer")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { referHandler.handle(it) }
            }
        }

        private val rejectHandler: Handler<Void?> = emptyHandler()

        override fun reject(
            params: CallRejectParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("callId", params.callId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("realtime", "calls", params._pathParam(0), "reject")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { rejectHandler.handle(it) }
            }
        }
    }
}
