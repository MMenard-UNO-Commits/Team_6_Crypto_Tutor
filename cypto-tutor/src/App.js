import "./App.css";
import React, { Component, useState } from "react";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import { LinkContainer } from "react-router-bootstrap";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import FooterComponent from "./components/FooterComponent";
import HeaderComponent from "./components/HeaderComponent";
import { AppContext, useAppContext } from "./lib/contextLib";
import Dashboard from "./components/Dashboard";
import Preferences from "./components/Preferences";
import Login from "./components/Login";
import Question from "./components/QuestionPage";
import useToken from "./components/useToken";
import NotFound from "./components/NotFound";
import Results from "./components/Results";
import Parser from "html-react-parser";
import { CheckboxesProvider } from "./ContextAPI";
import Hook from "./components/Hook";
import Diff2html from "./components/Diff2html";
//import Questionform from "./components/questionform";

function App() {
  const { token, setToken } = useToken();

  if (!token) {
    return <Login setToken={setToken} />; //If not logged in, shows this page until successful login
  }
  //Add route path to add new page to application
  //If improper route is specified in URL, returns 404 error page

  //Need better solution for logout button but it works for now
  return (
    <div className="wrapper">
      <CheckboxesProvider>
        <BrowserRouter>
          <Navbar>
            <LinkContainer to="/dashboard">
              <Navbar.Brand>CryptoTutor</Navbar.Brand>
            </LinkContainer>
            <Navbar.Toggle />
            <Navbar.Collapse>
              <Nav activeKey={window.location.pathname}>
                <LinkContainer to="/questionpage">
                  <Nav.Link>Ask Question</Nav.Link>
                </LinkContainer>
                <LinkContainer to="/">
                  <Nav.Link
                    onClick={() => {
                      localStorage.clear();
                      window.location.reload(false);
                    }}
                  >
                    Log Out
                  </Nav.Link>
                </LinkContainer>
              </Nav>
            </Navbar.Collapse>
          </Navbar>
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
            <Route path="/hook">
              <Hook />
            </Route>
            <Route path="/results">
              <Results />
            </Route>
            <Route path="/diff2html">
              <Diff2html />
            </Route>
            <Route>
              <NotFound />
            </Route>
          </Switch>
        </BrowserRouter>
      </CheckboxesProvider>
    </div>
  );
}

export default App;