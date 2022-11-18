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

     stage('Pull artifact from Nexus'){
            steps{
                
                sh "curl http://192.168.56.0:8081/repositoryt/maven-snapshots/com/esprit/examen/tpAchatProject/1.0.0-SNAPSHOT/tpAchatProject-1.0.0-20221118.130348-1.jar --output tpAchatProject-1.0.jar";
            }}
      
        stage("Build our Image") {
          steps {

              sh 'docker build -t fedix23/devops:latest .'

             }
       }

       stage("Push to DockerHub") {
            steps {
                
                        sh 'docker login -u fedix23 -p Solid1337'
                        sh 'docker image push fedix23/devops:latest'
                }
            } 
            
 stage('Push Docker Images to Nexus Registry'){
steps{
    script{
        sh 'docker login -u admin -p bigfk http://192.168.56.0:8082/repository/docker/'
sh 'docker push http://192.168.56.0:8082/repository/docker/nexusdocker}'
sh 'docker rmi $(docker images --filter=reference="http://192.168.56.0:8082/repository/docker/nexusdocker" -q)'
    }
}
}
 stage('Pull image from Nexus') {
            steps {
                script{
                        sh "docker pull 192.168.56.0:8082/repository/docker/nexusdocker:latest"
                    }
                
            }
        } 
        

        stage("Docker-Compose") {
          steps {
              sh 'docker compose up -d'
             }


       }

}
}
   
