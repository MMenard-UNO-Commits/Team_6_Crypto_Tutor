import React, { useState, useEffect } from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import { useHistory } from 'react-router-dom';
//comment

export default function QuestionPage() {
  const [name, setName] = useState("");
  const [id, setID] = useState("");
  const [question, setQuestion] = useState("");
  const [codeFragment, setCodeFragment] = useState("");
  const [questions, setQuestions] = useState([]);
  const [past, setPast] = useState("");
  let history = useHistory();

  function validateForm() {
    return (
      name.length > 0 &&
      id.length > 0 &&
      question.length > 0 &&
      codeFragment.length > 0
    );
  }

  function handleSubmit(event) {
    event.preventDefault();
    console.log("form submitted");
    const ques = { name, id, question, codeFragment };
    fetch("http://104.131.172.9:8080/Jsoup-test/question/add", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(ques),
    }).then(() => {
      console.log("New Question added");
      history.push("/results");
    });
  }
  useEffect(() => {
    const pastURL = "http://104.131.172.9:8080/Jsoup-test/question/testJsoup ";
    //const currentURL = "http://localhost:8080/student/getAll2";
    const fetchPastData = async () => {
      try {
        //We put the await keyword just in front of it to tell the function to wait for
        //the fetch task to be done before running the next line of code.
        const response = await fetch(pastURL);
        var text = await response.text();
        var script =
          '<script language="JavaScript">' +
          "function ShowHide(divId) {" +
          "if(document.getElementById(divId).style.display == 'none') {" +
          "document.getElementById(divId).style.display='block';" +
          "} else {" +
          "document.getElementById(divId).style.display = 'none';" +
          "}" +
          "}" +
          "</script>";
        var finalText = text.concat(script);
        //setStudents(json);
        setPast(finalText);
        console.log(finalText);
      } catch (error) {
        console.log("error", error);
      }
    };

    fetchPastData();
  }, []);

  return (
    <div className="p-3 mb-2 bg-light bg-opacity-20 text-dark">
      <Form onSubmit={handleSubmit}>
        <Form.Group size="lg" controlId="ID">
          <Form.Label>Name</Form.Label>
          <Form.Control
            autoFocus
            className=".form-control-sm"
            type="name"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </Form.Group>
        <Form.Group size="lg" controlId="ID">
          <Form.Label>Student ID</Form.Label>
          <Form.Control
            autoFocus
            type="id"
            value={id}
            onChange={(e) => setID(e.target.value)}
          />
        </Form.Group>
        <Form.Group size="lg" controlId="password">
          <Form.Label>Question</Form.Label>
          <textarea
            className="form-control"
            type="question"
            placeholder="Type a Question"
            value={question}
            onChange={(e) => setQuestion(e.target.value)}
          />
        </Form.Group>
        <Form.Group size="lg" controlId="ID">
          <Form.Label>Code Fragment</Form.Label>
          <textarea
            className="form-control"
            type="description"
            placeholder="Enter code fragment"
            value={codeFragment}
            onChange={(e) => setCodeFragment(e.target.value)}
          />
        </Form.Group>
        <Button
          className="btn btn-info m-3"
          size="lg"
          type="submit"
          disabled={!validateForm()}
        >
          Submit
        </Button>
      </Form>
    </div>
  );
}