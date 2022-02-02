pipeline {

    agent any

    triggers {
        pollSCM '* * * * *'
    }

    stages {


        stage('git') {
            steps {
            
            	sh "echo iniciando pipeline"
            	
                // Get some code from a GitHub repository
                git url: 'https://github.com/MigPalSer/gft-testing-springexample'
		
            }
        }

 stage('gradle clean') {
            steps {
            
            	sh "./gradlew clean"
		
            }
        }

 stage('gradle assemble') {
            steps {
            
            	sh "./gradlew assemble"
		
            }
        }

 stage('gradle test') {
            steps {
            
            	sh "./gradlew check"
		
            }
		
        }

stage('pitest') {
            steps {
            
            	sh "./gradlew pitest"
		
            }
		
        }
    }

post {
        always {
           jacoco( 
      execPattern: 'build/jacoco/*.exec',
      classPattern: 'build/classes',
      sourcePattern: 'src/main/java',
      exclusionPattern: 'src/test*'
)
        }
    }

}
