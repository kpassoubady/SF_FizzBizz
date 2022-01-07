pipeline {
    agent any

    stages {
        stage('Read JSON file Information') {
            steps {
                echo 'checkout code'
                git 'https://github.com/kpassoubady/SF_FizzBizz.git'
                echo 'Current JSON contents'
                sh 'cat .groovylintrc.json'
                readRandomInformation()
            }
        }
    }
}

private void readRandomInformation() {
    props = readJSON file: '.groovylintrc.json'
    props.each { key, value -> echo "Walked through key $key and value $value" }

    println props['extends']
    println props['rules']
}
