import React from 'react';
import {BrowserRouter} from "react-router-dom";
import './global.css'

import Routes from './routes';
import Header from './Header';

function App() {
  return (
    <div>
  
  <BrowserRouter>
    <Header></Header>
    
    <Routes/>
    </BrowserRouter>
    </div>
  );
}

export default App;