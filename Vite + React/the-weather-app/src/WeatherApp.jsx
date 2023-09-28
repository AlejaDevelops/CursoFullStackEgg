import { useState } from "react"

export const WeatherApp = () => {

    const [city, setCity] = useState('')
    const [dataWeather, setDataWeather] = useState(null)
    const urlBase = 'https://api.openweathermap.org/data/2.5/weather'
    const apiKey = '4f4fbe750329699714171b323aa92dba'
    const tKelvin = 273.15

    const handleCityChange = (event) => {
        setCity(event.target.value)
    }

    const handleSubmit = (event) => {
        event.preventDefault()
        if (city.length > 0) fetchWeather()
    }

    const fetchWeather = async () => {
        try {
            const respuesta = await fetch(`${urlBase}?q=${city}&appid=${apiKey}`)
            const data = await respuesta.json()
            setDataWeather(data)
            console.log(dataWeather)
        } catch (error) {
            console.error('Ocurrió el siguiente problema: ', error)
        }
    }



    return (
        <div className="container">
            <h1>Weather app</h1>

            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    value={city}
                    onChange={handleCityChange}
                />
                <button type="submit">Buscar</button>
            </form>

            {
                dataWeather && (
                    <div>
                        <h2>{dataWeather.name}</h2>
                        <p>Temperature: {parseInt(dataWeather?.main?.temp - tKelvin)}°C</p>
                        <p>Condition: {dataWeather.weather[0].description}</p>
                        <img src={`https://openweathermap.org/img/wn/${dataWeather.weather[0].icon}@2x.png`} alt="" />


                    </div>
                )

            }

        </div>
    )
}
