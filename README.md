# RecipeApp Api Application Guide





![image](https://user-images.githubusercontent.com/113394813/189920614-2a5ed3f8-cd7e-4bfd-96bf-1925638c9780.png)


**Prerequisites**
    JDK 1.8
    Maven 3 or later (3.5)
    GIT

**Technology stack:**
   Technology stack used : Springboot, MysqlDB, Spring JPA, QueryDsl, Mysql DB

**Quick Start**
 Clone source: git clone https://github.com/dipa006tech/recipe-app.git  
 cd recipe-app  
 mvn clean install  
 mvn spring-boot:run  
 
 **Visit Swagger Documentation**
 
http://localhost:8080/recipeapp/swagger-ui.html
http://localhost:8080/recipeapp

**Endpoints**

![image](https://user-images.githubusercontent.com/113394813/189931396-4a707542-4609-47fb-8689-b6a6b054aefa.png)


**Sample Request Data:**
```json
{
    "recipeName": "Bread",
    "ingredients": "Flour, oil and Salt",
    "noOfServings": "4",
    "isVegetarian": "Y",
    "instructions": "Preparation in Oven"
}
```

