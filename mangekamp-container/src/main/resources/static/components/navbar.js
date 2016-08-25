
const React = require('react');

export default class Navbar extends React.Component{
	render() {
		return (
		    <nav className="navbar">
		        <div className="container">
		            <ul className="navbar-list">
		                <li className="navbar-item"><a href="#">Users</a></li>
		                <li className="navbar-item"><a href="#">Seasons</a></li>
		            </ul>
		        </div>
		    </nav>
		)
	}
}