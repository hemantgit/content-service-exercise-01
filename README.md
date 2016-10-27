## CMiS Route Example
This project shows an example of a route that import files into the Content Services

## Prerequisites
You must have a CXP project configured in your machine before performing this exercise. If you do not have one, please follow the instructions on the following site: https://my.backbase.com/docs/how-to-guides/getting-your-first-launchpad-based-portal-set-up/

### Installation & Configuration

- Open the file src/main/resources/backbase.properties of your *configuration* project and uncomment the following line:

```xml
orchestrator.contenthost.atompath=http://${contentservices.host}:${contentservices.port}/${contentservices.context}/atom
```

It will allow external systems to connect to your server using the CMiS standard.

- Compile the configuration project using:
```xml
mvn clean install
```

- Copy **content-service-exercise-01** into the **services** folder of your project. You can use the git command to clone the project: ```git clone https://github.com/marciofk/content-service-exercise-01.git```

- Include **content-service-exercise-01** module to the build.  Open `services/pom.xml` and add **content-service-exercise-01** in the `<modules>` section: 
	```xml
	    <modules>
	        ...	    
	        <module>content-service-exercise-01</module>
	        ...
	    </modules>
	```	
	Re-compile **services** by executing `mvn clean install` in the **services** folder.
	
- Enable newly created module in the Portalserver application. In the `<dependencies>` section of `webapps/portalserver/pom.xml`, add the following dependency:

	```xml
	    <dependency>
	        <groupId>com.backbase.training</groupId>
	        <artifactId>content-service-exercise-01</artifactId>
	        <version>1.0-SNAPSHOT</version>
	    </dependency>
	```

### Build & Run

- You must restart your portal server if the application is already running. 
- Test the route execution by creating the *outbox* folder into *webapps/portalserver*
- Add some image files into this folder
- Check if the files are correctly imported into the Shared Content of your portal


 





