'use strict';

const React = require('react');
const client = require('./../client');

const root = 'http://localhost:8080/api';

class ResultList extends React.Component {

    constructor(props) {
        super(props);
    }

    render() {
        return(
            <div>
                <table>
                    <tr>
                        <th>User</th>
                        <th>Rank</th>
                        <th>Score</th>
                    </tr>
                    {this.props.results.map(function(result){
                        return <Result key={result._links.self.href}
                                        result={result} /> })}
                </table>
            </div>
        )
    }
}

class Result extends React.Component {

    constructor(props) {
        super(props);
        this.state={participant: {}}
    }

    render() {
        return(
            <tr>
                <td>
                    <Participant key={this.props.result._links.participant.href}
                                    result={this.props.result}/>
                </td>
                <td>{this.props.result.rank}</td>
                <td>{this.props.result.score}</td>
            </tr>
        )
    }
}


class Participant extends React.Component {

    constructor(props) {
        super(props);
        this.state={user:[]}
    }

    componentDidMount() {
        client({method: 'GET', path: this.props.result._links.participant.href
        }).done(response => {
                client({method: 'GET', path: response.entity._links.user.href
                }).done(response => {
                    this.setState({user:response.entity});
                })
        });
    }
    render() {
        return(
            <div>{this.state.user.name}</div>
        )
    }
}

export default ResultList;