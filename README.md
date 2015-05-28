# java-mongodb-sample
This is a sample application, which uses Java to connect to a Mongo database.

##Prerequisites
Make sure, that you have the following software installed:
* JDK 1.8 or later
* MongoDb (On OS X you can install it via Homebrew: `brew install mongodb`)

##Usage
The application starts a HTTP server on port `8080` to query and manipulate the database.  


## Http-Services
- `/getEntries` - Returns all entries stored in the database
- `/dropEntries` - Removes all entries in the database
- `/addEntry?name=<NAME>` - Adds an entry with the specified name

__Sidenote:__ Make sure, that mongod is running (`sudo mongod`), otherwise you will get an exception.
