/*
     Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/
package org.tjpower.handlers.request.custom

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.handler.impl.IntentRequestHandler
import com.amazon.ask.model.IntentRequest
import com.amazon.ask.model.Response
import com.amazon.ask.request.RequestHelper
import java.util.*

class InProgressHandler : IntentRequestHandler {

    override fun canHandle(handlerInput: HandlerInput, intentRequest: IntentRequest): Boolean {
        val helper = RequestHelper.forHandlerInput(handlerInput)
        return helper.requestType == "IntentRequest" && helper.intentName == "MyPersonalizationIntent"
    }

    override fun handle(handlerInput: HandlerInput, intentRequest: IntentRequest): Optional<Response> {
        val person = handlerInput.requestEnvelope.context.system.person
        println("PersonID [ $person ]")
        if (person != null) {
            val personId = person.personId
            println("PersonID [ $personId ]")
            val accessToken = person.accessToken
            // This is for demo purpose only, you should never log accessToken.
            println("Received accessToken for person: $accessToken");
            // Build a greeting response with first name.
            val personalizedGreeting = "Hi <alexa:name type=\"first\" personId=\"" + personId + "\"/>";

            return handlerInput.responseBuilder.withSpeech(personalizedGreeting).build()
        }

        return handlerInput.responseBuilder.withSpeech("Hi Stranger").build()
    }
}
