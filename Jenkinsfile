pipeline{
  agent any

  options{
    skipStagesAfterUnstable()
    retry(1)
    disableConcurrentBuilds()
    timeout(time:'15', units: 'SECONDS')
  }

  parameters{
    string(defaultValue: 'maven3.6.3', description: 'maven version', name: 'mavenTool',)
    string(defaultValue:'SDET yomayo', description: '1.4 index of SDET', name: 'SDET')
    booleanParam(defaultValue: false, description: 'test run?', name: 'testRun')
    booleanParam(defaultValue: true, description: 'expression', name: 'EXPRESSION')
  }

  // libraries{
  //   //this directive is used to import shared libraries that is used
  //   //and call them inside the pipeline
  //   // this is very useful in case when we want to use some code that can't be written in Declarative Pipeline syntax
  //   // @ characters - signals which version of lib we want to use
  //   //lib("mylib@master") // latest mylib version from master branch
  // }

  environment{
  //this is optional directive for declaring env variables accessible in the whole pipeline
    USERNAME = 'Serhii Ovchenko'
    PROJECT_NAME = 'rozetka_automation_project'
    ADMIN_CREDS = credentials('admin')
  }

  tools{
    //maven "maven3.6.3"
    maven "${params.mavenTool}"
  }

  triggers{
    //for this trigger webhook on GitHub should be set
    //githubPush()

    cron(30 1 * * 1-5)

    //following trigger starts after finishing 'jobA'  and 'jobB' with SUCCESS status in Jenkins
    // upstream(upstreamProjects: 'jobA,jobB', threshold: hudson.model.Result.SUCCESS)

  }

  stages{

    stage('Build'){

      when{
        branch 'decomp'
      }

      steps{
        sh 'maven compile'
        input message: 'Continue build stage?', ok: "Sure Thing!", submitter: 'admin'
        echo 'This is build stage.'
      }

    }

    stage('Test'){
      when{
        anyOf{
            //stage executes in case at least one of the
            // states are true
            // there is similar construction allOf, in such cases all of the states should be true
            branch 'decomp'
            environment name 'USERNAME', value 'Serhii Ovchenko'
        }

        not{
            //there is also 'not' condition, in such case NONE of the states should be true
            branch 'prod'
        }
      }

      steps{
        //some steps related to the test phase go here
        echo 'this is test stage'
        echo "${USERNAME}"
        echo "${PROJECT_NAME}"
      }
    }

    stage('Deploy'){
      when{
        //any valid groovy expression that returns true
        expression{ return params.EXPRESSION}
      }
      steps{
            echo "Who am I? = ${params.SDET}"
            echo 'this is deploy stage'
      }

      post{
        always {
            echo 'post section inside the Deploy stage'
        }
      }
    }

    post{
        echo 'inside the posts section'
    }
  }
}
