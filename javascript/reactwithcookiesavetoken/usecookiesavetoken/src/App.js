import './App.css';
import {BrowserRouter, Route, Switch } from "react-router-dom";
import Login from './component/login/login'
import Home from './component/indexlogged/index'
import NotFound from './component/notfound/index'

function App() {
  return (
    <div className="App">
      < BrowserRouter>
        <Switch>
          <Route path="/" exact>
            <Login />
          </Route>
          <Route path="/home" exact>
            <Home />
          </Route>
          <Route>
            <NotFound />
          </Route>
        </Switch>
      </BrowserRouter>
      <h1> hihihi</h1>
    </div>
  );
}

export default App;
