'use strict';

const React = require('react');

import { Router, Route, Link, IndexRoute, browserHistory } from 'react-router'

const Navbar = require('./components/navbar');
const UserPage = require('./pages/user-page');
const SeasonPage = require('./pages/season-page');
const EventPage = require('./pages/event-page');

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
                        <Route path="seasons/events/:id" component={EventPage}/>
                   </Route>
               </Router>

React.render(routes, document.getElementById('react'));
