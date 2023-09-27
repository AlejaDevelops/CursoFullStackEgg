import { useFetchData } from "../Hooks/useFetchData";

export const UserList = ({ endPoint }) => {
  const { data, isLoading } = useFetchData(endPoint);

  return (
    <>
      <ul>
        {isLoading ? (
          <p>Está cargando...</p>
        ) : endPoint == "users" ? (
          data.map((item) => <li key={item.id}>{item.name}</li>)
        ) : (
          data.map((item) => <li key={item.id}>{item.body}</li>)
        )}
      </ul>
    </>
  );
};
