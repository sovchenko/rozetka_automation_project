pipeline{
  agent any
  options{
    skipStagesAfterUnstable()
  }
  stages{
    stage('Checkout code from GitHub'){
      steps{
        script{
            checkout([$class: 'GitSCM',
                       branches                         : [[name: '*/develop']],
                       doGenerateSubmoduleConfigurations: false,
                       extensions                       : [],
                       submoduleCfg                     : [],
                       userRemoteConfigs                : [[credentialsId: 'c0b16832-ec19-4153-9de3-94b917906b6b',
                       url                              : 'https://github.com/sovchenko/rozetka_automation_project.git']]])
        }
      }
    }

    stage('Running tests on my pet project'){
      steps{
        echo 'this is test stage'
        sh 'mvn clean test'
      }

      post{
        always{
            echo 'this is always'
        }
      }
    }

    stage('Generate allure report'){
      steps{
        echo 'this is deploy stage'

      }
    }
  }
}
