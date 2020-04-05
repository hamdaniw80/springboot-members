pipeline {
   agent any

   stages {
      stage('Clone Git') {
         steps {
            git 'https://github.com/hamdaniw80/springboot-members.git'
         }
      }
      stage('Build Maven') {
         steps {
            dir('code/strater/'){
                sh "mvn install"
            }
         }
      }
      stage('Build Docker Images') {
         steps {
            sh 'docker build -t springbootmembers:1.0.0 .'
         }
      }
      stage('Run Docker Images') {
         steps {
            sh 'docker run -d -p 4000:4000 springbootmembers:1.0.0'
         }
      }
   }
}
