pipeline{
  agent any
  options{
    skipStagesAfterUnstable()
  }
  triggers{
    cron('45 22 * * *')
  }
  stages{
    stage('Build'){
      steps{
        echo 'This is build stage.'
        input
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

    posts{
        echo 'inside the posts section'
    }
  }
}
