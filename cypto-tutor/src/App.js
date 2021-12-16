//Main application

//Contains routers to each component that is allowed to be displayed on the webpage

//To add a new component, import it, then add it as a new route in the Switch below

import "./App.css";
import React from "react";
import Navbar from "react-bootstrap/Navbar";
import Nav from "react-bootstrap/Nav";
import { LinkContainer } from "react-router-bootstrap";
import { BrowserRouter, Route, Switch } from "react-router-dom";
import Dashboard from "./components/Dashboard";
import Preferences from "./components/Preferences";
import Question from "./components/QuestionPage";
import NotFound from "./components/NotFound";
import Results from "./components/Results";
import { CheckboxesProvider } from "./ContextAPI";
import Hook from "./components/Hook";
import {Helmet} from 'react-helmet';

function App() {

  //Dummied out login function

  //const { token, setToken } = useToken();

  //if (!token) {
  //  return <Login setToken={setToken} />; //If not logged in, shows this page until successful login
  //}

  //Renders the webpage
  return (
    <div className="container">
      <Helmet>
        <style>{'body { background-color: rgb(213, 213, 213); }'}</style>
      </Helmet>
      <CheckboxesProvider>
        <BrowserRouter>
          <Navbar collapseOnSelect>
            <LinkContainer to="/dashboard">
              <Navbar.Brand className="test">📖CryptoTutor</Navbar.Brand>
            </LinkContainer>
            <Navbar.Toggle />
            <Navbar.Collapse>
              <Nav>
                <LinkContainer to="/dashboard">
                  <Nav.Link>🔍Search Questions</Nav.Link>
                </LinkContainer>
                <LinkContainer to="/questionpage">
                  <Nav.Link>❓Ask Question</Nav.Link>
                </LinkContainer>
                {/*<LinkContainer to="/">
                  <Nav.Link
                    onClick={() => {
                      localStorage.clear();
                      window.location.reload(false);
                    }}
                  >
                    Log Out
                  </Nav.Link>
                  </LinkContainer>*/}
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