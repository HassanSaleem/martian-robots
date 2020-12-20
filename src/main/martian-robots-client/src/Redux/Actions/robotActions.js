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
                url:"/grid/submit",
                data: {
                    Coordinates:{

                    },
                    Robots: {
                        
                    }
                }
            }
        }
    }
}



export {addRobot, updateRobot, resetRobots}