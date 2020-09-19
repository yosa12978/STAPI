
<p align = "center"><img  src="logo.PNG"></p>

<h1 align="center"> Star Trek API </h1>

<h3 align="center"> Open Source REST API for Star Trek</h3>


<hr>

<h2>Usage</h2>

#### Host

Global host name : https://star-trek-api.herokuapp.com

---

#### Authentication

Currently app supports only basic authentication

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

Authentication Example:
```http
https://username:password@star-trek-api.herokuapp.com/
```  


---

#### Routes

```http
GET https://star-trek-api.herokuapp.com/api/v1/characters
```
```http
GET https://star-trek-api.herokuapp.com/api/v1/characters/{id}
```
```http
GET https://star-trek-api.herokuapp.com/api/v1/characters/search?q={search query}
```
```http
GET https://star-trek-api.herokuapp.com/api/v1/series
```
```http
GET https://star-trek-api.herokuapp.com/api/v1/series/{id}
```
```http
GET https://star-trek-api.herokuapp.com/api/v1/series/search?q={search query}
```
```http
GET https://star-trek-api.herokuapp.com/api/v1/starships
```
```http
GET https://star-trek-api.herokuapp.com/api/v1/starships/{id}
```
```http
GET https://star-trek-api.herokuapp.com/api/v1/starships/search?q={search query}
```
```http
GET https://star-trek-api.herokuapp.com/api/v1/planets
```
```http
GET https://star-trek-api.herokuapp.com/api/v1/planets/{id}
```
```http
GET https://star-trek-api.herokuapp.com/api/v1/planets/search?q={search query}
```
```http
GET https://star-trek-api.herokuapp.com/api/v1/races
```
```http
GET https://star-trek-api.herokuapp.com/api/v1/races/{id}
```
```http
GET https://star-trek-api.herokuapp.com/api/v1/races/search?q={search query}
```