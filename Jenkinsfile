pipeline{
  agent any
  options{
    skipStagesAfterUnstable()
  }
  stages{
    stage('Build'){
      steps{
        
        echo 'This is build stage.'
      }
    }

    stage('Test'){
      steps{
        echo 'this is test stage'
        sh 'mvn clean test -Dselenide.baseUrl=http://localhost:9090'
      }

      post{
        always{
            echo 'this is always'
        }
      }
    }

    stage('Deploy'){
      steps{
        echo 'this is deploy stage'

      }
    }
  }
}
