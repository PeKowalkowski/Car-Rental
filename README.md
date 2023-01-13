Car Rental  
===
It is an application for managing car rental.
The application allows users to register as
private person, employee and company, and each
users have individual access to each page by
hierarchy :

1.Admin.

2.Employee.

3.User (Person or Company).

After logging in, the user can add a car rental company,
branch and car, and then assign the branch to the car rental
or a car to a branch. Each user can view a list of
available cars and make a reservation. All methods of adding
and method of close reservation are for ADMIN and EMPLOYEE only,
while the delete and edit methods are for ADMIN only.

All the paths to run the methods, along with descriptions,
are below and are written for the PostMan test environment.

Database properties (MySql Workbench) : 

spring.datasource.url= database path

spring.datasource.username= database username

spring.datasource.password= database password

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5InnoDBDialect

spring.jpa.hibernate.ddl-auto=update

logging.level.org.hibernate.SQL=DEBUG

logging.level.org.hibernate.type=TRACE

spring.main.allow-circular-references=true

server.error.whitelabel.enabled=false



## Entities : 
#### 1. CarRental
#### 2. Branch
#### 3. User(Employee, Person, Company)
#### 4. Car
#### 5. Address
#### 6. Reservation


## Endpoints :
### * CarRental 
#### 1. Add car rental
```
Http request in Postman : 
@PostMapping     http://localhost:8080/api/car_rentals

Postman default body in JSON : 
{
        "name": "car rental name",
        "website": "car rental website name",
        "phoneNumber": "car rental phone number",
        "owner": "car rental owner name",
}
```
#### 2. Get car rentals
````
Http request in Postman : 
@GetMapping      http://localhost:8080/api/car_rentals
````
#### 3. Get car rental
````
Http request in Postman : 
@GetMapping      http://localhost:8080/api/car_rentals/id
````
#### 4. Delete car rental
````
Http request in Postman : 
@DeleteMapping      http://localhost:8080/api/car_rentals/id
````
#### 5. Update car rental
````
Http request in Postman : 
@PutMapping      http://localhost:8080/api/car_rentals/id

Postman default body in JSON : 
{
        "name": "new car rental name",
        "website": "new car rental website name",
        "phoneNumber": "new car rental phone number",
        "owner": "new car rental owner name",
}
````

### * Branch
#### 1. Add branch
````
Http request in Postman : 
@PostMapping      http://localhost:8080/api/branches

Postman default body in JSON : 

{
    
        "name": "branch name",
        "branchAddress": {
            "city": "branch city name",
            "street": "branch street name",
            "zipCode": "zip code of city",
            "country": "branch country name"
        }
}
````
#### 2. Get branches
````
Http request in Postman : 
@GetMapping      http://localhost:8080/api/branches
````
#### 3. Get branch
````
Http request in Postman : 
@GetMapping      http://localhost:8080/api/branches/id
````
#### 4. Delete branch
````
Http request in Postman : 
@DeleteMapping      http://localhost:8080/api/branches/id
````
#### 5. Update branch
````
Http request in Postman : 
@PutMapping      http://localhost:8080/api/branches/id

{
    
        "name": "new branch name",
        "branchAddress": {
            "city": "new branch city name",
            "street": "new branch street name",
            "zipCode": "new zip code of city",
            "country": "new branch country name"
        }
}
````
#### 6. Add branch to car rental
````
Http request in Postman : 
@PutMapping      http://localhost:8080/api/branches/branchId/carRental/carRentalId
````
### * User : 

1. ### Employee
#### * Register employee
````
Http request in Postman :
@PostMapping      http://localhost:8080//api/registration/registerEmployee

Postman default body in JSON : 

{
        "firstname": "employee name",
        "lastname": "employee last name",
        "login": "employee login",
        "password": "employee password",
        "address": {
            "city": "employee city name",
            "street": "employee street name",
            "zipCode": "employee zip code",
            "country": "employee country"
        }
}
````
#### * Get employees
````
@GetMapping      http://localhost:8080/api/employees
````
#### * Get employee
````
@GetMapping      http://localhost:8080//api/employees/id
````
#### * Delete employee
````
@DeleteMapping      http://localhost:8080/api/employees/{id}
````
#### * Update employee
````
Http request in Postman :
@PutMapping       /api/employees/id

Postman default body in JSON :
* Field of employee's role should be written in capital letters : 
(EMPLOYEE, USER or ADMIN).

{
        "firstname": "new employee name",
        "lastname": "new employee last name",
        "login": new "employee login",
        "password": "new employee password",
        "address": {
            "city": "new employee city name",
            "street": "new employee street name",
            "zipCode": "new employee zip coe",
            "country": "new employee country"
        }
        "role": "new employee role"
}
````
### * Add employee to branch
````
@PutMapping      http://localhost:8080/api/employees/employeeId/branch/branchId
````
2. ### Person

#### * Register person
````
Http request in Postman :
@PostMapping      http://localhost:8080/api/registration/registerPerson

Postman default body in JSON : 

{
        "firstname": "person name",
        "lastname": "person last name",
        "login": "person login",
        "password": "person password",
        "address": {
            "city": "person city name",
            "street": "person street name",
            "zipCode": "person zip code",
            "country": "person country"
        }
}
````
#### * Get persons
````
@GetMapping      http://localhost:8080/api/persons
````
#### * Get person
````
@GetMapping      http://localhost:8080/api/persons/id
````
#### * Delete person
````
@DeleteMapping      http://localhost:8080/api/persons/id
````
#### * Update person
````
Http request in Postman :
@PutMapping       http://localhost:8080/api/persons/id

