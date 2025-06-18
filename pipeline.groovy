pipeline {
    agent any
    parameters {
        booleanParam(name: 'ENABLE_SCHEDULE', defaultValue: true, description: 'Enable automatic scheduling')
    }

    triggers {
        cron(params.ENABLE_SCHEDULE ? 'H/1 * * * *' : '')
    }

    stages {
        stage('Execute Playwright Test') {
            steps {
                script {
                    build(job: 'SyntheticMonitoring')
                }
            }
        }
    }
}
