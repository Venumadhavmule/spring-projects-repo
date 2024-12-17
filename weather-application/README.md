# Weather Application

This is a **Spring Boot-based Weather Application** that fetches real-time weather data from the **OpenWeatherMap API** and displays it on a clean, user-friendly frontend.

---

## Features

- Fetches **real-time weather information** for any city.
- Displays:
  - Temperature
  - Weather conditions (e.g., sunny, cloudy, rainy)
  - Humidity
- Simple and interactive **UI** for a smooth user experience.

---

## Technologies Used

- **Backend**: Spring Boot (REST API)
- **Frontend**: HTML, CSS, JavaScript
- **API Integration**: OpenWeatherMap API

---

## Prerequisites

Before running the project, ensure you have:

1. **Java** (JDK 8+): [Download Java](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
2. **Maven**: [Install Maven](https://maven.apache.org/)
3. **API Key** from OpenWeatherMap: [Get API Key](https://openweathermap.org/api)

---

## Project Setup and Run Instructions

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/yourusername/your-repo-name.git
   cd your-repo-name/weather-application
2. **Update the API Key:**:
 Open src/main/resources/application.properties and replace YOUR_API_KEY with your OpenWeatherMap API key: weather.api.key=YOUR_API_KEY
3. **Build the Project:**:
Run the following Maven command to clean and build the proje mvn clean install
4. **Run the Application:**:
Start the Spring Boot application using:mvn spring-boot:run
5. **Access the Application:**:
Open your browser and navigate to: http://localhost:8080

