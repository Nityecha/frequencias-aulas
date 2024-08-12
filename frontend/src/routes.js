import React from "react";
import { Route, Switch } from "react-router-dom";

import Book from "./componets/Book";
import Rent from "./componets/Rent";
import Dash from "./componets/Dash";
import Home from "./componets/Home";
import Aluno from "./componets/Aluno";



export default function  Routes() {
  return (
     
      <Switch>
        <Route path="/" exact component={Home} />
        <Route path="/book" component={Book} />
        <Route path="/aluno" component={Aluno} />
        <Route path="/rent" component={Rent} />
        <Route path="/dash" component={Dash} />
      </Switch>
    
  );
}