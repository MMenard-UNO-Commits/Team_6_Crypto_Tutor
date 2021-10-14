import React from "react";
import { Route, Switch } from "react-router-dom";
import Login from "./components/Login";
import Question from "./components/QuestionPage"

export default function Routes() {
  return (
    <Switch>
      <Route exact path="/login">
        <Login />
      </Route>
      <Route exact path ="/questionpage">
          <Question />
      </Route>
    </Switch>
  );
}
