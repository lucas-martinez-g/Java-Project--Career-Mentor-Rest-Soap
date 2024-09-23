# README

## Rest:

### Add Person:

`POST http://localhost:8080/api/person/add`

**Body:**

```
<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<person>
  <id>{id}</id>
  <name>{name}</name>
  <birthDate>{YYYY-mm-DD}</birthDate>
</person>
```

**Headers:**

` Content-Type: application/xml `

### Delete Person:

`DELETE http://localhost:8080/api/person/delete/{id}`

**Body:**

```
No body
```

**Headers:**

` No headers `

### Get Person:

`GET http://localhost:8080/api/person/get/{id}`

**Body:**

```
No body
```

**Headers:**

` No headers `

### Get All Persons:

`GET http://localhost:8080/api/person/get/{id}`

**Body:**

```
No body
```

**Headers:**

` Accept: application/xml `

## Soap:

### Add Person:

`POST http://localhost:8081/ws/person/add`

**Body:**

```
<?xml version="1.0" encoding="UTF-8"?>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ns="rest-soap-app">
  <soap:Header/>
  <soap:Body>
    <ns:addPerson>
      <person>
        <id>{id}</id>
        <name>{name}</name>
        <birthDate>{YYYY-mm-DD}</birthDate>
      </person>
    </ns:addPerson>
  </soap:Body>
</soap:Envelope>
```

**Headers:**

` Content-Type: text/xml `

### Delete Person:

`POST http://localhost:8081/ws/person/delete`

**Body:**

```
<?xml version="1.0" encoding="UTF-8"?>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ns="rest-soap-app">
  <soap:Header/>
  <soap:Body>
    <ns:deletePerson>
      <id>{id}</id>
    </ns:deletePerson>
  </soap:Body>
</soap:Envelope>
```

**Headers:**

` Content-Type: text/xml `

### Get Person:

`POST http://localhost:8081/ws/person/get`

**Body:**

```
<?xml version="1.0" encoding="UTF-8"?>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ns="rest-soap-app">
  <soap:Header/>
  <soap:Body>
    <ns:deletePerson>
      <id>{id}</id>
    </ns:deletePerson>
  </soap:Body>
</soap:Envelope>
```

**Headers:**

` Content-Type: text/xml `

### Get All Persons:

`POST http://localhost:8081/ws/person/getAll`

**Body:**

```
<?xml version="1.0" encoding="UTF-8"?>
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ns="rest-soap-app">
  <soap:Header/>
  <soap:Body>
    <ns:getAllPersons/>
  </soap:Body>
</soap:Envelope>
```

**Headers:**

` Content-Type: text/xml `
