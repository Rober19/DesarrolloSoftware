const { Component } = React;

const { HashRouter, Route, Link } = ReactRouterDOM;

function App() {
  return (
    <HashRouter>
      <div>
        <Route exact path="/" component={ProductList} />
        <Route path="/createproduct" component={ProductCreate} />
      </div>
    </HashRouter>
  );
}
