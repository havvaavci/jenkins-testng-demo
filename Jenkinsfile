pipeline {
  agent any

  options {
    timestamps()
  }

  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }

    stage('Run Tests') {
      steps {
        sh 'mvn -q clean test'
      }
    }

    stage('Publish Report') {
      steps {
        junit 'target/surefire-reports/*.xml'
      }
    }
  }

  post {
    always {
      archiveArtifacts artifacts: 'target/surefire-reports/**', allowEmptyArchive: true
    }
  }
}
