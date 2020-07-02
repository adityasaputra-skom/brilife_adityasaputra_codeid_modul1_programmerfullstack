import React, { Component } from "react";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import routes from "./configs/routes";
import "./App.css";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      login: false,
    };
  }

  render() {
    console.log(this.props.location);

    return (
      <Router basename="/web-client">
        <Switch>
          {routes.map((route, index) => (
            <Route
              key={index}
              path={route.path}
              exact={route.exact}
              render={(props) => (
                <route.component {...props} {...route.props} />
              )}
            />
          ))}
        </Switch>
      </Router>
    );
  }
}

export default App;
