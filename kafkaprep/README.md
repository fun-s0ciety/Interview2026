##### Install kafka by running below command from root directory
`docker-compose up -d`

##### Run the spring boot application and invoke the below endpoint
```
curl -X POST http://localhost:8080/orders \
     -H "Content-Type: application/json" \
     -d '{"productName": "MacBook Pro", "price": 1999.99}'
```
