# Stage 0, "build-stage", based on Node.js, to build and compile the frontend
FROM node:16.14.0 as build-stage
WORKDIR /app
COPY package*.json /app/
RUN npm install
COPY ./ /app/
ARG configuration=production
RUN npm run build -- --output-path=./dist/out --configuration $configuration
FROM nginx:1.15
COPY --from=build-stage /app/dist/out/ /usr/share/nginx/html
COPY ./nginx-belssagehr.conf /etc/nginx/conf.d/default.conf