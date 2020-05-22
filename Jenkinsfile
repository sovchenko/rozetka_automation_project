pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    triggers {
        // build is made every day from Monday to Friday
        // at 10:24 am
        cron('24 10 * * 1-5')
    }

    stages {
        stage('Checkout code from GitHub') {
            steps {
                script {
                    checkout([$class                           : 'GitSCM',
                              branches                         : [[name: '*/develop']],
                              doGenerateSubmoduleConfigurations: false,
                              extensions                       : [],
                              submoduleCfg                     : [],
                              userRemoteConfigs                : [[credentialsId: 'c0b16832-ec19-4153-9de3-94b917906b6b',
                                                                   url          : 'https://github.com/sovchenko/rozetka_automation_project.git']]])
                }
            }
        }
        stage('install chrome') {
            steps {
                script {
//                   sh "curl -sSLo /home/jenkins/chrome.deb https://github.com/webnicer/chrome-downloads/raw/master/x64.deb/google-chrome-stable_83.0.4103.61-1_amd64.deb"
//                   sh "sudo dpkg -i /home/jenkins/chrome.deb"
                    sh "google-chrome --version"
                }
            }
        }

        stage('Running tests on my pet project') {
            steps {
                script {
                    wrap([$class: 'Xvfb',
                          debug : true,
                          screen: '1920x1080x24']) {
                        echo 'this is test stage'
                        sh 'mvn clean test'
                    }
                }

            }

            post {
                always {
                    echo 'this is always'
                }
            }
        }

        stage('Deploy') {
            steps {
                echo 'deploy has been done'
            }
        }
    }
    post {
        always {
            echo 'Allure always'
            allure([
                    includeProperties: false,
                    reportBuildPolicy: 'ALWAYS',
                    jdk              : '',
                    results          : [[path: 'allure-results']]
            ])
        }
    }
}