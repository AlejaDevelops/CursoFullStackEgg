import { NavLink } from "react-router-dom";
import portal from "../assets/portal.png";
import rickMorty from "../assets/rickMorty.png";
import "../styles/style.css";

export const Navbar = () => {
  return (
    <header data-bs-theme="dark">
      <nav className="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
        <div className="container-fluid">
          <div className="grupoImagenes">
            <img src={portal} width={110} className="rotating-image" />
            <img src={rickMorty} width={90} className="rickAndMorty" />
          </div>
          <div className="collapse navbar-collapse" id="navbarCollapse">
            <ul className="navbar-nav me-auto mb-2 mb-md-0">
              <li className="nav-item">
                <NavLink
                  to="/"
                  className="nav-link active"
                  aria-current="page"
                  href="#"
                >
                  Home
                </NavLink>
              </li>
              <li className="nav-item">
                <NavLink to="/detail" className="nav-link" href="#">
                  Details
                </NavLink>
              </li>
              <li className="nav-item">
                <NavLink to="/page2" className="nav-link" href="#">
                  Página 2
                </NavLink>
              </li>
            </ul>
          </div>
        </div>
      </nav>
    </header>
  );
};
