pipeline {
    agent any
    tools {
        MAVEN "Maven 3.6.3"
        JDK "jdk8"
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

