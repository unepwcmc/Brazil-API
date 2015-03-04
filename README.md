# Taxonify-API

This is a [Dropwizard application](http://dropwizard.io), based on the
[JDBI manual page](http://dropwizard.io/manual/jdbi.html).

To use this application follow these steps:

1. mvn package
2. edit database config in *conf/taxonify.yml*
3. Run the server with **java -jar target/taxonifyapi-1.0-SNAPSHOT.jar server conf/taxonify.yml**
4. Point your browser to http://localhost:8282 for info on the API
5. Point your browser to http://localhost:8282/api/taxa for the first 50 species
6. Filter the data by passing on the parameter 'scientificName' in the URL


## Context ##

This project is one of three components of a bigger project:

1. *Back-end application:* A GRAILS app where data collected from various sources will be merged into a taxonomic
database. [Check the repo](https://github.com/unepwcmc/Taxonify).
2. *Front-end application:* A javascript application that will work as the public interface to the taxonomic database of
the project [Check the repo](https://github.com/unepwcmc/especies).
3. *API application:* A Dropwizard application that will serve as the communication layer between the front end and the
back end. This repo.


