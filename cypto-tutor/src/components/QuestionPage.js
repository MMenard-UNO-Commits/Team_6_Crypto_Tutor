//Form to submit questions to the database

//Takes user's username, student ID, question, and a code fragment,
//inserts them into the database, then queries the database for any
//questions present that are similar to the one that was just sumbmitted

import React, { useState, useContext } from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import { useHistory } from "react-router-dom";
import { ContextAPI } from "../ContextAPI";
import "./QuestionPage.css"

export default function QuestionPage() {
  const [username, setusername] = useState("");
  const [student_id, setStudent_id] = useState("");
  const [question, setQuestion] = useState("");
  const [codeFragment, setCodeFragment] = useState("");
  const { setPast } = useContext(ContextAPI);

  const { parsedArray, setParsedArray } = useContext(ContextAPI);

  let history = useHistory();

  //Checks form to make sure values were entered in each box
  function validateForm() {
    return (
      username.length > 0 &&
      student_id.length > 0 &&
      question.length > 0 &&
      codeFragment.length > 0
    );
  }

  //POSTs form to the database then redirects user to results page of similar questions
  async function handleSubmit(event) {
    event.preventDefault();
    console.log("form submitted");
    const ques = { username, student_id, question, codeFragment };
    const response = await fetch(
      "http://104.131.172.9:8080/back-end/question/add",
      {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(ques),
      }
    );
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
    setPast(finalText);

    const parser = new DOMParser();

    const doc = parser.parseFromString(finalText, "text/html");
    const parsed2 = doc.getElementsByTagName("div");
    console.log(parsed2.length);
    let array = [];

    for (let i = 0; i < parsed2.length; i++) {
      array[i] = parsed2[i].innerText;
    }
    console.log(array.length)
    setParsedArray(array);
    console.log(parsedArray);
    history.push("/results");
  }

  //Renders the page
  return (
    <div className="p-3 mb-2 bg-light bg-opacity-20 text-dark">
      <h4 key="heading" className="h4"> Ask Questions </h4>
      <Form onSubmit={handleSubmit}>
        <Form.Group size="lg" controlId="ID">
          <Form.Label>Username</Form.Label>
          <Form.Control
            autoFocus
            className=".form-control-sm"
            type="username"
            placeholder="Enter your username"
            value={username}
            onChange={(e) => setusername(e.target.value)}
          />
        </Form.Group>
        <Form.Group size="lg" controlId="ID">
          <Form.Label>Student ID</Form.Label>
          <Form.Control
            autoFocus
            type="student_id"
            placeholder="Enter your student ID"
            value={student_id}
            onChange={(e) => setStudent_id(e.target.value)}
          />
        </Form.Group>
        <Form.Group size="lg" controlId="password">
          <Form.Label>Question</Form.Label>
          <textarea
            id="question"
            className="form-control"
            type="question"
            placeholder="Enter your question"
            value={question}
            onChange={(e) => setQuestion(e.target.value)}
          />
        </Form.Group>
        <Form.Group size="lg" controlId="ID">
          <Form.Label>Code Fragment</Form.Label>
          <textarea
            id="codefragment"
            className="form-control"
            type="description"
            placeholder="Enter a code fragment"
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
