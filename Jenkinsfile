node {
    stage 'Lets begin'
    echo 'Hello World'
    
    stage "Checkout"
    git url: "https://github.com/karuppachamy/sample.git"
    
    stage 'gradle Build'
    sh "./gradlew clean build"
    
    stage 'Gradle Test'
    sh "./gradlew test"
    
    stage 'Collect Result'
    archiveUnitTestResults()
}

def archiveUnitTestResults() {
    step([$class: "JUnitResultArchiver", testResults: "build/**/TEST-*.xml"])
}
