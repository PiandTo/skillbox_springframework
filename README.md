# skillbox_springframework

# Lesson 1 
	To run APP:
	1. Go to directory lesson1/console
	2. Run mvn spring-boot:run
	3. To change Profile to INIT mode go application.properties and commit/uncommit line spring.profiles.active=init

	App Interface: 
		Choose what to do and press ENTER

		[1] - add NEW contact
		[2] - show ALL contacts
		[3] - DELETE contact
		[4] - SAVE contact in file

# Lesson 2
	To run APP:
	1. Go to directory lesson2/lesson2
	2. Run './mvnw install -DskipTests' to build JAR
	3. Build image 'docker build -t shell .'
	4. Run image 'docker run shell'
	5. To change Profile to INIT mode go application.properties and commit/uncommit line spring.profiles.active=init

	App Interface: 
	Choose what to do and press ENTER

	ADD - add NEW contact
	PRINT - show ALL contacts
	DELETE - DELETE contact по GUID
	DELETEALL - DELETE ALL

# Lesson 3
	Optional: You need Tailwind CSS and PostCss
	
	To run APP
 	1. Go to directory lesson3/thymeleafapp
  	2. Run "mvn verify -DskipTests" to build JAR
   	3. Run "mvn spring-boot:run"
    	4. To test use port 8081 (localhost:8081/contact)
