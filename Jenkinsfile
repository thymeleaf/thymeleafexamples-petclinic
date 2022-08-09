pipeline {
    agent any
    tools {
        maven 'Maven 3.6.3'
        jdk 'jdk8'
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

