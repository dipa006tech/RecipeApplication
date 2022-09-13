# RecipeApp Api Application Guide





![image](https://user-images.githubusercontent.com/113394813/189920614-2a5ed3f8-cd7e-4bfd-96bf-1925638c9780.png)


Prerequisites
JDK 1.8
•	Maven 3 or later (3.5)
o	https://maven.apache.org/install.html
•	GIT
o	https://git-scm.com/downloads
Technology stack: Technology stack used : Springboot, MysqlDB, Spring JPA, QueryDsl, Mysql DB
Quick Start
Clone source
git clone https://github.com/dipa006tech/recipe-app.git
cd recipe-app
mvn clean install
mvn spring-boot:run
Visit Swagger Documentation
http://localhost:8080/recipeapp/swagger-ui.html
http://localhost:8080/recipeapp
Endpoints:

Request Method	Operation	Details
POST	/api/recipes
Add recipes with the parameters
GET	/api/recipes
Get the recipe based on the recipe id
PUT	/api/recipes/{recipeId}
Modify the recipe based on the recipe id
DELETE	/api/recipes/{recipeId}
Delete the recipe based on the recipe id
GET	/api/recipes/findRecipes
Find the recipe based on the search parameters


Sample Request Data:

{
    "recipeName": "Bread",
    "ingredients": "Flour, oil and Salt",
    "noOfServings": "4",
    "isVegetarian": "Y",
    "instructions": "Preparation in Oven"
}

