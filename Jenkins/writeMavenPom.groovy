pipeline {
    agent any

    stages {
        stage("Change POM Information") {
            steps {
                def pom = readMavenPom file: 'pom.xml'
                pomVersionArray = pom.version.split('\\.')
                pomVersionArray[0] = "${pomVersionArray[0]}".toInteger() + 1
                pom.version = pomVersionArray.join('.')
                writeMavenPom model: pom
            }
        }
    }
}
