import "./App.css";
import React, { Component, useState } from "react";
import Nav from "react-bootstrap/Nav";
import { LinkContainer } from "react-router-bootstrap";
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import FooterComponent from "./components/FooterComponent";
import HeaderComponent from "./components/HeaderComponent";
import { AppContext, useAppContext } from "./lib/contextLib";
import Dashboard from './components/Dashboard';
import Preferences from './components/Preferences';
import Login from "./components/Login";
import Question from "./components/QuestionPage";
import useToken from './components/useToken';
import Parser from 'html-react-parser';
//import Questionform from "./components/questionform";

function App() {
  const {token, setToken} = useToken();
  if(!token) {
    return <Login setToken={setToken} /> //If not logged in, shows this page until successful login
  }
  return (
    <div className="wrapper">
      <h1>CryptoTutor</h1>
      <BrowserRouter>
        <Switch>
          <Route path="/dashboard">
            <Dashboard />
          </Route>
          <Route path="/preferences">
            <Preferences />
          </Route>
          <Route path="/questionpage">
            <Question />
          </Route>
        </Switch>
      </BrowserRouter>
    </div>
  );
}

export default App;
