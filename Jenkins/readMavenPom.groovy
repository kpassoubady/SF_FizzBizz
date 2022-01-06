pipeline {
    agent any

    environment {
        POM_ARTIFACTID = readMavenPom().getArtifactId()
        POM_VERSION = readMavenPom().getVersion()
        POM_PACKAGING = readMavenPom().getPackaging()
        ARTIFACT_VERSION = "${POM_VERSION}.NP.${BUILD_NUMBER}"
    }

    stages {
        stage("Echo") {
            steps {
                echo "$VERSION"
            }
        }
    }
}
