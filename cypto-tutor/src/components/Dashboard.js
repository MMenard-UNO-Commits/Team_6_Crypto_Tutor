import React, { useState, useEffect } from "react";
import Form from "react-bootstrap/Form";
import Select from "react-select";
import DisplayQuestions from "./DisplayQuestions";

export default function Dashboard() {

  const [users, setUsers] = useState([]);
  const [username, setUsername] = useState("");
  const [query, setQuery] = useState("");
  const [questions, setQuestions] = useState([]);
  const [questionMap, setQuestionMap] = useState();

  async function handleSubmit(event) {
    event.preventDefault();
    const data = new FormData();
    data.append("query", query);
    data.append("user", username);
    const response = await fetch("http://104.131.172.9:8080/back-end/question/getFilteredQuestions", {
      method: "POST",
      body: data
    });
    const pulledQuestions = await response.json();
    setQuestions(pulledQuestions);
    setQuestionMap(questions.map(question => <DisplayQuestions question={question} />));


  }

  async function pullUsers(){
    const response = await fetch("http://104.131.172.9:8080/users-test/user/getStudents");
    const test = await response.json();
    let tmpArray = [{value: "", label:"None"}];
    for (var i = 0; i < test.length; i++) {
      tmpArray.push({value: test[i], label: test[i]});
    }
    setUsers(tmpArray);
  }
  //fetch the array of users when the component is loaded.
  useEffect(() => {
    pullUsers();
  })

  function handleUserChange(value) {
    setUsername(value);
  }

    return(
      <div key="html">
      <h2 key="heading"> Dashboard </h2>
      <Form onSubmit = {handleSubmit}>
        <Form.Group size="lg" controlID="query">
        <Form.Label>Enter Query:</Form.Label>
          <textarea
              id="question"
              className="form-control"
              type="question"
              placeholder="Type a Query"
              value = {query}
              onChange={(e) => {setQuery(e.target.value)}}
            />
          </Form.Group>
      <Form.Group size="lg" controlID="user">
        <Form.Label>Select Username:</Form.Label>
        <Select options={users} 
                onChange={(e) => {handleUserChange(e.value)}}
                />
      </Form.Group>
        <input type="submit" value="submit"></input>
      </Form>
      <div>
        {questionMap}
      </div>
      </div>
    );
}