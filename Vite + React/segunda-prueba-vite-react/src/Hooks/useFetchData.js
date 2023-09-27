import { useEffect, useState } from "react";
import { cargafetch } from "../Helpers/cargaFetch";

export const useFetchData = (endPoint) => {
  const [data, setData] = useState([]);
  const [isLoading, setIsLoading] = useState(true);

  const getData = async () => {
    const { data, isLoading } = await cargafetch(endPoint);
    setData(data);
    setIsLoading(isLoading);
  };

  useEffect(() => {
    getData();
  }, [endPoint]);

  return {
    data,
    isLoading,
  };
};

/*MODO PROMESA
  useEffect(() => {
    cargafetch(endPoint).then(res =>{
      setData(res.data)
      setIsLoading(res.isLoading)
    })
  }, [endPoint]);

*/
