package com.qaprosoft.jenkins.pipeline.runner.maven

@Mixin([Maven])
public class QARunner extends TestNGRunner {

    public QARunner(context) {
        super(context)

    }

    public QARunner(context, jobType) {
        this (context)
        this.jobType = jobType
    }


}
