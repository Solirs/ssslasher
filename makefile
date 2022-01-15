build:
	rm -rf dist
	mvn clean compile assembly:single
	mkdir dist
	cp target/*.jar dist
	cp src/brute.py dist

run:
	mvn clean compile assembly:single
	java -jar target/sshbrutewj.jar

clean:
	rm -rf dist
	rm -rf target