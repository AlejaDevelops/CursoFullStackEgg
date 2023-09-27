import { useEffect, useState } from "react";

export const UsersApp = () => {
  const [users, setUsers] = useState([]);

  const fetchUsers = async () => {
    try {
      const response = await fetch(
        "https://jsonplaceholder.typicode.com/users"
      );
      const data = await response.json();
      console.log(data);
      setUsers(data);
    } catch (error) {
      console.log(error);
    }
  };

  const handleFetch = () => {
    fetchUsers();
  };

  //useEffect(() => {
  // fetchUsers();
  // }, []); //Sirve para que no se ejecute muchas veces el método(efecto secundario de algo)

  return (
    <>
      <h1>Lista de usuarios: </h1>
      <ul>
        {users.map((user) => (
          <li key={user.id}>
            Nombre: {user.name}
            Usuario: {user.username}
          </li>
        ))}
      </ul>

      <button onClick={handleFetch}>Llamar la lista</button>
    </>
  );
};

/*TRAE UNA LISTA DE USUARIOS DESDE UNA FALSA API AL HACER CLICK EN UN BOTÓN */
