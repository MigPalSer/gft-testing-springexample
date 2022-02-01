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



    }
}
