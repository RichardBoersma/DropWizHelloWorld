# Dropwizzard tutorial om HellowWorld webservice te maken

Project opgebouwd volgens:
 http://dropwizard.io/getting-started.html
Configuratie settings in YAML config file: hello-world.yml

Opstarten server:
cd D:\dev\IdeaProjects\DropWizHelloWorld
java -jar target/DropWizHelloWorld-1.0-SNAPSHOT.jar server hello-world.yml

Test urls
 Versie 1 (alleen @QueryParam())
  http://localhost:8090/hello-world?name=Boersma&firstName=Richard

 Versie 2 (met @PathParam())
  http://localhost:8090/hello-world/999?name=Boersma&firstName=Richard

Resources:
 Drop Wizard docs                                - http://dropwizard.github.io/dropwizard/0.8.0/docs/manual/core.html
 Leuke ASCII art banners maken tbv appl startup  - http://patorjk.com/software/taag/
 RESTful Web Services in Java                    - https://jersey.java.net/
 Building RESTful Web Services with JAX-RS       - http://docs.oracle.com/javaee/6/tutorial/doc/bnayl.html

