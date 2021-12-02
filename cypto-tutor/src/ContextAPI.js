import React, { createContext, useState } from "react";

export const ContextAPI = createContext();

export const CheckboxesProvider = (props) => {
  const [array, setArray] = useState([]);
  const [past, setPast] = useState("");

  return (
    <ContextAPI.Provider value={[past, setPast, array, setArray]}>
      {props.children}
    </ContextAPI.Provider>
  );
};
