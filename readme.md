# FullContact Enrichment trial

This assignment's purpose is to build a very minimalistic user interface to lookup and display profiles from the FullContact API. It covers introduction to our API while letting you demonstrate your frontend and backend skills required for 
the CX/UI engineering position. The assignment should not take more than 4 hours to complete.

## Prerequisites

A FullContact API key is required to call any APIs at `https://api.fullcontact.com`

API Keys are passed as a header as shown below:
```
Authorization: Bearer APIKEYHERE
```

Where API key is required please use the following key: 
```
2bzL1ua0kJ0MGAyinhQnczu05lsrcD1g
```

## Problem statement

We want to build a simple one page application that allows the user to enter an email, phone number or a social profile URL and display a basic profile that the Enrich API returns. Basic profile contains a name, picture, occupation, list of emails, list of phone numbers and a list of social profile URLs. Invalid & missing profiles must be handled gracefully. Any technology stack can be used. There is no requirement for user authentication or permissions.

The UI should include a "Query History" page that will show all of the searches and responses that have been made since the application has 
been running. The query history should be maintained by the backend application. If you refresh the frontend browser you should be able 
to still see the query history witout making use of client side storage (cookies or local storage).

You may choose any method on the backend to persist query history (in memory cache, local database, etc).

All API calls to `api.fullcontact.com` should happen from the backend application. 

## Must haves
* Basic functionality described in the problem statement
* Source control with commits evolving the project
* Use of FullContact Enrich API (https://docs.fullcontact.com/#enrich-api)
* Clear instructions on how to run the application
## Nice to haves
* Responsive layout
* Input validation
* Use of React
* Debug logging
* Tests if applicable
* Readme on tech stack decisions
* Build / config file to run in a containerized environment such as Docker

## Submitting the homework

Prior to working on the solution create an empty git repo in this repository by running the following command in this directory:

```
git init
```

As you work on the project feel free to make as many intermediate commits along the way.

When you are ready to submit the project please make sure any generated files and dependencies that can be downloaded 
using a simple command such as `npm install` / `gradlew build` / etc are first removed and then zip the project and 
return it via email to the same hiring manager or recruiter that you originally received it from.