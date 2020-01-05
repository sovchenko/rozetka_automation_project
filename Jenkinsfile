pipeline{
  agent any
  options{
    skipStagesAfterUnstable()
  }
  stages{
    stage('Build'){
      steps{
        // steps that should be performed during build phase

        // sh - is a pipeline step that executes give shell command sh 'shell-command'
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
