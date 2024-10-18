# AluControl Application

## Sergio Oliveira, x23170981@student.ncirl.ie

**Higher Diploma in Science in Computer**

**Specialisation: Software Development**

**5 June 2024**

---

## Table of Contents

1. [Objectives](#objectives)
2. [Key Features](#key-features)
3. [Technology Stack](#technology-stack)
4. [Deployed Application](#deployed-application)
5. [Version History](#version-history)

---

## Objectives

The AluControl application was developed as part of the final project for the Higher Diploma in Science in Computing at the National College of Ireland (NCI). The primary goal of this project is to create a centralized business automation system that optimizes the management of sales and inventory operations, improving efficiency and supporting decision-making through real-time reporting and automation.

### Key Features

- **Inventory Management:**
  - Automates the tracking and management of stock, simplifying inventory control.

- **Sales and Rental Reports:**
  - Generates comprehensive reports on sales and rental activities, providing insights into business performance.

- **Real-Time Dashboards:**
  - Offers data visualization tools like charts and dashboards to monitor real-time performance metrics.

- **Automation of Business Processes:**
  - Reduces manual work and minimizes errors, leading to improved operational efficiency.

- **Increased Productivity**
  - Removes repetitive tasks, allowing more focus on value-driven activities.

- **Decision-Making Support:**
  - Provides access to advanced analytics and real-time reporting to aid strategic decisions.

- **Financial Reporting:**
  - Delivers detailed financial reports, including expense tracking and cash flow management.

- **Cash Flow Control:**
  - Ensures effective financial oversight by managing both receivables and payables.

### Future Enhancements

- **Stock Level Optimization:**
  - Implement advanced algorithms to maintain precise stock levels, avoiding shortages and overstocking.

- **Expanded Financial Control:**
  - Introduce additional features for managing revenues and expenses, with enhanced financial reporting capabilities.

---

## Technology Stack

- **Frontend Development:**
  - **HTML & CSS:** Structuring and styling the user interface, with responsive design supported by Bootstrap.
  - **JavaScript:** Enables real-time interaction with backend services, dynamic interface behaviour, and AJAX requests for asynchronous data exchange. This improves user experience by allowing updates without reloading the entire page. 

- **Backend Development:**
  - **Java:** The application’s core is built in Java, leveraging its modularity and reusability.
  - **Spring Boot:** A framework that simplifies backend configuration and enables the development of standalone applications with minimal setup.
  - **Maven:** Used for dependency management and project building.
  - **Jakarta:** Facilitates the creation of entities and business models.
  - **JPA (Java Persistence API):** Manages creating and manipulating database tables.
  - **RESTful API:** Facilitates communication between frontend and backend through RESTful services for data operations (CRUD).
 
- **Database:**
  - **PostgreSQL:** The application uses PostgreSQL in production. PostgreSQL is known for its reliability, efficiency, and robustness in managing data, providing secure storage and fast information retrieval.

- **Hosting:**
  - **Heroku:** The application is hosted on Heroku, providing a scalable and reliable cloud infrastructure with a simplified deployment process.

---

## Deployed Application

- The AluControl Application is live and accessible at:
[https://intense-garden-41996-d66e1ac1514c.herokuapp.com](https://intense-garden-41996-d66e1ac1514c.herokuapp.com)

---

## Version History
- **1.2.0 (18 October 2024)**
  - **Focus:** On Clean Code practices, applying SOLID principles. Specifically, the DRY (Don’t Repeat) principle and the Single Responsibility Principle were implemented. 
  - **Refactor:** The frontend code has been refactored to ensure that each method in JavaScript has a single responsibility. This resulted in a more readable, maintainable and efficient code, improving the performance and reliability of the application.
  - **Minor improvements:** Minor UI adjustments and usability improvements to provide a more intuitive experience.
  - **Bug fixed:**
    - Adjustments to forms, including improvements in responsiveness, visual feedback and input validation.
    - Fixed a bug that caused incorrect adjustments in product stock when editing a rental. 
  
- **1.1.0 (14 October 2024):**
  - **Refactor:** Backend code refactored to improve performance and modularity.
  - **Enhancement:** Optimized service and repository layers for better data handling.
  - **Minor improvements:** Enhanced rental and inventory management business logic.

- **1.0.0 (5 June 2024):**
  - **Initial release** with features for rental management, customer management, inventory monitoring, financial tracking, and reporting. 


