node {
    stage "Source Code Checkout"
    git url: "https://github.com/karuppachamy/sample.git"

    stage 'Run Unit Tests'
    sh "./gradlew test"

    stage 'Generate Test Results'
    archiveUnitTestResults()
    
    stage 'Build Artifacts'
    sh "./gradlew clean build"  
    
    stage 'Archive Artifacts'
    archiveArtifacts()
}

def archiveUnitTestResults() {
    step([$class: "JUnitResultArchiver", testResults: "build/**/TEST-*.xml"])
}

def archiveArtifacts() {
    step([$class: 'ArtifactArchiver', artifacts: 'build/**/*.war'])
}
