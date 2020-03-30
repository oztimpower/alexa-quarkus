/*
     Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/
package org.tjpower.handlers.exception

import com.amazon.ask.dispatcher.exception.ExceptionHandler
import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.model.Response
import org.slf4j.LoggerFactory
import org.tjpower.Messages
import java.util.*

// This handler catches all kinds of exceptions and prints the stack trace to AWS Cloudwatch with the request envelope.
class CatchAllExceptionHandler : ExceptionHandler {
    override fun canHandle(handlerInput: HandlerInput, throwable: Throwable): Boolean {
        return true
    }

    override fun handle(handlerInput: HandlerInput, throwable: Throwable): Optional<Response> {
        exceptionLogger.error(throwable.message)
        val speech = Messages["UNHANDLED"]
        return handlerInput.responseBuilder
                .withSpeech(speech)
                .withReprompt(speech)
                .build()
    }

    companion object {
        private val exceptionLogger = LoggerFactory.getLogger(CatchAllExceptionHandler::class.java)
    }
}