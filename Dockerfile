FROM amazoncorretto:11
RUN mkdir /app


# SET VARIABLES
ARG HOST
ARG PORT
ARG DB_URL
ENV DB_URL=$DB_URL
ENV HOST=$HOST
ENV PORT=$PORT



COPY ./build/libs/url-shortener-all.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]