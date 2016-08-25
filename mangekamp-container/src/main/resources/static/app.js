'use strict';

const React = require('react');
const when = require('when');
const client = require('./client');
const follow = require('./follow');

import { Router, Route, Link, IndexRoute, browserHistory } from 'react-router'

const Navbar = require('./components/navbar');
const UserPage = require('./pages/user-page');
const SeasonPage = require('./pages/season-page');

const root = 'http://localhost:8080/api';

class App extends React.Component {
    render() {
        return (
            <div>
                <Navbar />
                {this.props.children}
            </div>
        )
    }
}

const routes = <Router history={browserHistory}>
                   <Route path="/" component={App}>
                        <Route path="users" component={UserPage}/>
                        <Route path="seasons" component={SeasonPage}/>
                   </Route>
               </Router>

React.render(routes, document.getElementById('react'));
