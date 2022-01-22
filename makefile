build:
	rm -rf dist
	mvn clean compile assembly:single
	mkdir dist
	cp target/*.jar dist
	cp src/Python/ssslasher dist
	pip3 install src/Python/requirements.txt

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
	chmod +x src/Python/ssslasher
	cp src/Python/ssslasher dist
	python -m pip install -r src/Python/requirements.txt
	cp dist/* /usr/local/bin