pipeline {
    agent any

    stages {
        stage('Read Server Properties Information') {
            steps {
                echo 'checkout code'
                git 'https://github.com/kpassoubady/SF_FizzBizz.git'
                echo 'Current server.properties contents'
                sh 'cat ./src/test/resources/server.properties'
                readPropsInfo()
            }
        }
    }
}

private void readPropsInfo() {
    props = readProperties interpolate: true, file: './src/test/resources/server.properties'
    println "URL==>" + props.url
    println "Mode==>" + props.mode
    println "GOOGLE CHROME BROWSER PATH: " + props.gc_browser_path
}
