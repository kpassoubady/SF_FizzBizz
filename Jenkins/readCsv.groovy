pipeline {
    agent any

    stages {
        stage('Read CSV File Information') {
            steps {
                echo 'checkout code'
                git 'https://github.com/kpassoubady/SF_FizzBizz.git'
                echo 'Current CSV File contents'
                sh 'cat ../data/personal_loan_data.csv'
                readCsvData()
            }
        }
    }
}

private void readCsvData() {
    loan_info = readCSV file: '../data/personal_loan_data.csv'
    for (int i = 0; i < loan_info.size(); i++) {
        row = ''
        for (int j = 0; j <loan_info[0].size(); j++) {
            row +=  loan_info[i][j] + ", "
        }
        println row
    }
}
