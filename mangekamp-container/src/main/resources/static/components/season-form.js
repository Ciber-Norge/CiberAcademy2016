'use strict';

const React = require('react');
const client = require('./../client');
const Events = require('./event-form.js')

class SeasonList extends React.Component {

	constructor(props) {
		super(props);
    }

    render() {
        var seasons = this.props.seasons.map(season =>
            <Season key={season.entity._links.self.href}
                    season={season}/>);

        return (
            <div>
                <table>
                    <tr>
                        <th>Season</th>
                        <th>Events</th>
                    </tr>
                    {seasons}
                </table>
            </div>
        )
    }
}

class Season extends React.Component {

    constructor(props) {
        super(props);
        this.state = {events: []}
    }

    componentDidMount() {
            client({method: 'GET', path: this.props.season.entity._links.events.href}).done(response => {
        		this.setState({events: response.entity._embedded.events});
        	});
    }
    /*
                    <ul>{this.state.events.map(function(event){
                        return <li key={event._links.self.href}><Link to={'/seasons/event/:'}>Seasons</Link></li>})}
                    </ul>
    */
    render() {
        return(
            <tr>
                <td>{this.props.season.entity.title}</td>
                <td>
                    <Events events={this.state.events} />
                </td>
            </tr>
        )
    }
}

export default SeasonList;