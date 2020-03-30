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
import com.amazon.ask.dispatcher.request.handler.impl.SessionEndedRequestHandler
import com.amazon.ask.model.Response
import com.amazon.ask.model.SessionEndedRequest
import java.util.*

class SessionEndedHandler : SessionEndedRequestHandler {
    override fun canHandle(handlerInput: HandlerInput, sessionEndedRequest: SessionEndedRequest): Boolean {
        return true
    }

    override fun handle(handlerInput: HandlerInput, sessionEndedRequest: SessionEndedRequest): Optional<Response> {
        // any cleanup logic goes here
        return handlerInput.responseBuilder.build()
    }
}