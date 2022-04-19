import React from 'react'
import Signup from './Signup'
import { Container } from 'react-bootstrap'
import { AuthProvider } from '../contexts/AuthContext'
import {BrowserRouter as Router, Route, Switch} from 'react-router-dom'
import Upload from './Upload'
import Dashboard from './Dashboard'
import Login from './Login'

function App() {
  return ( 
    <AuthProvider>
      <Container  className = "d-flex align-items-center justify-content-center"
        style={{minHeight: '100vh'}}
  >
    <div className = "w-100" style = {{maxWidth: '400px'}}>
      <Router>
        <AuthProvider>
          <Switch>
            <Route exact path = "/" component = {Upload} />
            <Route exact path = "/login" component = {Login} />
            <Route exact path = "/signup" component = {Signup} />
          </Switch> 
        </AuthProvider>
      </Router>
        
      </div> 
   
      
    </Container>
  </AuthProvider>
  )
}
   export default App