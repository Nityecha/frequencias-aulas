import React from "react";
import { Route, Switch } from "react-router-dom";

import Book from "./componets/Book";

import Dash from "./componets/Dash";
import Home from "./componets/Home";
import Aluno from "./componets/Aluno";
import Frequencia from "./componets/Frequencia";



export default function  Routes() {
  return (
     
      <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/book" component={Book} />
        <Route path="/aluno" component={Aluno} />
        <Route path="/frequencia" component={Frequencia} />
        <Route path="/dash" component={Dash} />
      </Switch>
    
  );
}