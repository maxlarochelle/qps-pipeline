package com.qaprosoft.jenkins.jobdsl

import com.qaprosoft.Logger

class Logger implements Serializable {
    
    def script

    Logger(script) {
        this.script = script
    }

    public debug(message){
        Logger.getInstance().debug(script, message)
    }

    public info(message){
        Logger.getInstance().info(script, message)
    }

    public warn(message){
        Logger.getInstance().warn(script, message)
    }

    public error(message){
        Logger.getInstance().error(script, message)
    }
}