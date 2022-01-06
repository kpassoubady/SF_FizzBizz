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
    frenchHens = info.frenchHens
    turtleDoves = info.turtleDoves
    println info
    println doe
    print frenchHens
    print turtleDoves
}
