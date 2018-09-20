package com.qaprosoft.jenkins.pipeline

import com.qaprosoft.jenkins.pipeline.Configuration
import com.qaprosoft.scm.ISCM

trait IRunner {
	def context
	ISCM scmClient
	Configuration configuration

	abstract void onPush()
	abstract void onPullRequest()
}
