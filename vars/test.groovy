
// See https://github.com/jenkinsci/workflow-cps-global-lib-plugin

// The call(body) method in any file in workflowLibs.git/vars is exposed as a
// method with the same name as the file.
def call() {
    def config = [:]
    println "Starting"
//    log.info "Starting"
//    body.resolveStrategy = Closure.DELEGATE_FIRST
//    body.delegate = config
//    body()
//    stage 'checkout'
//    node {
//        println body.dump()
//        println config.dump()
//        checkout scm
//        stage 'main'
//        docker.image(config.environment).inside {
//            sh config.mainScript
//        }
//        stage 'post'
//        sh config.postScript
//    }
}