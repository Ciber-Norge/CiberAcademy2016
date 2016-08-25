'use strict';

const React = require('react');
const when = require('when');

class EventList extends React.Component {

	constructor(props) {
		super(props);
    }

    render() {
        var events = this.props.events.map(event =>
            <Event key={event.entity._links.self.href}
                    event={event}/>);

        return (
            <div>
                <table>
                    <tr>
                        <th>Title</th>
                        <th>Sport</th>
                        <th>Venue</th>
                        <th>Date</th>
                        <th>Season</th>
                        <th>Category</th>
                        <th>Participants</th>
                        <th>Results</th>
                    </tr>
                    {events}
                </table>
            </div>
        )
    }
}

class Event extends React.Component {

	constructor(props) {
		super(props);
    }
    render() {

    return(
            <tr>
                <td>{this.props.event.entity.title}</td>
                <td>{this.props.event.entity.sport}</td>
                <td>{this.props.event.entity.venue}</td>
                <td>{this.props.event.entity.date}</td>
                <td> Dummy </td>
                <td> Dummy </td>
                <td> Dummy </td>
                <td> Dummy </td>
            </tr>
        )
    }
}

export default EventList;