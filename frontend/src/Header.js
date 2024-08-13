
import React from 'react';
import { Link } from "react-router-dom";
import "./global.css"

export default function Header() {
  return (
    <div>

      <nav>
        <div className="nav-wrapper blue lighten-2">

          <Link to="/" className="brand-logo "> <i className="material-icons">style</i> Digilivros </Link>

          <ul id="nav-mobile" className="right hide-on-med-and-down ">

            <li><Link to="/aluno">Alunos</Link></li>
            <li><Link to="/aula">Aulas</Link></li>
            <li><Link to="/frequencia">Frequencias</Link></li>

          </ul>


        </div>
      </nav>

    </div>
  );
}





