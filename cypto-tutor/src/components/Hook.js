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
  const [test, setTest] = useContext(ContextAPI);
  const value = useContext(ContextAPI);

  const [html, setHtml] = useState("");
  const [parsedArray, setParsedArray] = useState([]);
  const [current, setCurrent] = useState("");
  const [past, setPast] = useState("");

  useEffect(() => {
    const pastURL = "http://104.131.172.9:8080/Jsoup-test/question/testJsoup";

    const fetchPastData = async () => {
      try {
        //We put the await keyword just in front of it to tell the function to wait for
        //the fetch task to be done before running the next line of code.
        const response = await fetch(pastURL);
        const text = await response.text();
        setHtml(text);
        console.log(text);
        const parsed = $(text).find("div");
        console.log(html);

        for (let i = 0; i < parsed.length; i++) {
          parsedArray[i] = parsed[i].innerText;
        }
        setCurrent(parsedArray[0]);
        setPast(parsedArray[1]);
        console.log(parsedArray[1]);
      } catch (error) {
        console.log("error", error);
      }
    };

    fetchPastData();
  }, []);

  return (
    <div>
      <ReactDiffViewer oldValue={past} newValue={current} splitView={true} useDarkTheme={true} />
    </div>
  );
}

export default Hook;