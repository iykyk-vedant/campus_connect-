🎓 CampusConnect – Smart Campus Management System

CampusConnect is a Smart Campus Management System built with Spring Boot and PostgreSQL.
It helps manage students, faculty, courses, timetables, and attendance, all in one place.

🚀 Features (Planned & Implemented)

✅ Spring Boot + PostgreSQL Setup

🎓 Student Management (CRUD operations)

👨‍🏫 Faculty Management (CRUD operations)

📚 Course Management (link students & faculty)

📅 Timetable / Class Scheduling

📝 Attendance Tracking

🔐 Role-based Login System (Admin, Faculty, Student)

📊 Dashboard with Stats

🌐 Deployment on Render

🛠 Tech Stack

Backend: Spring Boot (Java)

Database: PostgreSQL (Hosted on Render)

Frontend: Thymeleaf + HTML + CSS (Bootstrap/Tailwind for styling)

Deployment: Render

Version Control: Git & GitHub

📂 Project Structure
CampusConnect/
│── src/main/java/com/campusconnect/     # Java source code
│   ├── controller/                      # Controllers (Student, Faculty, etc.)
│   ├── model/                           # Entities/Models
│   ├── repository/                      # JPA Repositories
│   └── CampusConnectApplication.java    # Main Spring Boot Application
│
│── src/main/resources/
│   ├── templates/                       # Thymeleaf HTML templates
│   ├── static/                          # CSS, JS, Images
│   └── application.properties           # Config (DB, server port, etc.)
│
│── pom.xml                              # Maven dependencies
│── README.md                            # Project documentation

⚡ Setup Instructions
1️⃣ Clone the Repo
git clone https://github.com/<your-username>/CampusConnect.git
cd CampusConnect

2️⃣ Configure Database

Create a PostgreSQL database (locally or on Render).

Update src/main/resources/application.properties:

spring.datasource.url=jdbc:postgresql://<host>:<port>/<dbname>
spring.datasource.username=<username>
spring.datasource.password=<password>
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3️⃣ Run the Project
mvn spring-boot:run


Visit 👉 http://localhost:8080

📌 Roadmap
✅ Completed

Spring Boot project setup

PostgreSQL connection (Render DB)

Sample entity testing (Student)

🟩 Remaining Steps

Step 2: Frontend Setup (Thymeleaf)

Step 3: Core Modules (Student, Faculty, Course, Timetable, Attendance)

Step 4: Role-based Authentication (Admin/Faculty/Student)

Step 5: Dashboard & UI Polishing (Bootstrap/Tailwind)

Step 6: Deployment on Render

Step 7: Documentation & Reports

📖 Documentation (To Be Added)

ER Diagram

Screenshots

Project Report (PDF)

Deployment Link

🤝 Contributing

Pull requests are welcome! For major changes, please open an issue first to discuss.

📜 License

This project is licensed under the MIT License.
