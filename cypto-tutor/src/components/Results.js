import React, {useContext, useState} from 'react';
import { ContextAPI } from '../ContextAPI';
import { useHistory } from 'react-router-dom';

export default function Results() {
    const [past, setPast] = useContext(ContextAPI);
    let history = useHistory();
    const [array, setArray] = useContext(ContextAPI);

    const [checked, setChecked] = useState([]);

    function handleChange(event){
        let array = checked;

        if (event.target.checked == true) {
            array.push(event.target.value);

        setChecked(array);
        } else if (event.target.checked == false) {
        let index = array.indexOf(event.target.value);
        array.splice(index, 1);
        }
        if (array.length > 2) {
        console.log("Only two checkboxes can be selected at a time!");
        }

        console.log(array);
    };

    function handleSubmit(e) {
        let a = "Hello";
        let b = "hi";
        const checkboxes = { a, b };
        //setTest(checkboxes);
        history.push("/hook");
      }
      
    return (
        <div>
            <div dangerouslySetInnerHTML={{ __html: past }} />
            <button onClick={handleSubmit} type="button" className="btn btn-primary">
                diff2html
            </button>
        </div>
    )
}
