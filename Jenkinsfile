pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Run Tests') {
      steps {
        catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
          script {
            if (isUnix()) {
              sh 'mvn -q clean test'
            } else {
              bat 'mvn -q clean test'
            }
          }
        }
      }
    }

    stage('Publish Report') {
      steps {
        junit 'target/surefire-reports/*.xml'
      }
    }
  }
}
