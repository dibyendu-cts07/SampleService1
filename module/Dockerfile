FROM java:8-jre
WORKDIR usr/src
ENV MYSQL_DATABASE=moviedb
ENV MYSQL_CI_URL=jdbc:mysql://localhost:3306/movieDb?useSSL=false
ENV MYSQL_USER=app-root
ENV MYSQL_PASSWORD=root123
ADD ./target/MovieCruiser-UserServices-489706-0.0.1-SNAPSHOT.jar /usr/src/MovieCruiser-UserService.jar
EXPOSE 8081
ENTRYPOINT ["java","-jar", "MovieCruiser-UserService.jar"]
