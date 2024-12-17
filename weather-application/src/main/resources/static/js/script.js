function getWeather() {
    const city = document.getElementById("cityInput").value;
    if (city === "") {
        alert("Please enter a city name.");
        return;
    }

    // Backend API URL
    const apiUrl = `http://localhost:8080/api/weather/${city}`;

    fetch(apiUrl)
        .then(response => {
            if (!response.ok) {
                throw new Error("City not found. Please check the city name.");
            }
            return response.json();
        })
        .then(data => {
            displayWeather(data);
        })
        .catch(error => {
            alert(error.message);
        });
}

function displayWeather(data) {
    const weatherResult = document.getElementById("weatherResult");

    weatherResult.innerHTML = `
        <h2>Weather in ${data.name}</h2>
        <p><strong>Temperature:</strong> ${data.main.temp}°C</p>
        <p><strong>Humidity:</strong> ${data.main.humidity}%</p>
        <p><strong>Wind Speed:</strong> ${data.wind.speed} m/s</p>
    `;
}
