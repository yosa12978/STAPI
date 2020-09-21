
<p align = "center"><img  src="logo.PNG"></p>

<h1 align="center"> Star Trek API </h1>

<h3 align="center"> Open Source REST API for Star Trek</h3>


<hr>

<h2>Usage</h2>

#### Host

Global host name : https://star-trek-api.herokuapp.com

---

#### Authentication

Currently app supports only jwt authentication

To sign up send POST request to 
```http
POST https://star-trek-api.herokuapp.com/api/v1/account/signup
```

With body
```json
{
  "username": "username",
  "password": "password"
}
```

Soon you should send POST request to get token
```http
https://star-trek-api.herokuapp.com/api/v1/account/login
```  

With body
```json
{
  "username": "username",
  "password": "password"
}
```

---

#### Routes

```
GET https://star-trek-api.herokuapp.com/api/v1/characters
```
```
GET https://star-trek-api.herokuapp.com/api/v1/characters/{id}
```
```
GET https://star-trek-api.herokuapp.com/api/v1/characters/search?q={search query}
```
```
GET https://star-trek-api.herokuapp.com/api/v1/series
```
```
GET https://star-trek-api.herokuapp.com/api/v1/series/{id}
```
```
GET https://star-trek-api.herokuapp.com/api/v1/series/search?q={search query}
```
```
GET https://star-trek-api.herokuapp.com/api/v1/starships
```
```
GET https://star-trek-api.herokuapp.com/api/v1/starships/{id}
```
```
GET https://star-trek-api.herokuapp.com/api/v1/starships/search?q={search query}
```
```
GET https://star-trek-api.herokuapp.com/api/v1/planets
```
```
GET https://star-trek-api.herokuapp.com/api/v1/planets/{id}
```
```
GET https://star-trek-api.herokuapp.com/api/v1/planets/search?q={search query}
```
```
GET https://star-trek-api.herokuapp.com/api/v1/races
```
```
GET https://star-trek-api.herokuapp.com/api/v1/races/{id}
```
```
GET https://star-trek-api.herokuapp.com/api/v1/races/search?q={search query}
```