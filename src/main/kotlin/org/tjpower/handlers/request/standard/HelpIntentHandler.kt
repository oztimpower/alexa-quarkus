/*
     Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/
package org.tjpower.handlers.request.standard

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.impl.IntentRequestHandler
import com.amazon.ask.model.IntentRequest
import com.amazon.ask.model.Response
import org.tjpower.Messages
import java.util.*

class HelpIntentHandler : IntentRequestHandler {
    override fun canHandle(handlerInput: HandlerInput, intentRequest: IntentRequest): Boolean {
        return intentRequest.intent.name == "AMAZON.HelpIntent"
    }

    override fun handle(handlerInput: HandlerInput, intentRequest: IntentRequest): Optional<Response> {
        return handlerInput.responseBuilder
                .withSpeech(Messages["HELP"])
                .withReprompt(Messages["REPROMPT"])
                .build()
    }
}