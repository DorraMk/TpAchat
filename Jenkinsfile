pipeline {
    agent any

    stages {
        stage ("Git Checkout"){
            steps{
            git branch: 'medMokhtar',
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

                withCredentials([string(credentialsId: 'SonarId', variable: 'Sonar')]) {

                      sh 'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=${Sonar}'
                }


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

                sh "curl http://172.10.0.140:8081/repository/maven-snapshots/tn/esprit/rh/achat/1.0.0-SNAPSHOT/achat-1.0.0-20221117.212748-1.jar --output achat-1.0.0-SNAPSHOT.jar";
            }
        }
        stage("Build our Image") {
          steps {

              sh 'docker build -t mouhamedmokhtar/validation:$BUILD_NUMBER .'

             }
       }

       stage("Push to DockerHub") {
            steps {
                script {

                    withCredentials([string(credentialsId: 'DockerId', variable: 'Docker')]) {
                        sh 'docker login -u mouhamedmokhtar -p ${Docker}'
                        sh 'docker image push mouhamedmokhtar/validation:$BUILD_NUMBER'
                }
            }
            }

        }

        stage('Push Docker Images to Nexus Registry'){
        steps{
            script{
                sh 'docker login -u admin -p adminadmin http://172.10.0.140:8087/repository/docker/'
        sh 'docker push http://172.10.0.140:8081/repository/docker/nexusdocker}'
        sh 'docker rmi $(docker images --filter=reference="http://172.10.0.140:8087/repository/docker/nexusdocker" -q)'
            }
        }
        }
         stage('Pull image from Nexus') {
                    steps {
                        script{
                                sh "docker pull http://172.10.0.140:8087/repository/docker/nexusdocker:latest"
                            }

                    }
                }
        stage("Docker-Compose") {
          steps {
              sh 'docker-compose up -d'
             }


       }


     }
}