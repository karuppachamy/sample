pipeline {
  agent any
  stages {
    stage('Initiate Build') {
      steps {
        echo 'Initiate Build'
      }
    }
    stage('Source Code Checkout') {
      steps {
        git(url: 'https://github.com/karuppachamy/sample.git', branch: 'master', changelog: true, poll: true)
      }
    }
    stage('Unit Test') {
      steps {
        sh './gradlew test'
      }
    }
    stage('Build Artifacts') {
      steps {
        sh './gradlew clean build'
      }
    }
    stage('Archieve WAR') {
      steps {
        parallel(
          "Archieve WAR": {
            archiveArtifacts 'build/**/*.war'
            
          },
          "Archive Test Results": {
            junit(testResults: 'build/**/TEST-*.xml', keepLongStdio: true)
            
          }
        )
      }
    }
    stage('Artifactory') {
      steps {
        echo 'Begin publish artifactory'
      }
    }
  }
}
