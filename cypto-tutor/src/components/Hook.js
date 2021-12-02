import React, { useEffect, useState, useContext } from "react";
import ReactDOM from "react-dom";
import $, { map } from "jquery";
import "react-gh-like-diff/dist/css/diff2html.min.css";
import { ReactGhLikeDiff } from "react-gh-like-diff";
import ReactDiffViewer from "react-diff-viewer";
import Parser from "html-react-parser";
import "bootstrap/dist/css/bootstrap.min.css";
import { ContextAPI } from "../ContextAPI";

function Hook() {
  const [past, setPast] = useContext(ContextAPI);

  const [html, setHtml] = useState("");
  const [parsedArray, setParsedArray] = useState([]);
  const [current, setCurrent] = useState("");
  const [array, setArray] = useContext(ContextAPI);

  // useEffect(() => {

  //   const fetchPastData = async () => {
  //     try {
  //       //We put the await keyword just in front of it to tell the function to wait for
  //       //the fetch task to be done before running the next line of code.
  //       setHtml(past);
  //       console.log(past);
  //       const parsed = $(past).find("div");
  //       console.log(html);

  //       for (let i = 0; i < parsed.length; i++) {
  //         parsedArray[i] = parsed[i].innerText;
  //       }
  //       setCurrent(parsedArray[0]);
  //       setPast(parsedArray[1]);
  //       console.log(parsedArray[1]);
  //     } catch (error) {
  //       console.log("error", error);
  //     }
  //   };

  //   fetchPastData();
  // }, []);

  return (
    <div>
      <ReactDiffViewer oldValue={array[0]} newValue={array[1]} splitView={true} useDarkTheme={true} />
    </div>
  );
}

export default Hook;