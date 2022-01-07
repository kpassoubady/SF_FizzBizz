pipeline {
    agent any

    stages {
        stage('Nodes By Label') {
            steps {
                nodesByLabel('master')
            }
        }
    }
}
