import { useState } from "react";
import { UserList } from "./UserList";

export const UsersAppTwo = () => {
  const [endPoint, setEndPoint] = useState("users");

  const handleFetch = () => {
    setEndPoint("comments");
  };

  return (
    <>
      <h1>Lista de usuarios: </h1>
      <UserList endPoint={endPoint}></UserList>
      <button onClick={handleFetch}>Llamar la lista</button>
    </>
  );
};

/*TRAE UNA LISTA DE USUARIOS DESDE UNA FALSA API AL HACER CLICK EN UN BOTÓN */
