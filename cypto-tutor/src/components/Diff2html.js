import React, { useContext, useState, useEffect } from "react";
import { CheckboxesProvider, ContextAPI } from "../ContextAPI";
import { useHistory } from "react-router-dom";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";

function Diff2html() {
  const { code1, setCode1 } = useContext(ContextAPI);
  const { code2, setCode2 } = useContext(ContextAPI);
  let history = useHistory();
  const { selectedCodeFragment1, setSelectedCodeFragment1 } =
    useContext(ContextAPI);
  const { selectedCodeFragment2, setSelectedCodeFragment2 } =
    useContext(ContextAPI);
  const { parsedArray, setParsedArray } = useContext(ContextAPI);

  

  return (
    <div>
     
    </div>
  );
}

export default Diff2html;
