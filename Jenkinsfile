pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        parallel(
          "Build": {
            sh './gradlew build'
            
          },
          "Archive Artifacts": {
            archiveArtifacts 'build/**/*.war'
            
          }
        )
      }
    }
    stage('Push to Artifactory') {
      steps {
        echo 'Pushed to artifactory'
      }
    }
  }
}
