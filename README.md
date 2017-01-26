# Deployment

* Clone or downloading code
* Edit `src/main/resources/config.properties` file to point to the DB and Wildfly server
* Call `mvn clean install` - this will undeploy the app (if deployed), then after creating artifact, data source will be added to Wildfly server (if doesn't exist yet) and the app deployed
* If everything went well, the app should have been started in `http://<host>:<port>/NewProductManager`
* DB structure is created by Hibernate. To preload some products and categories, execute `mvn clean install -Pload-data`. This will do the same as `mvn clean install`, but also uses Maven SQL plugin to execute statements from `src/main/resources/data.sql`. (__warning__: mvn clean install must be called without profile for the first time to allow Hibernate to create tables.)

### Limitations and problems
* Deployment with Maven works only with Wildfly older than 10. Using version 10, there is a library issue as stated here: http://stackoverflow.com/questions/35533847/wildfly-10-java-lang-classcastexception-org-dom4j-documentfactory-cannot-be-ca. None of the listed solutions worked in this case.
