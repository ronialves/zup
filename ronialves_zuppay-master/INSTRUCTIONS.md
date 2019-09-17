![github-small](logo_zuppay.png)

ZUPPAY
=====

The startup **ZUPPAY** is inviting you to join a squad for build a new application of payment processing!
As the architect of solution, you are the responsable to design and implement the authoization process of a payment requested by a user of the platform.

You can use any programming language that supports HTTP or GRPC protocol. 

## Instructions:

##### Requirements:
- A solution design diagram
- The application must use best practices of PCI compliance
- The payment request must be idempotent
- The payment process must be asynchronous
- The payment status must be notified by some way to the user

##### Required fields:
```
> description: String (100) 
> amount: Int (in cents)
> currency: String (supports only USD, EUR)
> creditCard: Object (card fields)
```

## What will be evaluated:
- Adherence to requirements
- Elegance of the solution
- Documentation
- Defense of the solution through presentation in English (if you're comfortable)
- The source code must be in a Git repository
- It should contain a file named README.md describing the solution and how to test and run the project
