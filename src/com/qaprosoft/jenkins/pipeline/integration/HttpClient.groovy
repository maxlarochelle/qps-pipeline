package com.qaprosoft.jenkins.pipeline.integration

import static com.qaprosoft.jenkins.Utils.*
import static com.qaprosoft.jenkins.pipeline.Executor.*

abstract class HttpClient {

    protected def context

    public HttpClient(context) {
        this.context = context
    }


    /** Sends httpRequest using passed parameters */
    protected def sendRequestFormatted(requestParams) {
        def response = sendRequest(requestParams)
        if (response){
            return getObjectResponse(response)
        }
    }

    protected def sendRequest(requestParams) {
        def response = null
        /** Catches exceptions in every http call */
        try {
            response = context.httpRequest requestParams
        } catch (Exception e) {
            logger.error(printStackTrace(e))
        }
        if (!response || response.status >= 400){
            // [VD] as we don't remember the reason of making build as FAILURE we commented these lines
//            if (!requestParams.url.contains("queue")) {
//                context.currentBuild.result = BuildResult.FAILURE
//            }
            return
        }
        return response.content
    }

}
