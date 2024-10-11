# Goal

Build API that serves the following front-end : https://github.com/Nazek-Altayeb/Quiz-Frontend.
It provides the Front-end with required data, which should be loaded from Open-TRIVIA in real time, Complies with end user inputs.

# System design

The database for this project is relational. it consists of two tables (Quiz, Questions) sofar.

First, the backend received the Quiz details (Number of questions, Category, difficulty level) from the frontend.

Then, the data is retrieved from Open-TRIVIA (https://opentdb.com/api_config.php) according to Quiz details.

After that, the retrieved data is stored in Postgresql DB.


# Development

I have organized the development process by dividing the required functionalities into small tasks.

The tasks are prioritized according to `MOSCOW`.

I have followed the iterative approach, every unit of related tasks are grouped in one `Sprint`.

- **Sprint 1**
  - [x] [Setup environment] <code style="color:red">(Must have)</code>
  - [x] [Load data from Frontend] <code style="color:red">(Must have)</code>
  - [x] [Retrieve data from Open-Trivia] <code style="color:red">(Must have)</code>
  - [x] [Send Questions data to frontend ] <code style="color:red">(Must have)</code>

- **Sprint 2**
  - [x] [Create User table] <code style="color:red">(could have)</code> 
  - [x] [CRUD User] <code style="color:red">(could have)</code> 



