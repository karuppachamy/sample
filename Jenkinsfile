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
        parallel(
          "Unit Test": {
            sh './gradlew test'
            
          },
          "Archive Results": {
            junit(testResults: 'build/**/TEST-*.xml', healthScaleFactor: '2')
            
          }
        )
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
