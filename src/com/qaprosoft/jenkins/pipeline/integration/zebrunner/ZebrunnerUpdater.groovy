package com.qaprosoft.jenkins.pipeline.integration.zebrunner

import com.qaprosoft.jenkins.Logger
import com.qaprosoft.jenkins.pipeline.Configuration

class ZebrunnerUpdater {

    private def context
    private ZebrunnerClient zc
    private Logger logger

    public ZebrunnerUpdater(context) {
        this.context = context
        zc = new ZebrunnerClient(context)
        logger = new Logger(context)
    }

    public def sendInitResult(integrationParameters, initialized) {
        def tenancyName = Configuration.get("folderName")
        def zafiraAccessToken = Configuration.get("zafiraAccessToken")
        def callbackURL = Configuration.get("callbackUrl")
        return zc.sendInitResult(integrationParameters, tenancyName, zafiraAccessToken, callbackURL, initialized)
    }
}
