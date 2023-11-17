pipeline {
   agent any   
   stages {
        stage('Checkout') {
            steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/main']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[credentialsId: 'de9dc15b-f56c-455e-8633-02013d8680f1', url: 'https://github.com/dhanyarakesh/SeleniumDemo.git']]])
            }          
        }
      stage("Maven Build"){
            steps{
                bat 'mvn clean install'
            }
        }
    }
}
