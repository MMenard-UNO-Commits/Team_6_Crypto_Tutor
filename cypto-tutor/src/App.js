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

  //Dummied out login functionality

  //const { token, setToken } = useToken();

  //if (!token) {
  //  return <Login setToken={setToken} />; //If not logged in, shows this page until successful login
  //}
  //Add route path to add new page to application
  //If improper route is specified in URL, returns 404 error page

  //Need better solution for logout button but it works for now
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