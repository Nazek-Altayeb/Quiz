# Goal

The objective of this project is to develop a robust and scalable REST API that powers the Quiz [Frontend](https://github.com/Nazek-Altayeb/Quiz-Frontend). The API dynamically serves quiz content based on user-selected criteria such as question count, category, and difficulty level.

All questions are retrieved in real time from the Open Trivia [Encyclopedia](https://opentdb.com/api_config.php) and are temporarily stored in a PostgreSQL database for processing. The API is designed to comply with frontend requests while ensuring speed, reliability, and a clean separation of concerns.

This system serves as the foundation for a more advanced CMS solution tailored to educational institutions, enabling quiz creation, user management, and performance tracking.

# System design

The database for this project is relational. Currently it consists of these tables.

```mermaid
erDiagram
    User ||--o{ Quiz : creates
    User ||--o{ Result : has
    Quiz ||--o{ Question : contains
    Quiz ||--o{ Result : produces
    Quiz ||--o{ Requirement : defines

    User {
        string id
        string name
        string email
    }

    Quiz {
        string id
        string title
        int question_count
        string difficulty
    }

    Question {
        string id
        string quiz_id
        string text
        string correct_answer
    }

    Result {
        string id
        string user_id
        string quiz_id
        int score
        datetime submitted_at
    }

    Requirement {
        string id
        string quiz_id
        string description
        string priority
    }
```


## Workflow:

- The frontend sends quiz parameters: number of questions, category, and difficulty.

- The backend uses these parameters to fetch questions from Open-Trivia [Encyclopedia](https://opentdb.com/api_config.php).

- The fetched data is temporarily stored in the PostgreSQL database.

- The data is then served to the frontend.

## Architecture Extension Plan
To make the system more professional, scalable, and CMS-ready, I plan to gradually extend the system to include:

- User management

- Persistent quiz history

- Admin interfaces for custom question entry

- Question categories, tags, and metadata

- CMS functionality for school use (e.g. tracking, reporting)



# Development

## Requirements & Implementation Roadmap
Each “Requirement” is grouped by relevance and development priority using the MoSCoW method.

### Requirement 1: Basic Functionality
- [x] [Setup environment] <code style="color:red">(Must have)</code>
- [x] [Load quiz parameters from frontend] <code style="color:red">(Must have)</code>
- [x] [Fetch questions from Open Trivia Encyclopedia] <code style="color:red">(Must have)</code>
- [x] [Send questions to frontend] <code style="color:red">(Must have)</code>


### Requirement 2: User Management
- [] [Create User table ] <code style="color:red">(could have)</code> 
- [] [Implement CRUD operations for User] <code style="color:red">(could have)</code> 


### Requirement 3: CMS Foundations
- [] [Allow custom question entry by admin ] <code style="color:orange">(Should have)</code>
- [] [Store completed quizzes with user reference] <code style="color:orange">(Should have)</code>
- [] [Add user roles and permissions (admin, student)] <code style="color:orange">(Should have)</code>




