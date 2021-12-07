import React, { useContext } from "react";
import { ContextAPI } from "../ContextAPI";
import { useHistory } from "react-router-dom";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";
import "./Results.css";

export default function Results() {
  const { past } = useContext(ContextAPI);

  const { setCode1 } = useContext(ContextAPI);
  const { setCode2 } = useContext(ContextAPI);
  let history = useHistory();
  const { selectedCodeFragment1, setSelectedCodeFragment1 } =
    useContext(ContextAPI);
  const { selectedCodeFragment2, setSelectedCodeFragment2 } =
    useContext(ContextAPI);
  const { parsedArray } = useContext(ContextAPI);

 

  function handleSubmit(e) {
    e.preventDefault();
    setCode1(parsedArray[selectedCodeFragment1 - 1]);
    setCode2(parsedArray[selectedCodeFragment2 - 1]);


    history.push("/hook");
  }

  return (
    <div className="p-3 mb-2 bg-light bg-opacity-20 text-dark" style={{resize: "both", overflow: "auto"}}>
      <h2 className="h2">Results</h2>
      <div dangerouslySetInnerHTML={{ __html: past }} />
      <h2 className="h2">Choose two code fragments to compare:</h2>
      <Form onSubmit={handleSubmit}>
        <Form.Group size="lg">
          <Form.Label>Code Fragment Number</Form.Label>
          <Form.Control
            autoFocus
            type="text"
            className="form-control"
            onChange={(e) => setSelectedCodeFragment1(e.target.value)}
          />
        </Form.Group>

        <Form.Group size="lg">
          <Form.Label>Code Fragment Number </Form.Label>

          <Form.Control
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
