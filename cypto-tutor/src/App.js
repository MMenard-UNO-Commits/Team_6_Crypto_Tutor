import "./App.css";
import React, { Component, useState } from "react";
import Routes from "./Routes";
import Nav from "react-bootstrap/Nav";
import { LinkContainer } from "react-router-bootstrap";
import FooterComponent from "./components/FooterComponent";
import HeaderComponent from "./components/HeaderComponent";
import { AppContext, useAppContext } from "./lib/contextLib";
//import Questionform from "./components/questionform";

function App() {
  const [isAuthenticated, userHasAuthenticated] = useState(false);
  function handleLogout() {
    userHasAuthenticated(false);
  }
  return (
    <div className="p-3 mb-2 bg-light bg-opacity-50 text-dark">
      {isAuthenticated ? (
        <Nav.Link onClick={handleLogout}>Logout</Nav.Link>
      ) : (
        <>
          <LinkContainer to="/signup">
            <Nav.Link>Signup</Nav.Link>
          </LinkContainer>
          <LinkContainer to="/login">
            <Nav.Link>Login</Nav.Link>
          </LinkContainer>
        </>
      )}
      <HeaderComponent />
      <FooterComponent />
      <AppContext.Provider value={{ isAuthenticated, userHasAuthenticated }}>
        <Routes />
      </AppContext.Provider>
    </div>
  );
}

export default App;
