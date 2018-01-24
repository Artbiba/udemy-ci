
de {
   def mvnHome
   stage('Preparation') { // for display purposes
      // Get some code from a GitHub repository
      git 'https://github.com/odedns/petclinic_sdk.git'
      // Get the Maven tool.
      // ** NOTE: This 'M3' Maven tool must be configured
      // **       in the global configuration.           
      mvnHome = tool 'mvn'
   }
   stage('Build') {
      // Run the maven build
      if (isUnix()) {
         sh "'${mvnHome}/bin/mvn' -Dmaven.test.failure.ignore clean package"
      } else {
         bat(/"${mvnHome}\bin\mvn" -Dmaven.test.failure.ignore clean package/)
      }
   }
   stage('Results') {
      junit '**/target/surefire-reports/TEST-*.xml'
      archive 'target/*.jar'
   }
   stage('docker'){
       sh "cd /home/oded/dev/; ./run_docker.sh $BUILD_NUMBER"
   }
   stage('selenium'){
       git 'https://github.com/odedns/udemy-ci.git'
          mvnHome = tool 'mvn'
          sh 'cd SeleniumTest; mvn install'
          sh 'docker stop t1'


   }
}
