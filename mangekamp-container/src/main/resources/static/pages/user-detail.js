
const React = require('react');

export default class UserDetail extends React.Component{
	render() {
		return (
		    <div className="container">
		        <div className="row">
		            <div className="six columns">
		                <p>{this.props.params.id}</p>
		            </div>
		        </div>
		    </div>
		)
	}
}