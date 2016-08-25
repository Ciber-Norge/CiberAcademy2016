'use strict';

const React = require('react');

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
                        <th>Title</th>
                        <th>Events</th>
                    </tr>
                    {seasons}
                </table>
            </div>
        )
    }
}

class Season extends React.Component {
    render() {
        return(
            <tr>
                <td>{this.props.season.entity.title}</td>
                <td>{this.props.season.entity.events}</td>

            </tr>
        )
    }
}

export default SeasonList;