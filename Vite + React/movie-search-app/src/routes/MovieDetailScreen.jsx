import { useEffect, useState } from "react"
import { NavLink, useParams } from "react-router-dom"

export const MovieDetailScreen = () => {

  const { id } = useParams()
  const [movieDetail, setMovieDetail] = useState([])
  const basicUrl = 'https://api.themoviedb.org/3/movie'
  const apiKey = '72aec599a2ad67ba40cc74d6fe36a1db'

  const movieDetailFetch = async () => {
    try {

      const response = await fetch(`${basicUrl}/${id}?api_key=${apiKey}`)
      const data = await response.json()
      setMovieDetail([data])

    } catch (error) {
      console.error('Ha ocurrido un error: ', error)
      setMovieDetail([])
    }
  }

  useEffect(() => {
    movieDetailFetch()
  }, [id])
  console.log(movieDetail)




  return (
    <>
      <div className="container">
        {movieDetail !== null ? (
          movieDetail.map((item) => (
            <div key={item.id} className="movie-card">
              <img src={`https://image.tmdb.org/t/p/w500${item.poster_path}`} alt={item.title} />
              <h3>{item.title}</h3>
              <div className="genres">
                {item.genres.map((genre) => (
                  <span key={genre.id}>{genre.name}, </span>
                ))}
              </div>
              <ul  className="principal-details">
                <li>Runtime: {item.runtime} min</li>
                <li>Lenguage: {item.original_language}</li>
                <li>Premiere: {item.release_date}</li>
                <li>Budget: US {item.budget.toLocaleString()}</li>
                <li>Revenues: US {item.revenue.toLocaleString()}</li>
                <li>Overview: {item.overview}</li>
              </ul>
              <div>
                  <h5>Belongs to "{item.belongs_to_collection.name}"" </h5>                  
                  <img src={`https://image.tmdb.org/t/p/w500${item.belongs_to_collection.poster_path}`} alt={item.title} ></img>
                  

              </div>
            </div>
          ))
        ) : (
          <p>Loading...</p> // Muestra un mensaje de carga mientras se cargan los datos
        )}
        <div>
        <NavLink to="/"><button>Regresar</button></NavLink>
      </div>
      </div>

      
    </>
  )
}
