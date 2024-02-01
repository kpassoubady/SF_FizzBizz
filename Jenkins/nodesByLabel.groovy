pipeline {
    agent any

    stages {
        stage('Nodes By Label') {
            steps {
                nodesByLabel("${WHICH_NODE}")
            }
        }
    }
}
