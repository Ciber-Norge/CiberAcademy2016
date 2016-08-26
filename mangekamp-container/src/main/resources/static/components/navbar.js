
const React = require('react');
const client = require('./../client');

import { Link } from 'react-router'

export default class Navbar extends React.Component{
    handleLogout() {
        client({
            method: 'POST',
            path: 'http://localhost:8080/logout',
        }).then(() => {

        }).done(() => {
            console.log("Success");
        });
    }

	render() {
		return (
		    <nav className="navbar">
		        <div className="container">
		            <ul className="navbar-list">
		                <li className="navbar-item"><Link to={'/users'} className="navbar-brand">Mangekampen</Link></li>
		                <li className="navbar-item"><Link to={'/users'}>Users</Link></li>
		                <li className="navbar-item"><Link to={'/seasons'}>Seasons</Link></li>
		                <li className="navbar-item"><Link to={'/categories'}>Categories</Link></li>
		                <li className="navbar-item u-pull-right"><a href="#" onClick={this.handleLogout}>Logout</a></li>
		            </ul>
		        </div>
		    </nav>
		)
	}
}
