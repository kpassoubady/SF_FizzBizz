pipeline {
    agent any

    environment {
        POM_ARTIFACTID = readMavenPom().getArtifactId()
        POM_VERSION = readMavenPom().getVersion()
        POM_PACKAGING = readMavenPom().getPackaging()
        ARTIFACT_VERSION = "${POM_VERSION}.${BUILD_NUMBER}"
    }

    stages {
        stage("Publish Information") {
            steps {
                echo "POM_ARTIFACTID: ${POM_ARTIFACTID}"
                echo "POM_VERSION: ${POM_VERSION}"
                echo "*** BUILD VERSION: ${BUILD_NUMBER}"
                echo "*** ARTIFACT_VERSION: ${ARTIFACT_VERSION}"
            }
        }
    }
}
