pipeline {
    agent any

    stages {
        stage('Find files within workspace') {
            steps {
                echo 'checkout code'
                git 'https://github.com/kpassoubady/SF_FizzBizz.git'
                echo 'Current directory contents'
                sh "ls -ltRra | grep java"
                displayAllJavaFiles()
            }
        }
    }
}

private void displayAllJavaFiles() {
    def files = findFiles(glob: '**/*.java')
    echo """${files[0].name} ${files[0].path} ${files[0].directory} ${files[0].length} ${files[0].lastModified}"""
    files.each { println "file: $it" }
    files.eachWithIndex { it, i ->  println "$i: ${it.name} -size ${it.length}"}
}
