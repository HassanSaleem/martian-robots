import React, {useState} from 'react';
import {Form, Col, Button} from 'react-bootstrap'
import {useSelector, useDispatch} from 'react-redux'
import AllActions from './Redux/AllActions'

const RobotForm = () => {

    var robots = useSelector(state => state.robots.robots)
    var coordinates = useSelector(state => state.robots.coordinates)
    const dispatch = useDispatch()

    const onCoordinateChange = (coordinate,event) => {
        if (coordinate === "X"){
            dispatch(AllActions.updateCoordinates({...coordinates, xPosition: event.target.value}))
        }
        else{
            dispatch(AllActions.updateCoordinates({...coordinates, yPosition: event.target.value}))
        }
    }

    const updateRobot = (robot) => {
        console.log(robot)
        dispatch(AllActions.updateRobot(robot))
    }

    const submitRobots = (coordinates,robots) => {
        
        var requestRobots = robots.map(obj => createRobotRequest(obj))
        
        var requestBody = {
            "coordinates": coordinates,
            "robots": requestRobots
        }
        console.log(requestBody)
        dispatch(AllActions.submitRobots(requestBody))

    }

    const createRobotRequest = (robot) => {
        return {
            "gridPosition": {
              "endCoordinates": null,
              "isLost": false,
              "lastKnownCoordiantes": null,
              "orientation": robot.orientation,
              "startCoordinates": {
                "xPosition": robot.xCoordinate,
                "yPosition": robot.yCoordinate
              },
              "stringFormat": ""
            },
            "instructions": robot.instructions,
            "uuid": robot.id
          }
    }
    
    return (
        <div style={{margin:"auto", padding:"10px"}}>
            <Form>
            <Form.Group>
            <Form.Row>
                <Form.Label>Upper Right Coordinates</Form.Label>
            </Form.Row>
            <Form.Row>
                <Col xs="auto">
                <Form.Control type="number" placeholder="X" onChange={(event)=> onCoordinateChange("X", event)} value={coordinates.xPosition}/>
                </Col>
                <Col xs="auto">
                <Form.Control type="number" placeholder="Y" onChange={(event)=> onCoordinateChange("Y", event)} value={coordinates.yPosition}/>
                </Col>
                <Col xs="auto">
                <Button onClick={() => dispatch(AllActions.resetRobots())}>Reset</Button>
                </Col>
                <Col xs="auto">
                <Button onClick={() => submitRobots(coordinates,robots)}>Submit</Button>
                </Col>
            </Form.Row>
            </Form.Group>
            <Form.Group>
            {robots.map((robot) =>
                (            <div>
                    <Form.Row>
                        <Form.Label>Robot-{robot.id}</Form.Label>
                    </Form.Row>
                    <Form.Row>
                        <Col xs="auto">
                        <Form.Control type="number" placeholder="X" value={robot.xCoordinate} onChange={(event)=> updateRobot({...robot, xCoordinate: event.target.value})} />
                        </Col>
                        <Col xs="auto">
                        <Form.Control type="number" placeholder="Y"  value={robot.yCoordinate} onChange={(event)=> updateRobot({...robot, yCoordinate: event.target.value})}/>
                        </Col>
                        <Col xs="auto">
                        <Form.Control as="select" placeholder="Orientation" value={robot.orientation} onChange={(event)=> updateRobot({...robot, orientation: event.target.value})}>
                            <option value="North">North</option>
                            <option value="East">East</option>
                            <option value="South">South</option>
                            <option value="West">West</option>
                        </Form.Control>
                        </Col>
                        <Col xs="auto">
                        <Form.Control type="text" placeholder="Instructions" value={robot.instructions} onChange={(event)=> updateRobot({...robot, instructions: event.target.value})}/>
                        </Col>
                    </Form.Row>
                </div>))}
            <br/>
            <Form.Row>
                <Button onClick={() => dispatch(AllActions.addRobot())}>Add Robot</Button>
            </Form.Row>
            </Form.Group>
            </Form>
        </div>
    )
}

RobotForm.defaultProps = {

}

export default RobotForm