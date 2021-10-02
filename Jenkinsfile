//pipeline {
 //   agent any
 //   tools {
 //      maven 'M2_HOME'
 //      jdk 'JAVA_HOME'
 //   }
 //   stages {
 //       stage ('Initialize') {
 //           steps {
 //               sh '''
 //                   echo "PATH = ${PATH}"
 //                   echo "M2_HOME = ${M2_HOME}"
 //                   echo "PATH = ${PATH}"
 //                   echo "JAVA_HOME = ${JAVA_HOME}"
 //               '''
 //           }
 //       }
 //
 //       stage ('Build') {
 //           steps {
 //               sh 'mvn -Dmaven.test.failure.ignore=true install' 
 //           }
 //           post {
 //               success {
 //                   junit 'target/surefire-reports/**/*.xml' 
 //               }
 //           }
 //       }
 //   }
//}

pipeline {
    agent any
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

