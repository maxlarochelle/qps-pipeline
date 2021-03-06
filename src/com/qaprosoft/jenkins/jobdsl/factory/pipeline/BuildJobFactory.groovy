package com.qaprosoft.jenkins.jobdsl.factory.pipeline

import groovy.transform.InheritConstructors

@InheritConstructors
public class BuildJobFactory extends PipelineFactory {

    def host
    def repo
    def organization
    def branch
    def scmUrl


    public BuildJobFactory(folder, pipelineScript, jobName, host, organization, repo, branch, scmUrl) {
        this.name = jobName
        this.folder = folder
        this.pipelineScript = pipelineScript
        this.host = host
        this.repo = repo
        this.organization = organization
        this.branch = branch
        this.scmUrl = scmUrl
    }

    def create() {
        logger.info("BuildJobFactory->create")

        def pipelineJob = super.create()

        pipelineJob.with {

            parameters {
                configure stringParam('maven_goals', '-U clean install', "Maven goals to build the project")
                configure booleanParam('fork', false, "Reuse forked repository for ${repo}.")
                configure stringParam('branch', branch, "SCM repository branch to build against")
                configure addHiddenParameter('repo', '', repo)
                configure addHiddenParameter('GITHUB_HOST', '', host)
                configure addHiddenParameter('GITHUB_ORGANIZATION', '', organization)
                configure addExtensibleChoice('BuildPriority', "gc_BUILD_PRIORITY", "Priority of execution. Lower number means higher priority", "3")
                configure stringParam('email_list', "", 'List of Users to be emailed after the test')
            }

        }

        return pipelineJob
    }
}