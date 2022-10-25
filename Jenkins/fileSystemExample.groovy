pipeline {
    agent {
        label 'unix'
    }

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
                    echo 'display timestamp of an existing file'
                    sh 'ls -ltra ../src/test/resources/server.properties'
                }
                echo "display workspace directories"
                
                dir("$WORKSPACE") {
                   script {
                       def files = findFiles() 
    
                       files.each { 
                          file -> 
                          if(file.directory) {
                            echo "This is directory: ${file.name} "
                          }
                       }
                    }
                }
            }
        }
    }
}
