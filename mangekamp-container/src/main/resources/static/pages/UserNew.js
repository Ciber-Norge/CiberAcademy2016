
const React = require('react');

export default class UserNew extends React.Component{
	render() {
		return (
		    <div className="container">
		        <div className="row">
		            <div className="six columns">
		                <form>
		                    <label>Name</label>
		                    <input type="text" placeholder="Name" className="u-full-width"/>
		                    <label>Email</label>
                            <input type="text" placeholder="Email" className="u-full-width"/>
                            <input className="button-primary" type="submit" value="Submit" />
		                </form>
		            </div>
		        </div>
		    </div>
		)
	}
}