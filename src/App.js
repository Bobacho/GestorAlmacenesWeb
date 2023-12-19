import './App.css';
import './Login/Textboxes/TextboxLogin'
import TextboxLogin from './Login/Textboxes/TextboxLogin';
import Login from './Login/Login';
import {Route, Routes, BrowserRouter} from 'react-router-dom'
import React from 'react';
import Home from './Menu/Home'

function App() {
  const loginPaths=["/","/login"]
  const loginRoutes= () =>{
    return loginPaths.map( path =>(
        <Route path={path} Component={Login}/>)
    );
  }

  return (
    <Routes>
      {loginRoutes()}
      <Route path="/home" Component={Home}/>
    </Routes>
  );
}

export default App;
