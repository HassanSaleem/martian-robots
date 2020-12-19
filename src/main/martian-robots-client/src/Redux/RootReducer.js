import robots from './Reducers/robots'
import {combineReducers} from 'redux'

const rootReducer = combineReducers({
    robots
})

export default rootReducer