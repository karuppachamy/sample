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
    step1([$class: "JUnitResultArchiver", testResults: "build/**/TEST-*.xml"])
    step2([$class: "JUnitResultArchiver", testResults: "build/**/TEST-*.xml"])
}

def archiveArtifacts() {
    step1([$class: 'ArtifactArchiver', artifacts: 'build/**/*.war'])
    step2([$class: 'ArtifactArchiver', artifacts: 'build/**/*.war'])
}
