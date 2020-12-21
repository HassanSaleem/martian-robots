import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import RobotForm from './RobotForm'
import PlanetGrid from './PlanetGrid'
import {Provider} from 'react-redux'
import Store from './Redux/Store'



function App() {
  return (
    <Provider store={Store}>
      <div className="App">
        <RobotForm/>
        <PlanetGrid></PlanetGrid>
      </div>
    </Provider>
  );
}

export default App;
