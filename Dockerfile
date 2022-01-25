#APLICACION DE SPRING EN JDK

FROM openjdk:18-ea-11-jdk-alpine3.15
EXPOSE 8080
WORKDIR opt/springapp
# TODO solucionar esto, ya que gradle genera 2 jar distintos y no se puede seleccionar simplemente el jar que haya en la carpeta. Probablemente haya alguna opcion en el assemble para que sólo genere 1.
COPY build/libs/holamundospring-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","./app.jar"]
