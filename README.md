# treasurehunt-backend

## Installation guide

To run the application go into the root directory of the project and run:

`./mvnw spring-boot:run`

## App URL

App is running by default on port 8080. The url of REST API is:

`http://localhost:8080/api/v1`

## Available endpoints

There are 3 endpoints available:

1. `/board/{player}` GET gets an empty game board for a new player and current game state for user that didn't finish his previous game
2. `/check` POST receives a list of up to three cell to check in a game, returns values of those cells
3. `/leaderboard` GET returns a list of 10 highest scores in the game
