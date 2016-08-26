
const React = require('react');
const when = require('when');

const Events = require('../components/event-form.js');
const Seasons = require('../components/season-form.js');
const client = require('./../client');
const follow = require('./../follow');

const root = 'http://localhost:8080/api';

export default class SeasonPage extends React.Component{

	constructor(props) {
		super(props);
		this.state = {events: [], seasons: [], attributes: [], links:{}};
	}

    // Populate 'events'
    loadFromServer() {
            follow(client, root, ['events']
            ).then(eventCollection => {
                return client({
                        method: 'GET',
                        path: eventCollection.entity._links.profile.href,
                        headers: {'Accept' : 'application/schema+json'}
                }).then(schema => {
                    this.schema = schema.entity;
                    this.links = eventCollection.entity._links;
                    return eventCollection;
                });
            }).then(eventCollection => {
                return eventCollection.entity._embedded.events.map(event =>
                        client({
                            method: 'GET',
                            path: event._links.self.href
                        })
                );
            }).then(eventPromises => {
                return when.all(eventPromises);
            }).done(events => {
                this.setState({
                    events: events,
                    attributes: Object.keys(this.schema.properties),
                    links: this.links
                });
            });
            // Populate 'seasons'
            follow(client, root, [
                    {rel: 'seasons'}]
            ).then(seasonCollection => {
                return client({
                    method: 'GET',
                        path: seasonCollection.entity._links.profile.href,
                        headers: {'Accept' : 'application/schema+json'}
                    }).then(schema => {
                        this.schema = schema.entity;
                        this.links = seasonCollection.entity._links;
                        return seasonCollection;
                });
            }).then(seasonCollection => {
                return seasonCollection.entity._embedded.seasons.map(season =>
                        client({
                            method: 'GET',
                            path: season._links.self.href
                        })
                );
            }).then(seasonPromises => {
                return when.all(seasonPromises);
            }).done(seasons => {
                this.setState({
                    seasons: seasons,
                    attributes: Object.keys(this.schema.properties),
                    links: this.links
                });
            });
    }

	componentDidMount() {
		this.loadFromServer();
	}
              /*  <Seasons seasons={this.state.seasons}
                    links={this.state.links}
                    attributes={this.state.attributes}/>
                		        <Events events={this.state.events}
                                    links={this.state.links}
                                    attributes={this.state.attributes}/>
                */
	render() {
		return (
		    <div className="container">
		        <Seasons seasons={this.state.seasons}
                            links={this.state.links}
                            attributes={this.state.attributes}/>

		    </div>
		)
	}
}