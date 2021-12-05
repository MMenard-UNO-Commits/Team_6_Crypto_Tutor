import React, { useContext, useState } from "react";
import { ContextAPI } from "../ContextAPI";
import { useHistory } from "react-router-dom";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";

export default function Results() {
  const { past, setPast } = useContext(ContextAPI);

  const { code1, setCode1 } = useContext(ContextAPI);
  const { code2, setCode2 } = useContext(ContextAPI);
  let history = useHistory();
  const { selectedCodeFragment1, setSelectedCodeFragment1 } =
    useContext(ContextAPI);
  const { selectedCodeFragment2, setSelectedCodeFragment2 } =
    useContext(ContextAPI);
  const { parsedArray, setParsedArray } = useContext(ContextAPI);

 

  function handleSubmit(e) {
    e.preventDefault();
    setCode1(parsedArray[selectedCodeFragment1 - 1]);
    setCode2(parsedArray[selectedCodeFragment2 - 1]);


    history.push("/hook");
  }

  return (
    <div>
      <div dangerouslySetInnerHTML={{ __html: past }} />
      <h1>Please Enter the code Fragment Number you would like to compare:</h1>
      <Form onSubmit={handleSubmit}>
        <Form.Group size="lg">
          <Form.Label>Code Fragment Number</Form.Label>
          <textarea
            autoFocus
            type="text"
            className="form-control"
            onChange={(e) => setSelectedCodeFragment1(e.target.value)}
          />
        </Form.Group>

        <Form.Group size="lg">
          <Form.Label>Code Fragment Number </Form.Label>

          <textarea
            autoFocus
            type="text"
            className="form-control"
            onChange={(e) => setSelectedCodeFragment2(e.target.value)}
          />
        </Form.Group>

        <Button className="btn btn-info m-3" size="lg" type="submit">
          Submit
        </Button>
      </Form>
    </div>
  );
}
