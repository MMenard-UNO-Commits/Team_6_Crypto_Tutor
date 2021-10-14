import "./App.css";
import React, { Component } from "react";
import Routes from "./Routes";

//import Questionform from "./components/questionform";

class App extends Component {
  render() {
    return (
      <div className="p-3 mb-2 bg-light bg-opacity-50 text-dark">
        <Routes />
      </div>
    );
  }
}

export default App;
