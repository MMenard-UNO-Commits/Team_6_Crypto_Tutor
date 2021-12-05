import React from 'react';
import Option from './Option';
export default class Dashboard extends React.Component{

  constructor(props) {
    super(props);
    this.state = {
      users: []
    };
  }

  handleSubmit() {
    console.log("form submitted");
  }

  async componentDidMount(){
    const response = await fetch("http://104.131.172.9:8080/users-test/user/getStudents");
    const test = await response.json();
    let tmpArray = [];
    for (var i = 0; i < test.length; i++) {
      tmpArray.push(test[i])
    }
    this.setState({users: tmpArray});
    console.log(this.state.users);
  }

  render() {
    const options = this.state.users.map(user =>
      <Option user = {user}/>);
    return(
      <div key="html">
      <h2 key="heading"> Dashboard </h2>
      <form>
        <label key="label1" htmlFor="query"> Query:</label>
        <input key="input1" type="text" id="query" name="query"></input>
        <label htmlFor="user"> Select user:</label>
        <select name="user" id="user">
          <option value=""> None </option>
          {options}
        </select>
        <input type="submit" value="submit"></input>
      </form>
      </div>
    )
  };
}