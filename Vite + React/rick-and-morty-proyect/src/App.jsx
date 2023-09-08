import { Navigate, Route, Routes } from "react-router-dom";
import { Navbar } from "./components/Navbar";
import { Home } from "./components/Home";
import { Detail } from "./components/Detail";
import { Page2 } from "./components/Page2";

export const App = () => {
  return (
    <>
      <Navbar></Navbar>
      <Routes>
        <Route path="/" element={<Home to="Home" />} />
        <Route path="/detail" element={<Detail to="Detail" />} />
        <Route path="/page2" element={<Page2 to="Page2" />} />
        <Route path="/*" element={<Navigate to="/" />} />
        <Route path="/detail/:id" element={<Detail />} />
      </Routes>
    </>
  );
};
