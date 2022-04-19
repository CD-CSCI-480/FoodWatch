import React from 'react'
import './App.js'

class Nav extends React.Component {
    render () {
    return (
        <nav>
            <h3>FoodW</h3>
            <ul>
                <li>Home</li>
                <li>About</li>
                <li>Contact</li>
            </ul>
        </nav>
        );
    }
}
export default Nav;