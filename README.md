# tenderManagementApplication
Sample spring boot project using jwt

we will break down this problem in two steps
1. Implementing CRUD APIs in biddingController
2. Implementing JWT authentication

### Implementing CRUD APIs
1. first download unImplemented TenderManganement Project and import it in STS IDE as existing maven project.
   unImplemented project location: inside DemoTenderMgmtProject folder, Solution/Implemented project loc: folder tenderManagement
3. check all packages - service, repository, controller, model, etc and add required annotaions in the classes if not added
   for service -> @Service
   for repository -> @Repository
   for controller -> @Restcontroller and @RequestMapping
4. open biddingController and add @pathVariable, @RequestBody, @RequestParam as needed based on problem description
![Controller](https://github.com/user-attachments/assets/604396a8-2195-455e-b1e9-1afa2b34a56b)
5. Write logic in biddingService file as per problem statement
6. save changes and run project as spring boot app, the project will run on server 8080 port.
7. open postman for API testing
8. add some random dummy data for bidding model
   ![PostAPI](https://github.com/user-attachments/assets/f0d32cea-968a-40d7-a6a4-2ee2d9989c4b)
   some more one by one by replacing josn data
   {
    "biddingId":2,
    "bidAmount":4000,
    "yearsToComplete":5,
    "dateOfBidding":"11/09/2024",
    "bidderId":1
   } 
   {
    "biddingId":3,
    "bidAmount":9000,
    "yearsToComplete":5,
    "dateOfBidding":"12/09/2024",
    "bidderId":2
   }
   {
    "biddingId":4,
    "bidAmount":670,
    "yearsToComplete":5,
    "dateOfBidding":"13/09/2024",
    "bidderId":2
   }
9. check get API -> get all BiddingModel records whose bidAmount greater than provided bidAmount ex: 1000
   ![getAPI](https://github.com/user-attachments/assets/870689ee-1f4a-4e63-a72d-39a0cbd13b00)

10. check update API change status for any one Bidding object from pending to completed
   ![putAPI](https://github.com/user-attachments/assets/a34c04ae-6d84-447c-9fdc-05db15a18ade)
11. Check delete API by deleting any biddingModel record by providing Id
    ![deleteAPI](https://github.com/user-attachments/assets/a47f0aad-93de-4e5b-bebb-9f35d8e180f0)

### JWT Implementation

1. Solution for JWT is inside folder FinalSolutionJWT, you can reference that code while implementing JWT in your project.
2. Add dependecies in your pom.xml file
   
   <!-- jwt dependencies are here-->      
  		<dependency>
    		<groupId>io.jsonwebtoken</groupId>
    		<artifactId>jjwt-api</artifactId>
    		<version>0.11.5</version>
  		</dependency>
  		<dependency>
    		<groupId>io.jsonwebtoken</groupId>
    		<artifactId>jjwt-impl</artifactId>
    		<version>0.11.5</version>
  		</dependency>
  		<dependency>
    		<groupId>io.jsonwebtoken</groupId>
    		<artifactId>jjwt-jackson</artifactId>
    		<version>0.11.5</version>
  		</dependency>
 
   ![springsecuDep](https://github.com/user-attachments/assets/d5efd245-3a52-4be7-8fb0-e1991dff3a0f)
   ![jwtDep](https://github.com/user-attachments/assets/4db55b44-7fd2-4784-8ec6-793d9468c81d)

3. implemts UserModel class by UserDetails and override unImplemeted methods of UserDetails
   ![userM](https://github.com/user-attachments/assets/3843d0d4-5033-46af-b451-9d38147a9e37)

   here the UserDetails and UserModel has same methods coincendently i.e getUsername() method -> so we rename method of UserModel to getUserName() do avoid error.
4. implement JWTUtil class logic refere solution code for it, there are several methods we need to implement
   jwtExpiration and SecretKey we will specify through application.properties file so add then in that file
   ![image](https://github.com/user-attachments/assets/7aa5b5f0-e879-40ac-9960-eda0ee2872ee)

5. Now, implement the logic of AuthenticationFilter class extends this class by OncePerRequestFilter class add unImplemented methods.
   here, we took help of UserAuthService class which implements UserDetailsService, it has one method loadUserByUserName(), need to implement that method as per our bussiness logic
   whether we want to login user by email and password or username and password. here in this case we are login using email and password, so our loadUserByUserName() method
   must return UserDetails object by using email specified.
   ![image](https://github.com/user-attachments/assets/1fe10183-0e47-496e-a05e-06ca0f68b39f)

   ![image](https://github.com/user-attachments/assets/98fce1ae-62b5-4005-a646-400b2f618e53)


7. then, implement SecurityConfig class refere final solution code for it
   ![image](https://github.com/user-attachments/assets/bb0086e4-7eb3-4402-ab70-eab8f236c256)

   here, the user which has ROLE = APPROVER can only access /login, /bidding/list, /bidding/delete endpoints
   and the user Which has ROLE = BIDDER can only access /login, /bidding/add, /bidding/update endpoints
   /login is access by anyone irrespictive of role.

8. now, we will implements logic for /login endpoint, means when user hits /login endpoint, we will get token which is unique for each user.
   using that token (Bearer token) user will access endpoints which are restricted.

   First, write LoginController:-
   ![image](https://github.com/user-attachments/assets/d7222fa9-ae59-4232-87ff-c39eb80f7d92)

   then implemts actual bussiness logic inside class LoginService class:-
   ![image](https://github.com/user-attachments/assets/ae59a273-10f4-4643-a458-04c670da9cf0)

9. now, add some users BIDDER and APPROVER using DataLoader class which implements ApplicationRunner, and override run menthod
   ![image](https://github.com/user-attachments/assets/03a3217b-aea9-418a-b3d6-2a391136bef2)

   


   






