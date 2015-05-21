# java-mongodb-sample

Sample application which uses a MongoDb.# java-mongodb-sample

Sample application which uses a MongoDb. The application is starting a Http server on port `8080` to query and manipulate the database.

## Http-Services
- `/getEntries` - Retruns all entries stored in the database
- `/dropEntries` - Removes all entries in the database
- `/addEntry?name=<NAME>` - Adds an entry with the specified name