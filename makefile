build:
	rm -rf dist
	mvn clean compile assembly:single
	mkdir dist
	cp target/*.jar dist
	cp src/Python/sshbrutewj dist

run:
	mvn clean compile assembly:single
	java -jar target/sshbrutewj.jar

clean:
	rm -rf dist
	rm -rf target

install:
	rm -rf dist
	mvn clean compile assembly:single
	mkdir dist
	cp target/*.jar dist
	chmod +x src/Python/sshbrutewj 
	cp src/Python/sshbrutewj dist
	cp dist/* /usr/local/bin