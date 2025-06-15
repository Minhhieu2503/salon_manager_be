import React, { Component } from "react";
import data from "./data";
import List from "./List";

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      people: data,
    };
  }

  clearAll = () => {
    this.setState({ people: [] });
  };

  render() {
    const { people } = this.state;

    return (
      <main>
        <section className="container">
          <h3>{people.length} birthdays today</h3>
          <List people={people} />
          <button onClick={this.clearAll}>Clear All</button>
        </section>
      </main>
    );
  }
}

export default App;
