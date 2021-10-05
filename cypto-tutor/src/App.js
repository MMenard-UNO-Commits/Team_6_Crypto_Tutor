import "./App.css";
import React, { Component } from "react";
//import Questionform from "./components/questionform";

class App extends Component {
  state = {
    studentName: "",
    studentID: "",
    question: "",
    description: "",
  };

  /*handleAdd = async (e) => {
    await this.setState({
      studdentName: e.target.value,
      studentID: e.target.value,
      question: e.target.value,
      description: e.target.value,
    });
  };
*/
  handleSubmit = (e) => {
    e.preventDefault();

    //TODO: ALl the values of the input field are stored in the variable, \
    //now they need to be processed in the backend
    alert("Forms submitted successfully");
  
    console.log(this.state.studentName);
    console.log(this.state.studentID);
    console.log(this.state.question);
    console.log(this.state.description);
  };
  render() {
    return (
      <div className="p-3 mb-2 bg-light bg-opacity-50 text-dark">
        <h1>Submit Question</h1>
        <form className="forms">
          <fieldset>
            <label>Student Name</label>
            <br />
            <input
              className=".form-control-sm"
              name="name"
              value={this.state.studentName}
              onChange={(event) =>
                this.setState({ studentName: event.target.value })
              }
              placeholder="Your name"
            />
            <br />
            <label>Student ID</label>
            <br/>
            <input
              className=".form-control-sm m-1"
              name="id"
              value={this.state.studentID}
              onChange={(event) =>
                this.setState({ studentID: event.target.value })
              }
              placeholder="Your ID"
            />
            <br />
            <label>Question</label>
            <textarea
              className="form-control"
              rows="7"
              name="question"
              value={this.state.question}
              onChange={(event) =>
                this.setState({ question: event.target.value })
              }
              placeholder="Type a Question"
            />
            <br />
            <label>Description</label>
            <textarea
              className="form-control"
              name="description"
              rows="7"
              value={this.state.description}
              onChange={(event) =>
                this.setState({ description: event.target.value })
              }
              placeholder="Type a code fragments"
            />
          </fieldset>
          <button
            onClick={this.handleSubmit}
            type="submit"
            className="btn btn-outline-success m-3"
          >
            Submit
          </button>
        </form>
      </div>
    );
  }
}

export default App;
