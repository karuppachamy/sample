pipeline {
  agent any
  stages {
    stage('Build') {
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
        parallel(
          "Build Artifacts": {
            sh './gradlew clean build'
            
          },
          "Archive Build Artifacts": {
            archiveArtifacts(artifacts: 'build/**/*.war', fingerprint: true)
            
          },
          "Archive Test Results": {
            junit 'build/**/TEST-*.xml'
            
          }
        )
      }
    }
    stage('Artifactory') {
      steps {
        echo 'Pushing the artifact to Artifactory'
      }
    }
  }
}
