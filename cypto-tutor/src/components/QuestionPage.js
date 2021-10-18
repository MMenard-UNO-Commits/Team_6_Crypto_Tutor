import React, { useState } from "react";
import Form from "react-bootstrap/Form";
import Button from "react-bootstrap/Button";

export default function QuestionPage() {
  const [name, setName] = useState("");
  const [id, setID] = useState("");
  const [question, setQuestion] = useState("");
  const [description, setDescription] = useState("");

  function validateForm() {
    return (
      name.length > 0 &&
      id.length > 0 &&
      question.length > 0 &&
      description.length > 0
    );
  }

  function handleSubmit(event) {
    event.preventDefault();
  }

  return (
    <div className="p-3 mb-2 bg-light bg-opacity-20 text-dark">
      <Form onSubmit={handleSubmit}>
        <Form.Group size="lg" controlId="ID">
          <Form.Label>Name</Form.Label>
          <Form.Control
            autoFocus
            className=".form-control-sm"
            type="name"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </Form.Group>
        <Form.Group size="lg" controlId="ID">
          <Form.Label>ID</Form.Label>
          <Form.Control
            autoFocus
            type="id"
            value={id}
            onChange={(e) => setID(e.target.value)}
          />
        </Form.Group>
        <Form.Group size="lg" controlId="password">
          <Form.Label>Question</Form.Label>
          <textarea
            className="form-control"
            type="question"
            placeholder="Type a Question"
            value={question}
            onChange={(e) => setQuestion(e.target.value)}
          />
        </Form.Group>
        <Form.Group size="lg" controlId="ID">
          <Form.Label>Description</Form.Label>
          <textarea
            className="form-control"
            type="description"
            placeholder="Enter code fragment"
            value={description}
            onChange={(e) => setDescription(e.target.value)}
          />
        </Form.Group>
        <Button
          className="btn btn-info m-3"
          size="lg"
          type="button"
          disabled={!validateForm()}
        >
          Submit
        </Button>
      </Form>
    </div>
  );
}

// import React, { Component } from "react";

// class questionpage extends Component() {
//   state = {
//     studentName: "",
//     studentID: "",
//     question: "",
//     description: "",
//   };

//   /*handleAdd = async (e) => {
//     await this.setState({
//       studdentName: e.target.value,
//       studentID: e.target.value,
//       question: e.target.value,
//       description: e.target.value,
//     });
//   };
// */
//   handleSubmit = (e) => {
//     e.preventDefault();

//     //TODO: ALl the values of the input field are stored in the variable, \
//     //now they need to be processed in the backend
//     alert("Forms submitted successfully");

//     window.location = "http://localhost:80/learnphp/Pull.php";
//     console.log(this.state.studentName);
//     console.log(this.state.studentID);
//     console.log(this.state.question);
//     console.log(this.state.description);
//   };
//   render() {
//     return (
//       <div className="p-3 mb-2 bg-light bg-opacity-50 text-dark">
//         <h1>Submit Question</h1>
//         <form className="forms">
//           <fieldset>
//             <label>Student Name</label>
//             <br />
//             <input
//               className=".form-control-sm"
//               name="name"
//               value={this.state.studentName}
//               onChange={(event) =>
//                 this.setState({ studentName: event.target.value })
//               }
//               placeholder="Your name"
//             />
//             <br />
//             <label>Student ID</label>
//             <br/>
//             <input
//               className=".form-control-sm m-1"
//               name="id"
//               value={this.state.studentID}
//               onChange={(event) =>
//                 this.setState({ studentID: event.target.value })
//               }
//               placeholder="Your ID"
//             />
//             <br />
//             <label>Question</label>
//             <textarea
//               className="form-control"
//               rows="7"
//               name="question"
//               value={this.state.question}
//               onChange={(event) =>
//                 this.setState({ question: event.target.value })
//               }
//               placeholder="Type a Question"
//             />
//             <br />
//             <label>Description</label>
//             <textarea
//               className="form-control"
//               name="description"
//               rows="7"
//               value={this.state.description}
//               onChange={(event) =>
//                 this.setState({ description: event.target.value })
//               }
//               placeholder="Type a code fragments"
//             />
//           </fieldset>
//           <button
//             onClick={this.handleSubmit}
//             type="submit"
//             className="btn btn-outline-success m-3"
//           >
//             Submit
//           </button>
//         </form>
//       </div>
//     );
//   }
// }

// export default questionpage;
