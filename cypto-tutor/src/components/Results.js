import React, {useContext} from 'react';
import { ContextAPI } from '../ContextAPI';
import { useHistory } from 'react-router-dom';

export default function Results() {
    const [past, setPast] = useContext(ContextAPI);
    let history = useHistory();

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
