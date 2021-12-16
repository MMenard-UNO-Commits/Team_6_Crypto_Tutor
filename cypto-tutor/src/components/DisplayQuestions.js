//Function to display the query results in the Dashboard
//props - Array of query results to be processed
//returns results which are individually bordered with dividers separating the
//username, submission time, question, and code fragment in question

import React from "react";
import "./DisplayQuestions.css"

export default function DisplayQuestions(props) {

    return (
        <div style={{border: "3px solid black",
                     width: "100%"}}>
            <label for="username">Username:</label>
            <div id="username">
                {props.question.username}
            </div>
            <hr size="4"/>
            <label for="dateTime">Date and Time of Submission:</label>
            <div id="dateTime">
                {props.question.dateTime}
            </div>
            <hr size="4"/>
            <label for="question">Question:</label>
            <div id="question">
                <pre>{props.question.question}</pre>
            </div>
            <hr size="4"/>
            <label for="codeFragment">Code Fragment:</label>
            <div id="codeFragment">
                <pre>{props.question.codeFragment}</pre>
            </div>
        </div>
    );
}