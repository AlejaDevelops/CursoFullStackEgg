const Items = ({ nombre, activo }) => {
  return (
    <li>
      {nombre}
      {activo && "😃"}
    </li>
  );
};

export const ListadoApp = () => {
  return (
    <>
      <h1>Listado de Personas</h1>
      <ol>
        <Items nombre="Aleja" activo={false}></Items>
        <Items nombre="Juan" activo={false}></Items>
        <Items nombre="Paola" activo={true}></Items>
        <Items nombre="Pepe" activo={false}></Items>
        <Items nombre="Ale" activo={true}></Items>
        <Items nombre="David" activo={false}></Items>
        <Items nombre="Luis" activo={true}></Items>
        <Items nombre="Paco" activo={false}></Items>
        <Items nombre="Hugo" activo={false}></Items>
        <Items nombre="Robert" activo={true}></Items>
        <Items nombre="Bobby" activo={false}></Items>
        <Items nombre="Clara" activo={true}></Items>
        <Items nombre="Sol" activo={false}></Items>
        <Items nombre="Betty" activo={true}></Items>
        <Items nombre="Luz" activo={true}></Items>
        <Items nombre="Ana" activo={false}></Items>
      </ol>
    </>
  );
};
