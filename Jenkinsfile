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
    
    stage('SonarQube analysis') {
    // requires SonarQube Scanner 2.8+
     def scannerHome = tool 'SonarQube Scanner 2.8';
      withSonarQubeEnv('SonarCube') {
      sh "${scannerHome}/bin/sonar-scanner"
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
    stage('Artifactory Publish') {
      steps {
        sh './gradlew publish'
      }
    }
  }
}
