pipeline {
  agent any

  stages {
    stage('Checkout') {
      steps { checkout scm }
    }

    stage('Verify Maven') {
      steps {
        script {
          if (isUnix()) {
            sh 'mvn -v'
          } else {
            bat 'mvn -v'
          }
        }
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

    stage('Debug Reports Folder') {
      steps {
        script {
          if (isUnix()) {
            sh 'ls -la target || true'
            sh 'ls -la target/surefire-reports || true'
          } else {
            bat 'dir target'
            bat 'dir target\\surefire-reports'
          }
        }
      }
    }

    stage('Publish Report') {
      steps {
        // daha geniş pattern: nerede olursa bulsun
        junit testResults: '**/target/surefire-reports/*.xml', allowEmptyResults: true
      }
    }
  }
}

