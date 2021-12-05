import React, { useState, useEffect, useContext } from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import { useHistory } from "react-router-dom";
import { ContextAPI } from "../ContextAPI";
import $, { map, jQuery } from "jquery";
import "./QuestionPage.css"
//comment

export default function QuestionPage() {
  const [username, setusername] = useState("");
  const [student_id, setStudent_id] = useState("");
  const [question, setQuestion] = useState("");
  const [codeFragment, setCodeFragment] = useState("");
  const [questions, setQuestions] = useState([]);
  const { past, setPast } = useContext(ContextAPI);

  const { parsedArray, setParsedArray } = useContext(ContextAPI);

  let history = useHistory();

  function validateForm() {
    return (
      username.length > 0 &&
      student_id.length > 0 &&
      question.length > 0 &&
      codeFragment.length > 0
    );
  }

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

    // console.log(doc);

    // setPast(finalText);
    // let array = [];

    // let parsed = $(finalText).find("div").toArray;
    // console.log(parsed[0]);

    // for (let i = 0; i < parsed.length; i++) {
    //   array[i] = parsed[i].innerText;
    //   console.log(array[i]);
    // }
    // setParsedArray(array[0]);

    // console.log(array.length);
    // console.log(array[0]);
    //setParsedArray(parsedArray.concat("My name is Milan"));
    //setParsedArray((parsedArray) => [...parsedArray, parsed[0]]);

    //console.log(parsedArray.array[0]);
    //console.log(parsedArray);
    //console.log(array.length);
    //console.log(parsed.length);

    history.push("/results");
  }

  return (
    <div className="p-3 mb-2 bg-light bg-opacity-20 text-dark">
      <Form onSubmit={handleSubmit}>
        <Form.Group size="lg" controlId="ID">
          <Form.Label>Name</Form.Label>
          <Form.Control
            autoFocus
            className=".form-control-sm"
            type="username"
            value={username}
            onChange={(e) => setusername(e.target.value)}
          />
        </Form.Group>
        <Form.Group size="lg" controlId="ID">
          <Form.Label>Student ID</Form.Label>
          <Form.Control
            autoFocus
            type="student_id"
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
            placeholder="Type a Question"
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
