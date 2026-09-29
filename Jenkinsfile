pipeline {
    agent any

    tools {
        maven 'Maven_3'
    }

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/mateoaamm/ci-sistema-calificaciones.git'
            }
        }

        stage('Compilar') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Pruebas Unitarias') {
            steps {
                sh 'mvn test'
            }

            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }

        stage('Empaquetar') {
            steps {
                sh 'mvn package -DskipTests'
            }
        }
    }

    post {
        success {
            echo 'Pipeline completado correctamente.'
        }

        failure {
            echo 'El pipeline ha fallado. Revisar Console Output.'
        }
    }
}
