pipeline{
  agent any
  options{
    skipStagesAfterUnstable()
  }
  stages{
    stage('Checkout code from GitHub'){
      steps{
        echo 'Checking out code from VCS.'
        checkout([$class: 'GitSCM', branches: [[name: '*/develop']],
            userRemoteConfigs: [[url: 'https://github.com/sovchenko/rozetka_automation_project.git']]])

      }
    }

    stage('Running tests on my pet project'){
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
