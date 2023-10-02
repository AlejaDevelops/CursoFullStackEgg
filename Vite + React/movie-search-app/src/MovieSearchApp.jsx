import { Navigate, Route, Routes } from "react-router-dom"
import { HomeScreen } from "./routes/HomeScreen"
import { MovieDetailScreen } from "./routes/MovieDetailScreen"


export const MovieSearchApp = () => {

    
    return (
        <>        
        <Routes>
            <Route path="/" element={<HomeScreen to="HomeScreen"/>}></Route>
            <Route path="/detail/:id" element={<MovieDetailScreen/>}></Route>
            <Route path="/*" element={<Navigate to="/" />}></Route>
        </Routes>
        </>
    )
       
}

