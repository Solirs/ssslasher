build:
	mvn clean compile assembly:single

run:
	mvn clean compile assembly:single
	java -jar target/sshbrutewj-1.0-SNAPSHOT-jar-with-dependencies.jar