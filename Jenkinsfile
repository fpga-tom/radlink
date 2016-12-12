node {
	stage('Checkout') {
		checkout scm
	}
	
	def mvnHome = tool 'mvn3'
	stage('Build') {
		sh "${mvnHome}/bin/mvn clean install"
	}	
	stage('Install') {
   		sh "${mvnHome}/bin/mvn clean install"
	}
}