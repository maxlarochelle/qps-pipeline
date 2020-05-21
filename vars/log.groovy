/*******************************************************************************
 * Copyright 2013-2020 QaProSoft (http://www.qaprosoft.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
import groovy.transform.Field
import static com.qaprosoft.jenkins.Utils.*
 
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


@Field final LogLevel pipelineLogLevel = this.env.getEnvironment().get("QPS_PIPELINE_LOG_LEVEL")
//def pipelineLogLevel = this.binding.variables.get("QPS_PIPELINE_LOG_LEVEL") ? LogLevel.valueOf(context.binding.variables.QPS_PIPELINE_LOG_LEVEL) : LogLevel.valueOf(this.env.getEnvironment().get("QPS_PIPELINE_LOG_LEVEL"))

public debug(message){
    log(LogLevel.DEBUG, message)
}

public info(message){
    log(LogLevel.INFO, message)
}

public warn(message){
    log(LogLevel.WARN, message)
}

public error(message){
    log(LogLevel.ERROR, message)
}

private void log(LogLevel logLevel, message){
    echo this.dump()
    echo "this.pipelineLogLevel: ${this.pipelineLogLevel}"
    echo "logLevel: ${logLevel}"
    echo "message: ${message}"
    
    if (logLevel.value >= this.pipelineLogLevel.value){
        echo "${logLevel}: ${message}"
    }
}
