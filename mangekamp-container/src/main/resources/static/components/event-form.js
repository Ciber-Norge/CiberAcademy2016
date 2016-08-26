'use strict';

const React = require('react');
const when = require('when');
const client = require('./../client');
const Event = require('./event.js')

const root = 'http://localhost:8080/api';
import {Link} from 'react-router'
class EventList extends React.Component {

	constructor(props) {
		super(props);
    }

    render() {
        var events = this.props.events.map(event =>
            <Event key={event._links.self.href}
                    event={event}/>);
        return (
            <div>
                <table>
                    <tr>
                        <th>Title</th>
                        <th>Sport</th>
                        <th>Venue</th>
                        <th>Date</th>
                        <th>Category</th>
                    </tr>
                    {events}
                </table>
            </div>
        )
    }
}

export default EventList;