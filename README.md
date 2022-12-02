# CRM-Spring-Net-React
CRM Assesment for Solera Bootcamp

# Backend
This is the first project you must run to make the application work. 

The entire project is organized into:
- Entities
- Controllers
- Services
- Repositories

Aditionally, there are also configuration and filter files.

Before running the project, it is necessary to configure a database for it, which must be specified in the `application.properties` file.

# Frontend
This is the next project you must run to make frontend work with the backend.

There is a login page and, once logged in, a main page with a navigator between:
- Home: contains sample text to simulate a home page
- Opportunities: contains all the oportunities attached to the user
- Clients: contains all the clients attached to user opportunities
- Logout

Everything is encrypted to make it secure through httpOnly cookies stored and gotten through the server side.

# Selenium
Once project is running, tests in frontend can be made inside this project, where there are some tests for creating opportunities and converting them into clients.
