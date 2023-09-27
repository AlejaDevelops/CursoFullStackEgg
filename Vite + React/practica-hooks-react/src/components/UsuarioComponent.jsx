import React from "react";
import { useFetch } from "../hooks/useFetch";

export const UsuarioComponent = () => {
  const { data, isLoading, error } = useFetch("https://jsonplaceholder.typicode.com/users");

  return (
    <>
      <h4>Tabla de usuarios</h4>
      {isLoading ? (
        <h4>Cargando...</h4>
      ) : error ? (
        <p>Ha ocurrido un error: {error.message}</p>
      ) : (
        <table className="table table-dark table-sm">
          <thead>
            <tr>
              <th scope="col">Id</th>
              <th scope="col">Name</th>
              <th scope="col">Email</th>
              <th scope="col">Website</th>
            </tr>
          </thead>
          <tbody>
            {data.map((user) => (
              <tr key={user.id}>
                <th scope="row">{user.id}</th>
                <td>{user.name}</td>
                <td>{user.email}</td>
                <td>{user.website}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </>
  );
};


/*
import { useFetch } from "../hooks/useFetch"


export const UsuarioComponent = () => {

    //const { data, isLoading, errors } = useFetch('https://jsonplaceholder.typicode.com/users')

    return (
        <>

            <table className="table table-dark table-sm">
                <thead>
                    <tr>
                        <th scope="col">Id</th>
                        <th scope="col">Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">Website</th>
                    </tr>
                </thead>
                <tbody>

                    <tr >
                        <th scope="row">1</th>
                        <td>1</td>
                        <td>1</td>
                        <td>1</td>
                    </tr>


                </tbody>
            </table>


        </>
    )
} */



