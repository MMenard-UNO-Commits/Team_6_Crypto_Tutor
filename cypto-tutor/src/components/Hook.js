
   
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
  const { parsedArray, setParsedArray } = useContext(ContextAPI);
  const { code1, setCode1 } = useContext(ContextAPI);
  const { code2, setCode2 } = useContext(ContextAPI);

  const { selectedCodeFragment1, setSelectedCodeFragment1 } =
    useContext(ContextAPI);
  const { selectedCodeFragment2, setSelectedCodeFragment2 } =
    useContext(ContextAPI);

  return (
    <div>
      <ReactDiffViewer
        oldValue={code1}
        newValue={code2}
        splitView={true}
        useDarkTheme={true}
      />
    </div>
  );
}

export default Hook;
