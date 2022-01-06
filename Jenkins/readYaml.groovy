pipeline {
    agent any

    stages {
        stage('Read Random Yml Information') {
            steps {
                echo 'checkout code'
                git 'https://github.com/kpassoubady/SF_FizzBizz.git'
                echo 'Current Yaml contents'
                sh 'cat ../src/test/resources/randomInfo.yml'
                readRandomInformation()
            }
        }
    }
}

private void readRandomInformation() {
    info = readYaml file: '../src/test/resources/randomInfo.yml'
    doe = info.doe
    callingBirds = info.calling-birds
    xmas = info.xmas-fifth-day
    print xmas
    print doe
}
