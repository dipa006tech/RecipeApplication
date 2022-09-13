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

![image](https://user-images.githubusercontent.com/113394813/189932446-ca7df273-bfac-46d4-988a-53f152d052cb.png)



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
**Details**  

Add Recipe  
![image](https://user-images.githubusercontent.com/113394813/189933012-9c213258-ed4c-42cd-9ab5-e66cf753c8fd.png)

Update Recipe  
![image](https://user-images.githubusercontent.com/113394813/189933196-6e97d76b-90f0-4b0d-84ac-623b871a4484.png)

Delete Recipe  
![image](https://user-images.githubusercontent.com/113394813/189933298-e7b9880d-474f-4719-a549-1804480d6d4b.png)

Get Recipe  
![image](https://user-images.githubusercontent.com/113394813/189933524-aaa24318-098d-4c2a-a20e-883b3cdfeb6d.png)

Find Recipe  
![image](https://user-images.githubusercontent.com/113394813/189933700-e5dfd0ca-037b-4f7f-a141-f0a59dc7cc5a.png)  

**Postman Collection**
https://www.getpostman.com/collections/03df4836099269d4de18







