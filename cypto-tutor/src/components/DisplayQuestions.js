import React, { useState, useEffect, useContext }from "react";
import "./DisplayQuestions.css"

export default function DisplayQuestions(props) {
    const [question, setQuestion] = useState([]);

    return (
        <div style={{border: "3px solid black",
                     width: "40%"}}>
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