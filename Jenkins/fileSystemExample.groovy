pipeline {
    agent any

    stages {
        stage('File System Commands Demo') {
            steps {
                tee ('data/output.txt') {
                    echo 'checkout code'
                    git 'https://github.com/kpassoubady/SF_FizzBizz.git'
                    echo 'create a new file'
                    touch 'data/version'
                    echo 'update timestamp of an existing file'
                    touch '../src/test/resources/server.properties'
                }
            }
        }
    }
}
