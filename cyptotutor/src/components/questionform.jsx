import React from 'react'

function questionform() {
  const handleSubmit = event => {
   event.preventDefault();
   alert('You have submitted the form.')
 }

  return(
    <div className="wrapper">
      <h1>Submit Question</h1>
      <form onSubmit={handleSubmit}>
        <fieldset>
        <label>Student Name</label>
            <input name="name" />
        <br />
        <label>Student ID</label>
            <input name="id" />
        <br />
        <label>Question</label>
            <input name="question" />
        <br />
        <label>Description</label>
            <textarea name="description" />
        </fieldset>
        <button type="submit">Submit</button>
      </form>
    </div>
  )
}

export default questionform;