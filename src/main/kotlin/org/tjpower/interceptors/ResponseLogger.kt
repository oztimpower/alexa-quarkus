/*
     Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.

     Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file
     except in compliance with the License. A copy of the License is located at

         http://aws.amazon.com/apache2.0/

     or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS,
     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for
     the specific language governing permissions and limitations under the License.
*/
package org.tjpower.interceptors

import com.amazon.ask.dispatcher.request.handler.HandlerInput
import com.amazon.ask.dispatcher.request.interceptor.ResponseInterceptor
import com.amazon.ask.model.Response
import org.jboss.logging.Logger
import java.util.*

class ResponseLogger : ResponseInterceptor {
    override fun process(handlerInput: HandlerInput, response: Optional<Response?>) {
        responseLogger.info(String.format("Response: %s", response))
    }

    companion object {
        private val responseLogger = Logger.getLogger(ResponseLogger::class.java)
    }
}