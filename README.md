# Retailer_rewards_springboot_geetha
Project Description :

A retailer offers a rewards program to its customers, awarding points based on each recorded purchase.  
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent between $50 and $100 in each transaction. 

(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points). 

Technologies used :  

Spring Boot, H2 (in-memory hql), Maven

Implementation explaination :

I have created 2 api's for creating data and showing the data

1. createDataSet api was created to create data and calculate reward points of customer and create data in H2 DB.
2. getCustomerRewardPoints api was created to showup the total reward points and monthly wise reward points

How to run a project :

1.	Do maven clean install 
2.	Start the application
3.  Run http://localhost:8080/createDataSet in browser, to calculate reward points and create data in H2 DB.
4.	Run http://localhost:8080/getCustomerRewardPoints?customerName=customer1 in browser, This will give total reward points and monthly wise reward points of customer 1


Sample Output:
{"totalPoints":80,"rewards":[{"month":3,"monthPoints":0},{"month":4,"monthPoints":30},{"month":5,"monthPoints":50}]}
