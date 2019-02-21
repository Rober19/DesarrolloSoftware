const { Component } = React;

const { HashRouter, Route, Link } = ReactRouterDOM;

function App() {
  return (
    <HashRouter>
      <div>
        <Route exact path="/" component={Calculadora} />       
      </div>
    </HashRouter>
  );
}
