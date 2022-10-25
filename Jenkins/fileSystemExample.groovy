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
                script {
                    def directories = getDirectories("$WORKSPACE")
                    echo "$directories"
                }
            }
        }
    }
}

@NonCPS
def getDirectories(path) {
    def dir = new File(path)
    def dirs = []
    dir.traverse(type: groovy.io.FileType.DIRECTORIES, maxDepth: -1) { d ->
        dirs.add(d) 
    }
    return dirs
}
