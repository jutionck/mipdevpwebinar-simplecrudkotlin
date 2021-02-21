# Simple CRUD with Kotlin and Spring Boot

## Set-up
1. Download or clone project, then extract project and open in your editor
2. Create database `db_academics`
3. Run project

## Endpoint
### Create
Request:
`Localhost:8080/api/student`
```json
{
    "name": "string",
    "npm": "string",
    "email": "string"
}
```
Response:
```json
{
    "code": number,
    "status": "string",
    "data": {
        "id": "UUID",
        "name": "string",
        "npm": "string",
        "email": "string"
    }
}
```

### Get
`Localhost:8080/api/student/id`

Response:
```json
{
    "code": number,
    "status": "string",
    "data": {
        "id": "UUID",
        "name": "string",
        "npm": "string",
        "email": "string"
    }
}
```
### Update
Request: `Localhost:8080/api/student/id`
```json
{
    "name": "string",
    "npm": "string",
    "email": "string"
}
```
Response:
```json
{
    "code": number,
    "status": "string",
    "data": {
        "id": "UUID",
        "name": "string",
        "npm": "string",
        "email": "string"
    }
}
```
### Delete
`Localhost:8080/api/student/id`

Response:
```json
{
    "code": number,
    "status": "string",
    "data": "string"
}
```
### List
`Localhost:8080/api/student?size=10&page=0`

Response:
```json
{
    "code": number,
    "status": "string",
    "data": [
        {
            "id": "UUID",
            "name": "string",
            "npm": "string",
            "email": "string"
        }
    ]
}
```
