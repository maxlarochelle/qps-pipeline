package com.qaprosoft

import static com.qaprosoft.jenkins.Utils.*

class Logger implements Serializable {

    public enum LogLevel {
        DEBUG(1),
        INFO(2),
        WARN(3),
        ERROR(4),
    
        final int value
        LogLevel(int value) {
            this.value = value
        }
    }
    
    // create singleton instance
    private static final INSTANCE = new Logger()
    
    private Logger() {     
    }

    public debug(script, msg) {       
        log(script, LogLevel.DEBUG, msg)
    }
    
    public info(script, msg) {       
        log(script, LogLevel.INFO, msg)
    }
    
    public warn(script, msg) {
        log(script, LogLevel.WARNING, msg)
    }

    public error(script, msg) {
        log(script, LogLevel.ERROR, msg)
    }
    
    private log(script, logLevel, message) {
        def pipelineLogLevel = script.binding.variables.get("QPS_PIPELINE_LOG_LEVEL") ? LogLevel.valueOf(script.binding.variables.QPS_PIPELINE_LOG_LEVEL) : LogLevel.valueOf(script.env.getEnvironment().get("QPS_PIPELINE_LOG_LEVEL"))
        if (logLevel.value >= pipelineLogLevel.value && !isParamEmpty(message)){
            script.println "${logLevel}: ${message}"
        }
    }
    
    // returns singleton instance
    public static getInstance() {
        return INSTANCE
    }
    
}
