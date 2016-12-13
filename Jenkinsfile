node {
	stage('Checkout') {
		checkout scm
	}
	
	def mvnHome = tool 'mvn3'
	stage('Build') {
		sh "${mvnHome}/bin/mvn clean compile"
	}	
	stage('Install') {
   		sh "${mvnHome}/bin/mvn install"
	}
}