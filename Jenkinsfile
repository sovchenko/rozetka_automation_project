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
        //some steps related to the test phase go here
        echo 'this is test stage'
      }
    }

    stage('Deploy'){
      steps{
            echo 'this is deploy stage'
      }
    }
  }
}
