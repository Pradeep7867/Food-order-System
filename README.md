
# 🛒 Food Ordering System (Java Console Application)

## 📌 Overview
This is a **console-based food ordering system** implemented in **Java** using the **MVC architecture**. It allows users to place orders, manage restaurants, and process orders efficiently.  

---

## 📂 Project Structure
📦 FoodOrderingSystem │── 📁 src │ ├── 📁 com.foodorderingsystem │ │ ├── 📁 controller │ │ │ ├── FoodOrderingController.java │ │ ├── 📁 model │ │ │ ├── Order.java │ │ │ ├── User.java │ │ ├── 📁 service │ │ │ ├── OrderService.java │ │ │ ├── RestaurantService.java │ │ ├── 📁 strategy │ │ │ ├── LowestCostStrategy.java │ │ ├── App.java │── 📄 README.md │── 📄 .gitignore │── 📄 pom.xml (If using Maven) │── 📄 build.gradle (If using Gradle)
---

## 🛠 Prerequisites
Before running this project, ensure you have:
- **Java 17+** installed 👉 [Download Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)  
- A Java IDE (**IntelliJ IDEA, Eclipse, VS Code**) or terminal with **javac** and **java** installed  

---

## 🚀 How to Run the Project  

### 

**1️⃣ Clone the Repository**
```sh
git clone https://github.com/Pradeep7867/Food-order-System.git
cd FoodOrderingSystem

2️⃣ Compile the Java Files
javac -d out -sourcepath src src/com/foodorderingsystem/App.java


3️⃣ Run the Application
java -cp out com.foodorderingsystem.App


If using Maven:
mvn clean install
mvn exec:java -Dexec.mainClass="com.foodorderingsystem.App"


This `README.md` is formatted correctly for **GitHub** and provides **clear instructions** for running the application. Let me know if you need any adjustments! 🚀
