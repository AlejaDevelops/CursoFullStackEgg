
import { useContext } from "react"
import { UserContext } from "../context/UserContext"


export const HomeScreen = () => {

  const {user} = useContext( UserContext)

  return (
    <>
      <div className='container'>
      <table className="table table-striped">
        <thead>
          <tr>
            <th scope="col">Nombre</th>
            <th scope="col">Tecnología</th>
            <th scope="col">Email</th>
            <th scope="col">Redes sociales</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <th scope="row">{user.name}</th>
            <td>{user.tecnologia}</td>
            <td>{user.email}</td>
            <td>{user.rrss}</td>
          </tr>
          
        </tbody>
      </table>
      </div>
    </>
  )
}

