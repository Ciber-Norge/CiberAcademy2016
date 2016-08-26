
const React = require('react');
const client = require('./../client');
const moment = require('moment');
import { Link } from 'react-router'

const root = 'http://localhost:8080/api';

export default class EventNew extends React.Component {

    constructor() {
        super();
        var today = moment().format('YYYY-MM-DD');
        this.state = { categories: []};
    }

    componentDidMount() {
        client({method: 'GET', path: root + '/categories'}).done(response => {
            this.setState({categories: response.entity._embedded.categories});
        });
    }

    handleSubmit(event) {
        event.preventDefault();
        console.log(this.state.form);
        let title = React.findDOMNode(this.refs.title).value;
        let sport = React.findDOMNode(this.refs.sport).value;
        let venue = React.findDOMNode(this.refs.venue).value;
        let date = React.findDOMNode(this.refs.date).value;
        let category = React.findDOMNode(this.refs.category).value;

        client({
            method: 'POST',
            path: 'api/events',
            entity: { title: title, sport: sport, venue: venue, date: date, category: category},
            headers: {'Content-Type': 'application/json'}
        }).done(response => {
            console.log("Saved");
        });
    }

    render() {
        var categories = this.state.categories.map(category =>
            <option key={category.title} value={category.title}>{category.title}</option>
        );

        return (
            <div className="container">
                <div className="row">
                    <div className="six columns">
                        <form onSubmit={this.handleSubmit.bind(this)}>
                            <label>Title</label>
                            <input type="text" placeholder="Title" className="u-full-width" ref='title' />
                            <label>Sport</label>
                            <input type="text" placeholder="Sport" className="u-full-width" ref='sport'/>
                            <label>Venue</label>
                            <input type="text" placeholder="Venue" className="u-full-width" ref='venue'/>
                            <label>Date</label>
                            <input type="date" className="u-full-width" ref='date'/>
                            <label>Category</label>
                            <select name="Kategori" className="u-full-width" ref='category'>
                                {categories}
                            </select>
                            <input className="button-primary" type="submit" value="New Event"/>
                            <Link to='seasons' className="button u-pull-right">Cancel</Link>
                        </form>
                    </div>
                </div>
            </div>
        )
    }
}