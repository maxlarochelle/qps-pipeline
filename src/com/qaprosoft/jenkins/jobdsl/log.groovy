package com.qaprosoft.jenkins.jobdsl

import com.qaprosoft.Logger

class log implements Serializable {
    
    def script

    log(script) {
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