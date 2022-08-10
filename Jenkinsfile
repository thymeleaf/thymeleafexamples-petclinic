pipeline {
    agent any
    tools {
        Maven 'maven 3'
        Jdk 'jdk 8'
    }    
    stages {
        stage ('Build') {
            steps {
                sh 'mvn -Dmaven.test.failure.ignore=true install' 
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml' 
        
		        }
		  }
	}
    }
}

