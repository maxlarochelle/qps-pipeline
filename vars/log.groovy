import com.qaprosoft.Logger

public debug(message){
    Logger.getInstance().debug(this, message)
}

public info(message){
    Logger.getInstance().info(this, message)
}

public warn(message){
    Logger.getInstance().warn(this, message)
}

public error(message){
    Logger.getInstance().error(this, message)
}