pipeline {
    agent {label 'agent'}

environment {
        imagename = "projetachat"
        DOCKERHUB_CREDENTIALS=credentials('docker_hub')}

    stages {
      
        stage(" Unit Testing ")
        {
          steps{
            sh'mvn test -Ptest'
        }
     
        }
        stage("SRC Analysis Testing ")
        {
            steps {
                sh 'mvn sonar:sonar -Pcoverage -Dsonar.login=admin -Dsonar.password=mahdi1234'
              
            }
        }
        stage("Build Maven") {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
         stage("Build Docker image") {
            steps {
                sh 'docker build -t mahdigallas/tp_achat_project:latest .'
            }
        }
         stage("Login") {
            steps {
                sh 'docker login -u mahdigallas -p mahdi1234'
            }
        }
        
        stage('Push') {

			steps {
				sh 'docker push mahdigallas/tp_achat_project:latest'
			}
		}  
	 	stage("Start Containers") {
            steps {
                sh 'docker-compose up -d'
            }
        }
    }
     
}