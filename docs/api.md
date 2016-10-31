# API Documentation v0.1

## User data

### Get basic user data

*Example request*

+ **GET** http://riverlake.com/data/users/nettee
+ **Accept**: application/json; charset=UTF-8

*Example response*

+ **200** OK
+ **Content-type**: application/json; charset=UTF-8

```
{
  "login": "nettee",
  "avatar_url": "https://avatars.githubusercontent.com/u/3953668?v=3",
  "url": "https://api.github.com/users/nettee",
  "html_url": "https://github.com/nettee",
  "repos_url": "https://api.github.com/users/nettee/repos",
  "name": "William Liu",
  "company": "Nanjing University",
  "blog": "http://nettee.github.io/",
  "location": "Nanjing, China",
  "email": "nettee.liu@gmail.com",
  "bio": "Computer Science student.",
  "public_repos": 39,
  "followers": 11,
  "following": 17,
}
```

### Get repository details


