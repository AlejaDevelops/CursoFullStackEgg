import React from 'react'
import ReactDOM from 'react-dom/client'
import './styles/styles.css'
import { MovieSearchApp } from './movieSearchApp'
import { BrowserRouter } from 'react-router-dom'

ReactDOM.createRoot(document.getElementById('root')).render(
  <BrowserRouter>
  <React.StrictMode>
    <MovieSearchApp />
  </React.StrictMode>
  </BrowserRouter>
  ,
)
