import React, { createContext, useState } from "react";

export const ContextAPI = createContext();

export const CheckboxesProvider = (props) => {
  const [test, setTest] = useState([]);
  const [past, setPast] = useState("");

  return (
    <ContextAPI.Provider value={[past, setPast]}>
      {props.children}
    </ContextAPI.Provider>
  );
};
