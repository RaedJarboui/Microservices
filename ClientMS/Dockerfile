FROM node:lts-alpine3.14
WORKDIR /src
COPY /eureka-helper/package.json .
COPY /clients/package.json .
RUN npm install
COPY . .
EXPOSE 3939