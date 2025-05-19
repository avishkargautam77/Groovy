pipeline {
    agent any
    stages {
        stage('Execute Playwright Test') {
                stage('Execute Test') {
                    steps {
                        script {
                            build(job: 'SyntheticMonitoring')
                        }
                    }
                }
        }    
    }        

