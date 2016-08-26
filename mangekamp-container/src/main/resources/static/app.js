'use strict';

const React = require('react');
const when = require('when');
const client = require('./client');
const follow = require('./follow');

import { Router, Route, Link, IndexRoute, hashHistory } from 'react-router'

const Navbar = require('./components/navbar');
const UserPage = require('./pages/user-page');
const UserNew = require('./pages/user-new');
const UserDetail = require('./pages/user-detail');
const SeasonPage = require('./pages/season-page');
const Categories = require('./pages/Categories');

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

const routes =
    <Router history={hashHistory}>
        <Route path="/" component={App}>
            <Route path="users" component={UserPage}/>
            <Route path="users/:id" component={UserDetail}/>
            <Route path="seasons" component={SeasonPage}/>
            <Route path="categories" component={Categories}/>
        </Route>
    </Router>

React.render(routes, document.getElementById('react'));
