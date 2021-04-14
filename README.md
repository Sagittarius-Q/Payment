# Payment

#  1.Security

   * Basic Auth
   * Memory authetication
   * Username: "user" , Password: "pass"
   
#  2.Database

   *  Postgresql
   *  Defining Payment Id is manually (not auto generate)
    
#  3.Api

   *  port: 5656
   * Url: /api/pay  (POST method)
           example: 
          
          request:
                {
                  "id" : 1234567,
                  "supplier_id": 7654321,
                  "account": "996222456789",
                  "amount": 200.5 
                }
                 
                 
           response:     
                 <XMLResponse>
                     <id>1234567</id>
                     <supplier_id>7654321</supplier_id>
                     <status>1</status>
                     <message>PAYMENT CONFIRMED</message>
                     <date>Thu Apr 15 01:34:57 KGT 2021</date>
                 </XMLResponse>
                 
                 
        * Url: /api/check  (GET method)  
        The check() method return data by entity Id (does not compare all element)
           example: 
           
          
          request:
          
                {
                
                  "id" : 1234567,
                  
                  "supplier_id": 7654321,
                  
                  "account": "996222456789",
                  
                  "amount": 200.5 
                  
                }
                
                 
                 
           response:    
           
                 <XMLResponse>
                 
                     <id>1234567</id>
                     
                     <supplier_id>7654321</supplier_id>
                     
                     <status>0</status>
                     
                     <message>EXISTS</message>
                     
                     <date>2021-04-15 01:34:57.439</date>
                     
                 </XMLResponse>
       
              
