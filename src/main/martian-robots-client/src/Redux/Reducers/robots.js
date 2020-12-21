

const robots = (state = {loading: false, coordinates:initialCoordinates, robots:initialRobot, gridRobots:[]}, action) => {
    switch(action.type){
        case "UPDATE_COORDINATES":
            return {...state, coordinates:action.coordinates}
        case "ADD_ROBOT":
            const newRobot = {
                id: state.robots.length +1,
                xCoordinate: "",
                yCoordinate: "",
                orientation: "",
                instructions: ""
            }
            const addedRobots = [...state.robots, newRobot]
            return  {...state, robots: addedRobots}
        case "UPDATE_ROBOT":
            const updatedRobots = updateRobot(state.robots, action.robot)
            return  {...state, robots: updatedRobots}
        case "RESET_ROBOTS":
                return {loading: false, coordinates:initialCoordinates, robots:initialRobot, gridRobots:[]}
        case "SUBMIT_ROBOTS_GET":
            return {...state, loading:true};
        case "SUBMIT_ROBOTS_SUCCESS":
            return {...state, loading:false, gridRobots:action.payload.data};
        case "SUBMIT_ROBOTS_FAIL":
            console.log(action)
            return {...state, loading:false, gridRobots:[]};         
        default:
            return state
    }
}

const updateRobot = (state,updatedRobot) => {
    const newState = state.map((obj => obj.id === updatedRobot.id
        ? updatedRobot : obj));
       
    return newState
}

const initialRobot = [
    {
        id: 1,
        xCoordinate: "",
        yCoordinate: "",
        orientation: "North",
        instructions: ""
    }
]

const initialCoordinates = {
    "xPosition": 5,
    "yPosition": 5
  }

const testResult = [
    {
      "gridPosition": {
        "startCoordinates": {
          "xPosition": 1,
          "yPosition": 1
        },
        "endCoordinates": {
          "xPosition": 1,
          "yPosition": 1
        },
        "lastKnownCoordiantes": null,
        "orientation": "East",
        "isLost": false,
        "stringFormat": "1 1 E"
      },
      "instructions": "RFRFRFRF",
      "uuid": 1
    },
    {
      "gridPosition": {
        "startCoordinates": {
          "xPosition": 3,
          "yPosition": 2
        },
        "endCoordinates": {
          "xPosition": 3,
          "yPosition": 4
        },
        "lastKnownCoordiantes": {
          "xPosition": 3,
          "yPosition": 3
        },
        "orientation": "North",
        "isLost": true,
        "stringFormat": "3 3 N LOST"
      },
      "instructions": "FRRFLLFFRRFLL",
      "uuid": 2
    },
    {
      "gridPosition": {
        "startCoordinates": {
          "xPosition": 0,
          "yPosition": 3
        },
        "endCoordinates": {
          "xPosition": 2,
          "yPosition": 3
        },
        "lastKnownCoordiantes": null,
        "orientation": "South",
        "isLost": false,
        "stringFormat": "2 3 S"
      },
      "instructions": "LLFFFLFLFL",
      "uuid": 3
    }
  ]

export default robots