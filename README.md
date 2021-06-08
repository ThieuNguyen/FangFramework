SIMPLE API TESTING
----
  _Just a simple webservice for testing api._

## Get employee by id
### Request
 
`GET /employee-webservice/{id}` 
  
**Required:**
 
   `id: Employee Id`

### Response

	
`HTTP/1.1 200 OK`

`Content-Type: application/json;charset=UTF-8`
    
    {
        "id": "60bd964b4ce48c43a2ada7c4",
        "age": 30,
        "name": "Jack",
        "address": {
            "city": "NY",
            "country": "USA",
            "street": "MHKC",
            "zipCode": 38371
        },
        "salary": 5000.0
    }
 
### Error
`404 NOT FOUND`
`emplooyee is not exist`
  
## Get all employees
### Request
`GET /employee-webservice/`
### Success Response
`200 SUCCESS: list all employees`

## Add new employees
### Request
`POST /employee-webservice/`

Request Body
```{
   	"age": 30,
   	"name": "Jack",
   	"address": {
   		"city": "NY",
   		"country": "USA",
   		"street": "MHKC",
   		"zipCode": 38371
   	},
   	"salary": 5000.0
   }
```

### Response: 
`HTTP/1.1 200 Created`

```{
       "id": "60bd964b4ce48c43a2ada7c4",
       "age": 30,
       "name": "Jack",
       "address": {
           "city": "NY",
           "country": "USA",
           "street": "MHKC",
           "zipCode": 38371
       },
       "salary": 5000.0
   }
```
## Update Employee
### Request

`PUT /employee-webservice/`

### Response: 
`HTTP/1.1 200 Updated`

```{
       "id": "60bd964b4ce48c43a2ada7c4",
       "age": 30,
       "name": "Jack",
       "address": {
           "city": "NY",
           "country": "USA",
           "street": "MHKC",
           "zipCode": 38371
       },
       "salary": 5000.0
   }
```
