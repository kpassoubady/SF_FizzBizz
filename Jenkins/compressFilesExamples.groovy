pipeline {
    agent any

    stages {
        stage('Compress Workspace files') {
            steps {
                echo 'checkout code'
                git 'https://github.com/kpassoubady/SF_FizzBizz.git'
                echo 'zip src folder'
                zip glob: "src/**", zipFile: 'sourceCode.zip', overwrite: true
                echo 'tar jenkins folder'
                tar glob: "jenkins/**.groovy", file: 'sourceCode.gz', overwrite: true
                echo 'unzip the zip/tar files'
                unzip  zipFile: 'sourceCode.zip', dir: 'javaCode'
                untar  file: 'jenkins.gz', dir: 'groovyScripts'
            }
        }
    }
}
