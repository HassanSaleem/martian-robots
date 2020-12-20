

const robots = (state = initialRobot, action) => {
    switch(action.type){
        case "ADD_ROBOT":
            const newRobot = {
                id: state.length +1,
                xCoordinate: "",
                yCoordinate: "",
                orientation: "",
                instructions: ""
            }
            return  [...state, newRobot]
        case "UPDATE_ROBOT":
            return updateRobot(state, action.robot)
        case "RESET_ROBOTS":
                return initialRobot
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
        orientation: "",
        instructions: ""
    }
]

export default robots