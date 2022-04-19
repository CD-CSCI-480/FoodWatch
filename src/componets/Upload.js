import React from "react"
import "./App.js"
import axios from "axios"

class Upload extends React.Component {
  state = { 
    selectedFile: null
  }

  fileSelectedHandler = event => {
    this.setState({
    selectedFile : event.target.files[0]
  })
}

  fileUploadHandler = () => {
    const data = new FormData()
    data.append('file', this.state.selectedFile, this.state.selectedFile.name);
    axios.post("https://api-2445582032290.production.gw.apicast.io/v1/foodrecognition?user_key=34e0a1cb16f774eec562ec24d9a3d3ae", this.state)
    .then(res => {
      console.log(res);
    });

  }

  render () {
    return (
      <div className = "App">
        <input type = "file" onChange = {this.fileSelectedHandler}/>
        <button onClick = {this.fileUploadHandler}> Upload </button>

        </div>
    );
  }
}

export default Upload;