Postman default body in JSON :
* Field of person's role should be written in capital letters : 
(EMPLOYEE, USER or ADMIN).

{
        "firstname": "new person name",
        "lastname": "new person last name",
        "login": new "person login",
        "password": "new person password",
        "address": {
            "city": "new person city name",
            "street": "new person street name",
            "zipCode": "new person zip code",
            "country": "new person country"
        }
        "role": "new person role"
}

````
3. ### Company

#### * Register company
````
Http request in Postman :
@PostMapping      http://localhost:8080/api/registration/registerCompany

Postman default body in JSON : 

{
        "firstname": "company name",
        "lastname": "company last name",
        "login": "company login",
        "password": "company password",
        "address": {
            "city": "company city name",
            "street": "company street name",
            "zipCode": "company zip code",
            "country": "company country"
        }
}
````
#### * Get companies
````
@GetMapping      http://localhost:8080/api/companies
````
#### * Get company
````
@GetMapping      http://localhost:8080//api/companies/id
````
#### * Delete company
````
@DeleteMapping      http://localhost:8080/api/companies/id
````
#### * Update company
````
Http request in Postman :
@PutMapping       http://localhost:8080/api/companies/id

Postman default body in JSON :
* Field of company's role should be written in capital letters : 
(EMPLOYEE, USER or ADMIN).

{
        "firstname": "new company name",
        "lastname": "new company last name",
        "login": new "company login",
        "password": "new company password",
        "address": {
            "city": "new company city name",
            "street": "new compamy street name",
            "zipCode": "new company zip code",
            "country": "new company country"
        }
        "role": "new company role"
}
````
### * Car 
#### 1. Add car
````
Http request in Postman :
@PostMapping      http://localhost:8080/api/cars

Postman default body in JSON :
* Field of car's availability should be written in capital letters : 
(AVAILABLE or NOAVAILABLE).
* Field of car's body type should be written in capital letters : 
(SEDAN,WAGON, SUV, HATCHBACK).
{
        "brand": "car brand",
        "model": "car model",
        "year": "car year",
        "color": "car color",
        "mileage": "car mileage",
        "price": "car price",
        "carBodyType": "car body typ",
        "status": "car status",
}
````
#### 2. Get cars
````
@GetMapping      http://localhost:8080/api/cars
````
#### 3. Get car
````
@GetMapping      http://localhost:8080/api/cars/id
````
#### 4. Delete car
````
@DeleteMapping      http://localhost:8080/api/cars/id
````
#### 5. Update car
````
Http request in Postman :
@PutMapping      http://localhost:8080/api/cars/id

Postman default body in JSON :
* Field of car's availability should be written in capital letters : 
(AVAILABLE or NOAVAILABLE).
* Field of car's body type should be written in capital letters : 
(SEDAN,WAGON, SUV, HATCHBACK).
{
        "brand": "new car brand",
        "model": "new car model",
        "year": "new car year",
        "color": "new car color",
        "mileage": "new car mileage",
        "price": "new car price",
        "carBodyType": "new car body typ",
        "status": "new car status",
}
````
#### 6. Add car to branch
````
@PutMapping      http://localhost:8080/api/cars/carId/branch/branchId
````
### * Address - Tworzony jest automatycznie wraz z użytkownikiem 
#### 1. Get addresses
````
@GetMapping      http://localhost:8080/api/addresses
````
#### 2. Get address
````
@GetMapping      http://localhost:8080/api/addresses/id
````
### * Reservation 
#### 1. Add person reservation
````
@PostMapping http://localhost:8080/api/reservations/carId/personId/personReservations

Postman default body in JSON :
* Field of reservation date is automatic.
{
    "reservationDate" : "automatic",
    "car" : "inscribed in the path as `carId`.",
    "rental" : {
        "commentsToRental" : "comments to rental",
        "surcharge" : "rental surcharge"
    },
    "returnCar" : {
        "returnDate" : "rrrr-mm-ddThh:mm:ss",
        "opinions" : "reeturn opinion"
    },
    "person" : "inscribed in the path sa `personId`,
    "name"  : 'Automatically set 'User's reservation with PESEL'  
}
````
#### 2. Add company reservation
````
@PostMapping http://localhost:8080/api/reservations/carId/companyId/companyReservations

Postman default body in JSON :
* Field of reservation date is automatic.
{
    "reservationDate" : "automatic",
    "car" : "inscribed in the path as `carId`.",
    "rental" : {
        "commentsToRental" : "comments to rental",
        "surcharge" : "rental surcharge"
    },
    "returnCar" : {
        "returnDate" : "rrrr-mm-ddThh:mm:ss",
        "opinions" : "reeturn opinion"
    },
    "person" : "inscribed in the path as `reservationId`,
    "name"  : 'Automatically set 'Company's reservation with NIP...'  
}
````
#### 3. Get reservations
````
@GetMapping      http://localhost:8080/api/reservations
````
#### 4. Get reservation
````
@GetMapping      http://localhost:8080/api/reservations/{id}
````
#### 5. Close reservation
````
@PutPapping      http://localhost:8080/api/reservations/reservationId/carId
* `reservationId` included in the path, automatically sets the reservation's
   status from ACTIVE to NOACTIVE.
* `carId` included in the path, automatically sets the car's
   status from NOAVAILABLE to AVAILABLE.
````




