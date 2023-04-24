# Sogeti

To start application:
java -jar sogeti-0.1.0.jar

Main service: http://localhost:8080/leaserate-calculation
This service calls /get-customer-by-id and /get-car-by-id
Makes calculation and provide full response.

Request JSON example:

{
	"customerId": "0",
	"carId": "0",
	"duration": "60",
	"mileage": "45000",
	"interest": "4.5"
}

Response JSON example:

{
   "name": "John Smith",
   "email": "aaa1@test.com",
   "phoneNumber": "+31619899900",
   "make": "BMW",
   "model": "X5",
   "duration": 60,
   "mileage": 45000,
   "interest": 4.5,
   "nettPrice": 63000,
   "leaserate": 239.72
}

Also next services are available:

/get-car-by-id  - get car information
/add-car - to add a new car
/modify-car-by-id - to modify a existing car
/delete-car-by-id - to delete a car

Same for customers:

/get-customer-by-id
/add-customer
/modify-customer-by-id
/delete-customer-by-id
