pipeline {
    agent any

    stages {
        stage('Read Random Yml Information') {
            steps {
                echo 'checkout code'
                git 'https://github.com/kpassoubady/SF_FizzBizz.git'
                echo 'Current Yaml contents'
                sh 'cat src/test/resources/randomInfo.yml'
                readRandomInformation()
            }
        }
    }
}

private void readRandomInformation() {
    datas = readYaml file: 'src/test/resources/randomInfo.yml'
    doe = datas.doe
    frenchHens = datas.frenchHens
    turtleDoves = datas.turtleDoves
    println datas
    println doe
    print frenchHens
    print turtleDoves
    println datas.applications.service2.serviceNamespace
}
