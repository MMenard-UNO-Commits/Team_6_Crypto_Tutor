import React, { createContext, useState } from "react";

export const ContextAPI = createContext();

export const CheckboxesProvider = (props) => {
  const [test, setTest] = useState([]);

  return (
    <ContextAPI.Provider value={[test, setTest]}>
      {props.children}
    </ContextAPI.Provider>
  );
};
