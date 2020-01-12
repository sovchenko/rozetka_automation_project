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
      }
    }

    stage('Deploy'){
      echo 'this is deploy stage'
    }
  }
}
