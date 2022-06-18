#ESTAGIO DE COMPILACAO
FROM gradle:jdk17-alpine AS GRADLE_BUILD_IMAGE

# DEFINE UMA PASTA QUE RECEBERA O CODIGO FONTE
ENV APP_HOME=/app/src
RUN mkdir -p $APP_HOME
WORKDIR $APP_HOME

# COPIA O CODIGO FONTE PARA A PASTA CRIADA
COPY . $APP_HOME



# COMPILA A APLICACAO
RUN gradle wrapper --gradle-version 7.3.3 --distribution-type bin
RUN gradle assemble
RUN rm $APP_HOME/build/libs/*-plain.jar


#ESTAGIO DE EXECUCAO
FROM openjdk:17.0.1
COPY --from=GRADLE_BUILD_IMAGE /app/src/build/libs/*.jar /app/produtos-java-spring.jar
WORKDIR /app
EXPOSE 5001
EXPOSE 5002
ENTRYPOINT ["java","-jar","/app/produtos-java-spring.jar"]