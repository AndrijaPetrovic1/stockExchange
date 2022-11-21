# TECHNICAL ASSIGNMENT 
## Candidate: Andrija Petrovic

I used _Spring Boot_ and _Postgresql_ to create this project. I used _Postman_ to test the API.<br>
Since I haven't created a self-contained deployment package, I'll walk you through getting<br>
the application up and running here.

## Launching the application

When starting the application, the _StockOrderInitializer_ class automatically enters the initial<br>
data into the database using the _initialDataSetup_ method. <br><br>
![loading..](readmerecourses/img1.png) <br><br>
![loading..](readmerecourses/img2.png) <br><br>
![loading..](readmerecourses/img3.png) <br><br>

## About REST API

After launch, you can also see API information at http://localhost:8080/swagger-ui/index.html#/stock-order-controller <br><br>
![loading..](readmerecourses/img4.png) <br><br>

The first endpoint returns all data from the database, since there is not much data, I did not perform pagination <br><br>
![loading..](readmerecourses/img5.png) <br><br>

After that, we have an endpoint for entering a new order, which returns data about the entered order  <br><br>
![loading..](readmerecourses/img6.png) <br><br>

And finally, the last 2 endpoints that return data on top 10 BUY and top 10 SELL orders <br><br>
![loading..](readmerecourses/img7.png) <br><br>
![loading..](readmerecourses/img8.png) <br><br>

### If you evaluate my project positively, I would be happy to show you all the functionalities and explain how I created them.