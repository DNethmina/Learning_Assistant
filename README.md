# 🎓 Learning Assistant

**Learning Assistant** is a Java-based desktop application designed to bridge the gap between teachers and students in a digital environment. Built using **Java Swing** and **MySQL** on the **MVC (Model-View-Controller)** architecture, this platform facilitates the seamless exchange of homework, questions, and grades, fostering a paperless educational ecosystem.

---

## 🌍 Mission & Vision

> *"Education that survives any disaster."*

This project was developed with a strong social mission:
* **Eco-Friendly:** Drastically reduces paper usage to help save the ecosystem and the economy.
* **Disaster Resilience:** Ensures education continues uninterrupted during crises like the **COVID-19 pandemic** or natural disasters, allowing students to learn safely from home.


---

## ✨ Key Features

The application features a dual-login system tailored for two distinct user roles:

### 👨‍🏫 For Teachers
* **Secure Login:** Authenticated access for educators.
* **Content Management:** Create and organize learning modules by **Grade** and **Title**.
* **Question Bank:** Add questions, correct answers, and allocate marks for specific assignments.
* **Review:** View student submissions.

### 👩‍🎓 For Students
* **Easy Access:** Login using Student ID and linked Teacher ID.
* **Smart Filtering:** Search for assignments by selecting the specific Category/Title.
* **Interactive Learning:**
    * **Show Questions:** Retrieve pending homework instantly.
    * **Submit Answers:** Upload answers directly through the interface.
* **Instant Feedback:** View obtained marks and access the correct answer keys for self-correction.

---

## 🛠️ Tech Stack & Architecture

This project adheres to the **MVC (Model-View-Controller)** design pattern to ensure code maintainability and separation of concerns.

* **Language:** Java (JDK 8+)
* **GUI Framework:** Java Swing (Desktop Interface)
* **Database:** MySQL
* **Architecture:** MVC Pattern
    * **Model:** Handles data logic and database interactions (JDBC).
    * **View:** The Swing UI forms (JFrames/JPanels) for user interaction.
    * **Controller:** Manages the flow of data between the View and the Model.

---

## 🚀 Installation & Setup

### Prerequisites
* [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/downloads/)
* [MySQL Server](https://dev.mysql.com/downloads/mysql/)
* IDE (NetBeans, Eclipse, or IntelliJ IDEA)

### Steps to Run
1.  **Clone the Repo**
    ```bash
    git clone [https://github.com/your-username/Learning-Assistant.git](https://github.com/your-username/Learning-Assistant.git)
    ```
2.  **Database Configuration**
    * Open your MySQL Workbench or Command Line.
    * Create a new database named `learning_db` (or name of your choice).
    * Import the `database_schema.sql` file provided in the root folder to create the necessary tables (`users`, `questions`, `marks`, etc.).
3.  **Connect Application**
    * Open the project in your IDE.
    * Navigate to the Database Connection class (e.g., `DBConnection.java`).
    * Update the URL, Username, and Password to match your local MySQL settings.
4.  **Run**
    * Execute the `Main.java` (or Login View) to start the application.

---

## 🔮 Future Scope

* **Real-time Chat:** Messaging system between student and teacher.
* **File Attachment:** Support for PDF/Image uploads for answers.
* **Analytics:** Graph views for student progress over the year.

---

## 🤝 Contributing

Contributions to improve the educational reach of this tool are welcome!

1.  Fork the project
2.  Create your Feature Branch
3.  Commit your Changes
4.  Push to the Branch
5.  Open a Pull Request

---

## 👤 Author

**[DNethmina]**

* GitHub: [@DNethmina](https://github.com/DNethmina)
