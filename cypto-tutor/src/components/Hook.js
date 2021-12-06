import React, { useContext } from "react";
import "react-gh-like-diff/dist/css/diff2html.min.css";
import ReactDiffViewer from "react-diff-viewer";
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
      />
    </div>
  );
}

export default Hook;
