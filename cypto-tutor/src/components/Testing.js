import React from 'react'
import "react-gh-like-diff/dist/css/diff2html.min.css";
import { ReactGhLikeDiff } from "react-gh-like-diff";

export default function Testing() {
    return (
        <div>
            <ReactGhLikeDiff
                options={{
                    originalFileName: "Original",
                    updatedFileName: "Last"
                }}
            past={"Hi"}
            current={"Hello"}
            />
        </div>
    )
}
