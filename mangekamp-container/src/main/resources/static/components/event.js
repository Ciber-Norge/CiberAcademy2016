'use strict';

const React = require('react');
const client = require('./../client');

const root = 'http://localhost:8080/api';
import {Link} from 'react-router'

class Event extends React.Component {

	constructor(props) {
		super(props);
		this.state = {season: [], results: [], category: [], links: {}}
    }

    componentDidMount(){
        	// Results
            client({method: 'GET', path:this.props.event._links.results.href}).done(response => {
             	this.setState({results: response.entity._embedded.results});
        	});
        	// Category
            client({method: 'GET', path: this.props.event._links.category.href}).done(response => {
        		this.setState({category: response.entity});
        	});
    }

    render() {

        var date = this.props.event.date.substring(0,10).replace(/-/g,function(match) {return (match=="-")?".":"";});
        var urlLength = this.props.event._links.self.href.length;
        var eventId = this.props.event._links.self.href.substring(urlLength-1,urlLength);
        return(
            <tr>
                <td><Link to={'/seasons/events/'+eventId}>{this.props.event.title}</Link></td>
                <td>{this.props.event.sport}</td>
                <td>{this.props.event.venue}</td>
                <td>{date}</td>
                <td>{this.state.category.title}</td>
            </tr>
        )
    }
}

export default Event;