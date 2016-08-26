
const React = require('react');
const client = require('./../client');

const root = 'http://localhost:8080/api';

export default class Categories extends React.Component {

    constructor() {
        super();
        this.state = { categories: []};
    }

    componentDidMount() {
        client({method: 'GET', path: root + '/categories'}).done(response => {
            this.setState({categories: response.entity._embedded.categories});
        });
    }

    render() {
        var categories = this.state.categories.map(category =>
            <Category category={category}/>
        );

        return (
            <div className="container">
                <table className="u-full-width">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Created</th>
                        <th>Updated</th>
                    </tr>
                </thead>
                <tbody>
                    {categories}
                </tbody>
            </table>
            </div>
        )
    }
}

class Category extends React.Component{
	render() {
		return (
			<tr>
			    <td>{this.props.category.title}</td>
			    <td>{this.props.category.createdAt}</td>
			    <td>{this.props.category.updatedAt}</td>
			</tr>
		)
	}
}