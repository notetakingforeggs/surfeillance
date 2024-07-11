# Surfeillance

## Description

Welcome to the Surfeillance backend. A Spring Boot application used to power the [Surfeillance](https://github.com/AeratedAutoclave/surfeillance-frontend) app on Android.



## API
### Information
The following API endpoints are not publicly accessible. This information is provided for development purposes.

### Conditions

#### base uri

```http://localhost:8080/api/v1/conditions```

#### Endpoints

#### GET ```/```
Returns a list of all Conditions, an object containing location, wave, weather and tide details.
```json
[
    {
        "spotId": 1,
        "name": "Castle Haven Bay",
        "requestTime": "2024-07-11T02:21:02",
        "latitude": -4.1925652,
        "longitude": 54.8083162,
        "timezone": "GMT",
        "waveHeight": 1.3,
        "waveDirection": "NW",
        "wavePeriod": 1.2,
        "windSpeed": 2.1,
        "windDirection": "NW",
        "gusts": 3,
        "lowTideTime": "2024-07-11T03:21:02",
        "lowTideHeight": 0.5,
        "highTideTime": "2024-07-11T09:20:49",
        "highTideHeight": 2.4
    },
...
    {
      "spotId": 6,
      "name": "Roker Beach",
      "requestTime": "2024-07-11T02:21:02",
      "latitude": -1.3671113,
      "longitude": 54.9285419,
      "timezone": "GMT",
      "waveHeight": 1.6,
      "waveDirection": "SE",
      "wavePeriod": 0.9,
      "windSpeed": 1.3,
      "windDirection": "S",
      "gusts": 2,
      "lowTideTime": "2024-07-11T03:11:32",
      "lowTideHeight": 1.1,
      "highTideTime": "2024-07-11T09:31:09",
      "highTideHeight": 2.3
    }
]
```

### Users

#### base uri

```http://localhost:8080/api/v1/users```

#### Endpoints

#### GET ```/{id}```
Returns details of a user profile.
```json

{
  "id": 1,
  "userName": "Chris Smith",
  "profileText": "New to surfing and looking to explore the coast.",
  "location": "North East, UK",
  "skillLevel": "BEGINNER",
  "imageUrl": "image.jpg",
  "email": "chrissmith@email.com"
}

```

#### POST ```/add```
Returns album information based on its id or advises an album doesn't exist.

```json
{
    "userName": "Chris Smith",
    "profileText": "New to surfing and looking to explore the coast.",
    "location": "North East, UK",
    "skillLevel": "BEGINNER",
    "imageUrl": "image.jpg",
    "email": "chrissmith@email.com"
}
```

#### PUT ```/{id}```
Edits a user profile with the contents of the request body. Sign in email can not be edited.

```json
{
    "userName": "Chris Smith",
    "profileText": "New to surfing and looking to explore the coast.",
    "location": "North East, UK",
    "skillLevel": "BEGINNER",
    "imageUrl": "image.jpg"
}
```

#### get ```/trips/{userid}```
Returns a list of all trips taken by the signed in user.

```json
[
  {
    "tripId": 1,
    "appUserDTO": {
      "id": 1,
      "userName": "Chris Smith",
      "profileText": "New to surfing and looking to explore the coast.",
      "location": "North East, UK",
      "skillLevel": "BEGINNER",
      "imageUrl": "image.jpg",
      "email": "chrissmith@email.com"
    },
    "spot": {
      "spotId": 1,
      "locationName": "Castle Haven Bay",
      "coordinate": {
        "latitude": -4.1925652,
        "longitude": 54.8083162
      },
      "tideStationID": "0265"
    },
    "surfRating": 4,
    "infoRating": 5,
    "date": "2024-07-11T11:21:02",
    "waveHeight": 1.3,
    "waveDirection": "NW",
    "wavePeriod": 1.2,
    "windSpeed": 2.1,
    "windDirection": "NW",
    "gusts": 3,
    "lowTideTime": "2024-07-11T12:21:02",
    "lowTideHeight": 0.5,
    "highTideTime": "2024-07-11T18:20:49",
    "highTideHeight": 2.4
  },
  ...
  {
    "tripId": 6,
    "appUserDTO": {
      "id": 1,
      "userName": "Chris Smith",
      "profileText": "New to surfing and looking to explore the coast.",
      "location": "North East, UK",
      "skillLevel": "BEGINNER",
      "imageUrl": "image.jpg",
      "email": "chrissmith@email.com"
    },
    "spot": {
      "spotId": 4,
      "locationName": "Ross Bay",
      "coordinate": {
        "latitude": -4.0919856,
        "longitude": 54.8492277
      },
      "tideStationID": "0310A"
    },
    "surfRating": 3,
    "infoRating": 4,
    "date": "2024-08-11T11:21:02",
    "waveHeight": 1.3,
    "waveDirection": "NW",
    "wavePeriod": 1.4,
    "windSpeed": 2.6,
    "windDirection": "NW",
    "gusts": 2,
    "lowTideTime": "2024-08-11T12:21:02",
    "lowTideHeight": 0.3,
    "highTideTime": "2024-08-11T18:20:49",
    "highTideHeight": 2.5
  }
]
```

#### POST ```/trips/add```
Adds a new trip for the current user

```json
{
  "appUserDTO": {
    "id": 1,
    "userName": "Chris Smith",
    "profileText": "New to surfing and looking to explore the coast.",
    "location": "North East, UK",
    "skillLevel": "BEGINNER",
    "imageUrl": "image.jpg",
    "email": "chrissmith@email.com"
  },
  "spot": {
    "spotId": 4,
    "locationName": "Ross Bay",
    "coordinate": {
      "latitude": -4.0919856,
      "longitude": 54.8492277
    },
    "tideStationID": "0310A"
  },
  "date": "2024-08-11T11:21:02",
  "waveHeight": 1.3,
  "waveDirection": "NW",
  "wavePeriod": 1.4,
  "windSpeed": 2.6,
  "windDirection": "NW",
  "gusts": 2,
  "lowTideTime": "2024-08-11T12:21:02",
  "lowTideHeight": 0.3,
  "highTideTime": "2024-08-11T18:20:49",
  "highTideHeight": 2.5
}
```

#### PUT ```/trips/{userid}```
Edit a trip in order to add ratings.

```json
{
  "surfRating": 5,
  "infoRating": 5
}
```

### Heath

Standard /health endpoint supplied through Spring Actuator via redirect

#### base uri

```http://localhost:8080/api/v1/health```

### Endpoints

#### GET ```/```

```json

{
  "status": "UP"
}
```

## Documentation

The codebase is split into a number of packages.

1. Repository
    - Includes separate repositories for AppUsers, Spots and Trips.
    - Implements CrudRepository to supply standard CRUD functionality.
2. Model
    - Includes entity models for AppUsers, Spots and Trips and a number of DTO objects for data transfer to/from the database
3. Service
    - Split into packages to handle repository and third party API calls seperately.
    - Third party APIs consumed:
      - [Tide Stations](https://www.admiralty.co.uk/access-data/apis)
      - [Weather](https://open-meteo.com/)
      - [Waves](https://open-meteo.com/)
    - Business logic used to combine all results
4. Controller
    - Endpoint definition to serve an Android application.
    

## Future Inclusions

1. Additional data through further API consumption
    - Environmental Agency - Water Quality
2. Optimisation
    - Scheduled use of third party APIs to prevent redundant calls.