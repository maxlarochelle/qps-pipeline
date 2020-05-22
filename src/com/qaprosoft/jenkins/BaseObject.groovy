package com.qaprosoft.jenkins

import com.qaprosoft.jenkins.pipeline.Configuration
import com.qaprosoft.jenkins.pipeline.tools.scm.ISCM

import com.qaprosoft.jenkins.pipeline.tools.scm.github.GitHub
import com.qaprosoft.jenkins.pipeline.tools.scm.github.ssh.SshGitHub

/*
 * BaseObject to operate with pipeline context and runners
 */
public abstract class BaseObject {
    protected def context
    protected FactoryRunner factoryRunner // object to be able to start JobDSL anytime we need

    protected ISCM scmClient
    protected ISCM scmSshClient

    protected def currentBuild

    //this is very important line which should be declared only as a class member!
    protected Configuration configuration = new Configuration(context)

    public BaseObject(context) {
        this.context = context
        this.scmClient = new GitHub(context)
        this.scmSshClient = new SshGitHub(context)

        this.factoryRunner = new FactoryRunner(context)

        currentBuild = context.currentBuild
    }
}
