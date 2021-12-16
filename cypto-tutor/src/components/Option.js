//Unused component

import React from "react";

export default class Option extends React.Component {
    render() {
        return (
            <option value = {this.props.user}> {this.props.user} </option>
        );
    }
}