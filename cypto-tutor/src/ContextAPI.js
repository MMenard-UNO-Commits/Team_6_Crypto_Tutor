
   
import React, { createContext, useState } from "react";

export const ContextAPI = createContext();

export const CheckboxesProvider = (props) => {
  const [parsedArray, setParsedArray] = useState([]);
  const [code1, setCode1] = useState("");
  const [code2, setCode2] = useState("");

  const [past, setPast] = useState("");
  const [selectedCodeFragment1, setSelectedCodeFragment1] = useState("");
  const [selectedCodeFragment2, setSelectedCodeFragment2] = useState("");
  // const [text, setText] = useState({
  //   selectedCodeFragment1: "",
  //   selectedCodeFragment2: "",
  // });

  return (
    <ContextAPI.Provider
      value={{
        selectedCodeFragment1,
        setSelectedCodeFragment1,
        selectedCodeFragment2,
        setSelectedCodeFragment2,
        parsedArray,
        setParsedArray,
        past,
        setPast,
        code1,
        code2,
        setCode1,
        setCode2,
      }}
    >
      {props.children}
    </ContextAPI.Provider>
  );
};