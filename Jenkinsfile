pipeline {
    agent any

    stages {
        stage ("Git Checkout"){
            steps{
            git branch: 'fedi',
            url: 'https://github.com/DorraMk/TpAchat.git'
            }

        }

        stage('Maven Clean') {
            steps {
                echo "Cleaning Project"
                sh 'mvn clean'
            }
        }

        stage('Maven Build') {
            steps {
                echo "Building Project"
                sh 'mvn clean install'
            }
        }

        stage('Unit Test') {
            steps {
                echo "Testing Project"
                sh 'mvn compile validate test'
            }
        }

        stage('Sonarqube Test') {
            steps {
                  echo "Sonarqube Testing "

               

                      sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=bigfk'
                }


            
        }

        stage('Create Package') {
            steps {
                echo "Creating Package"
                sh 'mvn package'
            }
        }

         stage("Publish to Nexus") {
             steps {
        sh 'mvn deploy'
      }

    }


        stage("Build our Image") {
          steps {

              sh 'docker build -t fedix23/devops:new .'

             }
       }

       stage("Push to DockerHub") {
            steps {
                
                        sh 'docker login -u fedix23 -p Solid$-1337'
                        sh 'docker image push fedix23/devops:new'
                }
            }
            

        

        stage("Docker-Compose") {
          steps {
              sh 'docker-compose up -d'
             }


       }

}
}
   
