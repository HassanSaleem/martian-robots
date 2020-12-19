const addRobot = (robotObj) =>
{
    return {
        type: "ADD_ROBOT",
        payload: robotObj
    }
}

export default { addRobot }