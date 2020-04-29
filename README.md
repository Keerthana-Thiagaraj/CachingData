# CachingData

Example of an Application to retrieve data from cache rather than hitting the database everytime whenever the client request is triggered.

Caching of frequently used data in application is a very popular technique to increase performance of application. 
With caching, we store such frequently accessed data in memory to avoid hitting the costly backends every time when user requests the data.
Data access from memory is always faster in comparison to fetching from storage like database, file system or other service calls.

£ Implementation:

  1. Created a database based on the required schema in MySQL.
  2. Established a connection to the database using JDBC.
  3. Listener class triggers the class containing the database call on the start of the application.
  4. In the initial call of the application, database entries are retrieved and stored in Map with key being the primary column of the table.
  5. Going forward, whichever requests require the values from database, the cached map serves the purpose.
  6. Hence, this approach increased the application performance by reducing calls made to the database.
