import React, { useRef, useState } from "react"
import { Form, Button, Card, Alert } from "react-bootstrap"
import { useAuth } from "../contexts/AuthContext"
import {Link, useHistory} from 'react-router-dom'


export default function Signup() {
    const emailRef = useRef()
    const passwordRef = useRef()
    const passwordConfirmRef = useRef()
    const { signup} = useAuth()
    const [error, setError] = useState("")
    const [loading, setLoading] = useState(false)
    const history = useHistory()

  async function handleSubmit(e) {
    e.preventDefault()

    if (passwordRef.current.value !== passwordConfirmRef.current.value) {
        return setError ("Password do not match")


    }
    try {
        setError("")
        setLoading(true)
        await signup(emailRef.current.value, passwordRef.current.value)
        history.push('/')
      } catch {
        setError("Failed to create an account")
      }
  
      setLoading(false)
    }
  
    return (
     <>
    <Card className="text-center"> 
       <Card.Body> </Card.Body>
        <Card.Body>
               <h2 className="mb-4">Sign Up</h2>
               {error && <Alert variant = "danger">{error}</Alert>}
               <Form onSubmit = {handleSubmit}>
                <Form.Group controlId="formBasicEmail">
                    <Form.Label>Email address</Form.Label>
                    <Form.Control type="email" placeholder="Enter email" ref={emailRef} />
                    <Form.Text className="text-muted">
                        We'll never share your email with anyone else.
                    </Form.Text>
                </Form.Group> 
                <Form.Group controlId="password">
                    <Form.Label>Password</Form.Label>
                    <Form.Control type="password" ref={passwordRef} />
                </Form.Group>
                <Form.Group controlId="password-confirm">
                    <Form.Label>Password Confirmation</Form.Label>
                    <Form.Control type="password" ref={passwordConfirmRef} />
                </Form.Group>
                <Button disabaled = {loading} className = "w-100" type="submit">
                    Sign Up
                </Button>
            </Form>
        </Card.Body>
    </Card>
    <div className="w-100 text-center mt-2">
        Already have an account? <Link to = "/login">Log In</Link>
    </div>
    </>
    )
}
