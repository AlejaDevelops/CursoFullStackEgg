import { useState } from "react"

export const HomeScreen = () => {

      //VARIABLES
      const [movieName, setMovieName] = useState('') //Inicialización del movieName vacío, se llenará con la info que se llene en el input
      const [movieData, setMovieData] = useState([]) //Inicialización de la movieData vacía, se llenará con la info que traiga el fetch
      const basicUrl = 'https://api.themoviedb.org/3/search/movie'
      const apiKey = '72aec599a2ad67ba40cc74d6fe36a1db'
  
      //METODOS
      const handleInputChange = (e) => { //Carga en el movieName el texto recibido en el input (value)
          setMovieName(e.target.value)
      }
  
  
      const handleSubmit = (e) => { //Una vez el usuario oprime submit, se ejecuta este manejador del submit: previene que se recargue la página y llama al fetch 
          e.preventDefault()
          searchFetch()
      }
  
      const searchFetch = async () => {
          try {
              const response = await fetch(`${basicUrl}?query=${movieName}&api_key=${apiKey}`)
              const data = await response.json()
              setMovieData(data.results) //Establece solo el array de resultados en movieDATA
              console.log(data.results)
          } catch (error) {
              console.error('Ha ocurrido un error: ', error)
              setMovieData([]) // Establece movieData como un array vacío en caso de error
  
          }
  
      }
  
  
      return (
          <div className="container">
              <h1>Movie search</h1>
              <form action="" onSubmit={handleSubmit}>
                  <input
                      type="text"
                      placeholder="Write a title"
                      value={movieName}
                      onChange={handleInputChange}
                  />
                  <button type="submit" className="search-button">Search</button>
              </form>
              <div className="movie-list">
                  {movieData !== null ? (
                      movieData.map((item) => (
                          <div key={item.id} className="movie-card">
                              <img src={`https://image.tmdb.org/t/p/w500${item.poster_path}`} alt={item.title} />
                              <h2>{item.title}</h2>
                              <p>{item.overview.length > 150 ? `${item.overview.slice(0, 150)}...` : item.overview}</p>
                              <button>Ver detalle</button>
                          </div>
                      ))
                  ) : (
                      <p>Loading...</p> // Muestra un mensaje de carga mientras se cargan los datos
                  )}
              </div>  
          </div>
      )
  }
