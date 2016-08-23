'use strict';

const React = require('react');
const client = require('./client');

const follow = require('./follow');

const root = '/api';

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {users: [], attributes: [], pageSize: 20, links:{}};
		this.updatePageSize = this.updatePageSize.bind(this);
		this.onCreate = this.onCreate.bind(this);
		this.onNavigate = this.onNavigate.bind(this);
	}

    loadFromServer(pageSize) {
        follow(client, root, [
            {rel: 'users', params: {size: pageSize}}]
        ).then(userCollection => {
            return client({
                method: 'GET',
                path: userCollection.entity._links.profile.href,
                headers: {'Accept' : 'application/schema+json'}
            }).then(schema => {
                this.schema = schema.entity;
                return userCollection;
            });
        }).done(userCollection => {
            this.setState({
                users: userCollection.entity._embedded.users,
                attributes: Object.keys(this.schema.properties),
                pageSize: pageSize,
                links: userCollection.entity._links});
        });
    }

    onCreate(newUser) {
    	follow(client, root, ['users']).then(userCollection => {
    		return client({
    			method: 'POST',
    			path: userCollection.entity._links.self.href,
    			entity: newUser,
    			headers: {'Content-Type': 'application/json'}
    		})
    	}).then(response => {
    		return follow(client, root, [
    			{rel: 'users', params: {'size': this.state.pageSize}}]);
    	}).done(response => {
    		this.onNavigate(response.entity._links.last.href);
   		});
   	}

    onNavigate(navUri) {
    	client({method: 'GET', path: navUri}).done(userCollection => {
    		this.setState({
    			users: userCollection.entity._embedded.users,
    			attributes: this.state.attributes,
    			pageSize: this.state.pageSize,
    			links: userCollection.entity._links
    		});
    	});
    }

	componentDidMount() {
		this.loadFromServer(this.state.pageSize);
	}

	updatePageSize(pageSize) {
    	if (pageSize !== this.state.pageSize) {
    		this.loadFromServer(pageSize);
    	}
    }

	render() {
		return (
		    <div>
		        <CreateDialog attributes={this.state.attributes} onCreate={this.onCreate}/>
			    <UserList users={this.state.users}
			                    links={this.state.links}
			                    pageSize={this.state.pageSize}
			                    onNavigate={this.onNavigate}
			                    updatePageSize={this.updatePageSize}/>
		    </div>
		)
	}
}

class CreateDialog extends React.Component {

	constructor(props) {
		super(props);
		this.handleSubmit = this.handleSubmit.bind(this);
	}

	handleSubmit(e) {
		e.preventDefault();
		var newUser = {};
		this.props.attributes.forEach(attribute => {
			newUser[attribute] = React.findDOMNode(this.refs[attribute]).value.trim();
		});
		this.props.onCreate(newUser);

		// clear out the dialog's inputs
		this.props.attributes.forEach(attribute => {
			React.findDOMNode(this.refs[attribute]).value = '';
		});

		// Navigate away from the dialog to hide it.
		window.location = "#";
	}

	render() {
		var inputs = this.props.attributes.map(attribute =>
			<p key={attribute}>
				<input type="text" placeholder={attribute} ref={attribute} className="field" />
			</p>
		);

		return (
			<div>
				<a href="#createUser">Create</a>
				<div id="createUser" className="modalDialog">
					<div>
						<a href="#" title="Close" className="close">X</a>
						<h2>Create new user</h2>
						<form>
							{inputs}
							<button onClick={this.handleSubmit}>Create</button>
						</form>
					</div>
				</div>
			</div>
		)
	}
}


class UserList extends React.Component{

	constructor(props) {
		super(props);
		this.handleInput = this.handleInput.bind(this);
    }

    handleInput(e) {
    	e.preventDefault();
    	var pageSize = React.findDOMNode(this.refs.pageSize).value;
    	if (/^[0-9]+$/.test(pageSize)) {
    		this.props.updatePageSize(pageSize);
    	} else {
    		React.findDOMNode(this.refs.pageSize).value =
    			pageSize.substring(0, pageSize.length - 1);
    	}
    }
	render() {
	    console.log(this.props.users)
		var users = this.props.users.map(user =>
			<User key={user._links.self.href} user={user}/>
		);
		return (
			<table>
				<tr>
					<th>Name</th>
					<th>E-Mail</th>
					<th>Sex</th>
				</tr>
				{users}
			</table>
		)
	}
}

class User extends React.Component{
	constructor(props) {
		super(props);
	}

	render() {
		return (
			<tr>
				<td>{this.props.user.name}</td>
				<td>{this.props.user.email}</td>
				<td>{this.props.user.sex}</td>
			</tr>
		)
	}
}

React.render(
	<App />,
	document.getElementById('react')
)
