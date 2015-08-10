# About

Sample Angular application that allows Users to Register / Login / Log Out. 

# Running the Application

* Browse to `http://localhost:8080/LoginApp`

The REST BackEnd is exposed at : `/api/notes`

```
GET http://localhost:8080/LoginApp/api/notes 
[
  {
    "class": "com.jxc876.Note",
    "id": 1,
    "date": "2015-08-10T00:58:04Z",
    "text": "Hello this is my note"
  },
  {
    "class": "com.jxc876.Note",
    "id": 2,
    "date": "2015-08-10T00:58:04Z",
    "text": "This is another note"
  }
]
```


# Design Decisions

## Tech Stack

* Angular / BootStrap (FrontEnd)
* Grails (REST BackEnd)


## Single Application OR Separate FrontEnd / BackEnd

### Single Project

* Great for Rapid Application Development
* Faster/Easier Setup & Configuration

### Separate Projects

* Decouples FrontEnd & BackEnd
* Better for real world applications
* Requires CORS filter

## Authentication Mechanism 

* Backend Service is secured via [Spring Security REST Plugin](https://grails.org/plugin/spring-security-rest)
* Stateless, token-based authentication RESTful Authentication
* Uses `X-Auth-Token` header

![REST Workflow](http://alvarosanchez.github.io/grails-spring-security-rest/1.5.1/docs/img/rest.png)


## Notes

* `grails url-mappings-report`
* http://mrhaki.blogspot.com/2013/11/grails-goodness-create-report-of-url.html 

