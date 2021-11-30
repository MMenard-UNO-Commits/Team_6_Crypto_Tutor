import React, { useEffect, useState, useRef, useContext } from "react";
import { ReactGhLikeDiff } from "react-gh-like-diff";
import "react-gh-like-diff/dist/css/diff2html.min.css";
import Hook from "./Hook";
import { useHistory } from 'react-router-dom'; 
import { ContextAPI } from "../ContextAPI";

function Results() {
  //const { setTest } = useContext(ContextAPI);
  // const [test, setTest] = useContext(ContextAPI);
  //console.log(test);
  //const [test, setTest] = useContext(ContextAPI);
  //const value = useContext(ContextAPI);
  //console.log(value);

  let history = useHistory();
  const [current, setCurrent] = useState("");
  const [past, setPast] = useState("");
  const [checkboxes, setCheckboxes] = useState([]);

  useEffect(() => {
    const pastURL = "http://104.131.172.9:8080/Jsoup-test/question/testJsoup";
    // const currentURL = "http://localhost:8080/student/getAll2";
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
      } catch (error) {
        console.log("error", error);
      }
    };

    fetchPastData();
  }, []);

  function handleSubmit(e) {
    let a = "Hello";
    let b = "hi";
    const checkboxes = { a, b };
    //setTest(checkboxes);
    history.push("/hook");
  }

  return (
    <div>
      <div dangerouslySetInnerHTML={{ __html: past }} />;
      <button onClick={handleSubmit} type="button" className="btn btn-primary">
        diff2html
      </button>
    </div>
  );
}

export default Results;