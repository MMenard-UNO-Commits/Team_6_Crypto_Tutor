import React, { useState, useEffect, useContext }from "react";

export default function DisplayQuestions(props) {
    const [question, setQuestion] = useState([]);

    return (
        <div style={{border: "1px solid black"}}>
            {props.question.username}
            <br/>
            {props.question.dateTime}
            <br/>
            {props.question.question}
            <br/>
            <pre>{props.question.codeFragment}</pre>
            <br/>
        </div>
    );
}