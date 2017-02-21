pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        parallel(
          "Build": {
            echo 'Initiate the Build'
            
          },
          "Source Code Checkout": {
            git(url: 'https://github.com/karuppachamy/sample.git', branch: 'master', changelog: true, poll: true)
            
          },
          "Run Unit Tests": {
            sh './gradlew test'
            
          },
          "Build Artifacts": {
            sh './gradlew build'
            
          },
          "Archive Artifacts": {
            archiveArtifacts(artifacts: 'build/**/*.war', fingerprint: true)
       
