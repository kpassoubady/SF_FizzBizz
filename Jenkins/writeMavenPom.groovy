pipeline {
    agent any

    stages {
        stage('Change POM Information') {
            steps {
                echo "checkout code"
                git 'https://github.com/kpassoubady/SF_FizzBizz.git'
                echo "Current Maven Build version"
                sh 'cat pom.xml'
                changeVersion()
                echo "After Changing Maven Build version"
                sh 'cat pom.xml'
            }
        }
    }
}

private void changeVersion() {
    pom = readMavenPom file: 'pom.xml'
    pomVersionArray = pom.version.split('\\.')
    pomVersionArray[0] = "${pomVersionArray[0]}".toInteger() + 1
    pom.version = pomVersionArray.join('.')
    writeMavenPom model: pom
}
