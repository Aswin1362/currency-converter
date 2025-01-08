# Currency Converter API

## Description

A Spring Boot application that converts currencies using external exchange rates.

---

## Prerequisites

1. **JDK 17 or higher**  
   Download and install Java 17 from [Oracle](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or [OpenJDK](https://openjdk.org/).

2. **Maven 3.6 or higher**  
   Download and install Maven from [Maven Downloads](https://maven.apache.org/download.cgi).

3. **Spring Boot Project Setup**  
   Download a Spring Boot project ZIP from [Spring Initializr](https://start.spring.io/):
   - Set the **Group** to `com.example` or your preferred package name.
   - Set the **Artifact** to `currency-converter`.
   - Add dependencies for:
     - Spring Web
     - Spring Boot DevTools
     - Spring Boot Actuator (optional)
   - Click **Generate** to download the project as a ZIP file.
   - Extract the ZIP file to your desired folder.

4. **Git**  
   Clone the repository after setting up the Spring Boot project.

---

## Running the Application

### Step 1: Clone the Repository

After downloading the Spring Boot ZIP and extracting it, initialize a Git repository in the same folder:

```bash
git init
git remote add origin https://github.com/yourusername/currency-converter.git
git pull origin main
```

### Step 2: Configure the Application

Edit the `application.properties` file to include your API access key:

```properties
exchange.api.url=http://api.exchangeratesapi.io/v1/latest
exchange.api.accessKey=your_access_key
server.port=8080
```

Replace `your_access_key` with your actual API key.

---

### Step 3: Install Dependencies

Run the following command to install all necessary dependencies:

```bash
mvn install
```

---

### Step 4: Run the Application

Start the application by running:

```bash
mvn spring-boot:run
```

The application will be available at [http://localhost:8080](http://localhost:8080).


## Git Repository
You can find the source code at the following link:
[Currency Converter API](https://github.com/Aswin1362/currency-converter.git)


