pipeline {
    agent any

    stages {
        stage('Read Server Properties Information') {
            steps {
                echo 'checkout code'
                git 'https://github.com/kpassoubady/SF_FizzBizz.git'
                echo 'Current server.properties contents'
                sh 'cat ../src/test/resources/server.properties'
                readRandomInformation()
            }
        }
    }
}

private void readRandomInformation() {
    props = readProperties interpolate: true, file: '../src/test/resources/server.properties'
    println props.url
    println props.mode
    println props.gc_browser_path
}