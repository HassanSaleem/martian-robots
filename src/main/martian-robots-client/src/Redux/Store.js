import {applyMiddleware, createStore} from 'redux'
import rootReducer from './RootReducer'
import axios from 'axios'
import axiosMiddleware from 'redux-axios-middleware'

const client = axios.create({ //all axios can be used, shown in axios documentation
    baseURL:'http://localhost:8080',
    responseType: 'json'
  });

const store = createStore(
    rootReducer,
    applyMiddleware(axiosMiddleware(client))
)

export default store