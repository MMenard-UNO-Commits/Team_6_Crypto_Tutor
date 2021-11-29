import React from 'react';

export default class Dashboard extends React.Component{

  constructor(props) {
    super(props);
    this.state = {
      users: []
    };
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
    return(
      <html>
      <h2> Dashboard </h2>
      </html>
    )
  };
}