const React = require('react');

const client = require('./../client');

const Event = require('../components/event.js');
const ResultList = require('../components/result.js');

const root = 'http://localhost:8080/api';

export default class EventPage extends React.Component{

    constructor(props) {
        super(props);
        this.state={event:{}, results: [], id: this.props.params.id, hasLoaded: false}
    }

    loadFromServer() {
            client({method: 'GET', path: root+'/events/'+this.state.id}).done(response => {
                    this.setState({event: response.entity});
                        client({method: 'GET', path: this.state.event._links.results.href}).done(response => {
               	            this.setState({results: response.entity._embedded.results, hasLoaded: true});
          	            });
            });

    }

    componentDidMount() {
        this.loadFromServer();
    }

    render() {
        // Should just be a callback instead.
        if(!this.state.hasLoaded) {
            return (<div></div>)
        }
        return(
            <div>
                <Event key={this.state.event._links.self.href} event={this.state.event} />
                <ResultList results={this.state.results} />
            </div>
        )
    }
}
