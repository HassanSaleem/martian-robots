const updateCoordinates = (coordinates) =>
{
    return {
        type: "UPDATE_COORDINATES",
        coordinates: coordinates
    }
}

const addRobot = () =>
{
    return {
        type: "ADD_ROBOT"
    }
}

const updateRobot = (robot) =>
{
    return {
        type: "UPDATE_ROBOT",
        robot: robot
    }
}

const resetRobots = () =>
{
    return {
        type: "RESET_ROBOTS",
    }
}

const submitRobots = (robots) =>
{
    return {
        type: "SUBMIT_ROBOTS",
        payload: {
            request :{
                method: 'POST',
                url:"grid/create-grid",
                data: robots
            }
        }
    }
}



export {addRobot, updateRobot, resetRobots, submitRobots, updateCoordinates}