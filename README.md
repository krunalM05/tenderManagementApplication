# tenderManagementApplication
Sample spring boot project using jwt

we will break down this problem in two steps
1. Implementing CRUD APIs in biddingController
2. Implementing JWT authentication

### Implementing CRUD APIs
1. first download unImplemented TenderManganement Project and import it in STS IDE as existing maven project.
2. check all packages - service, repository, controller, model, etc and add required annotaions in the classes if not added
   for service -> @Service
   for repository -> @Repository
   for controller -> @Restcontroller and @RequestMapping
3. open biddingController and add @pathVariable, @RequestBody, @RequestParam as needed based on problem description
![Controller](https://github.com/user-attachments/assets/604396a8-2195-455e-b1e9-1afa2b34a56b)
4. Write logic in biddingService file as per problem statement
5. save changes and run project as spring boot app, the project will run on server 8080 port.
6. open postman for API testing
7. add some random dummy data for bidding model
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
8. check get API -> get all BiddingModel records whose bidAmount greater than provided bidAmount ex: 1000
   ![getAPI](https://github.com/user-attachments/assets/870689ee-1f4a-4e63-a72d-39a0cbd13b00)

9. check update API change status for any one Bidding object from pending to completed
   ![putAPI](https://github.com/user-attachments/assets/a34c04ae-6d84-447c-9fdc-05db15a18ade)
10. Check delete API by deleting any biddingModel record by providing Id
    ![deleteAPI](https://github.com/user-attachments/assets/a47f0aad-93de-4e5b-bebb-9f35d8e180f0)





