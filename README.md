# About

Sample Angular application that allows Users to Register / Login / Log Out. 

# Running the Application

Clone the Repo then run the application:

`grails run-app`

OR

`grails-run-app -https`

Then browse to `http://localhost:8080/LoginApp`


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

* Stateless, token-based authentication RESTful Authentication
* Backend Service is secured via [Spring Security REST Plugin](https://grails.org/plugin/spring-security-rest)
* Refer to diagram for workflow:

![REST Workflow](http://alvarosanchez.github.io/grails-spring-security-rest/1.5.1/docs/img/rest.png)


Obtain an access token by posting to `/api/login`

    POST http://localhost:8080/LoginApp/api/login
    {
        "username": "admin",
        "password": "admin"
    }
    ----
    200 OK
    {
        "username": "admin",
        "roles": [
            "ROLE_ADMIN"
        ],
        "token_type": "Bearer",
        "access_token": "eyJhbGciOiJIUzI1NiJ9...",
        "expires_in": 3600,
        "refresh_token": "eyJhbGciOiJIUzI1NiJ9..."
    }

I use the `LoginService` factory to gain a Token, and then store it in LocalStorage.  
Logging out simply clears the Token from LocalStorage since a truly RESTful system 
would should not store session state.

Account Registration is done by POSTing to `/LoginApp/api/users`.
After a new Account is created it is disabled and must be activated by visiting a link.
(I decided to print the link on the console rather than email it to avoid configuring an SMTP mail server). 

The activation link has the following format : `/LoginApp/api/activations/{{activationCode}}`


## REST Service
 
The REST BackEnd is exposed at : `/api/notes`


    GET http://localhost:8080/LoginApp/api/notes 
    Authorization : Bearer eyJhbGciOi...
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


## Notes

* `grails url-mappings-report`
* http://mrhaki.blogspot.com/2013/11/grails-goodness-create-report-of-url.html 

## TODO

* Write Unit Tests
* Move Angular Controllers & Services into own files
