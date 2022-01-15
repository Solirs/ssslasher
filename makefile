build:
	mvn clean compile assembly:single
	mkdir dist
	cp target/*.jar dist
	cp src/brute.py dist

run:
	mvn clean compile assembly:single
	java -jar target/sshbrutewj-1.0-SNAPSHOT-jar-with-dependencies.jar

clean:
	rm -rf dist
	rm -rf target