//Takes two code fragments selected by the user on the Results page and
//compares the two using diff2html, displaying the results on this page
//Returns the diff2html results between the two code fragments

import React, { useContext } from "react";
import "react-gh-like-diff/dist/css/diff2html.min.css";
import ReactDiffViewer, { DiffMethod } from "react-diff-viewer";
import "bootstrap/dist/css/bootstrap.min.css";
import { ContextAPI } from "../ContextAPI";

function Hook() {
  const { code1 } = useContext(ContextAPI);
  const { code2 } = useContext(ContextAPI);

  return (
    <div>
      <ReactDiffViewer
        oldValue={code1}
        newValue={code2}
        splitView={true}
        compareMethod={DiffMethod.WORDS}
        leftTitle="First Code Fragment"
        rightTitle="Second Code Fragment"
      />
    </div>
  );
}

export default Hook;
