package org.tjpower

import com.amazon.ask.Skill
import com.amazon.ask.SkillStreamHandler
import com.amazon.ask.Skills
import org.tjpower.handlers.exception.CatchAllExceptionHandler
import org.tjpower.handlers.request.custom.InProgressHandler
import org.tjpower.handlers.request.standard.*
import org.tjpower.interceptors.RequestLogger
import org.tjpower.interceptors.ResponseLogger

class LambdaStreamHandler : SkillStreamHandler(getSkill()) {

    companion object {
        fun getSkill(): Skill = Skills.standard()
                .addRequestInterceptor(RequestLogger())
                .addRequestHandlers(
                        LaunchHandler(),
                        InProgressHandler(),
                        FallbackIntentHandler(),
                        HelpIntentHandler(),
                        ExitIntentHandler(),
                        SessionEndedHandler()
                )
                .addResponseInterceptor(ResponseLogger())
                .addExceptionHandler(CatchAllExceptionHandler()) // Add your skill id below
                // .withSkillId("")
                .build()

    }

}