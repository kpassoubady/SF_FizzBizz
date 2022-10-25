pipeline {
    agent any

    stages {
        stage('Read CSV File Information') {
            steps {
                echo 'checkout code'
                git 'https://github.com/kpassoubady/SF_FizzBizz.git'
                echo 'Current CSV File contents'
                sh 'cat ./data/personal_loan_data.csv'
                readCsvData()
            }
        }
    }
}

private void readCsvData() {
    loanInfo = readCSV file: './data/personal_loan_data.csv'
    for (int i = 0; i < loanInfo.size(); i++) {
        row = ''
        for (int j = 0; j <loanInfo[0].size(); j++) {
            row +=  loanInfo[i][j] + ", "
        }
        println row
    }
}
