import React from 'react';
import {Form, Col, Button} from 'react-bootstrap'
import {useSelector, useDispatch} from 'react-redux'
import AllActions from './Redux/AllActions'

const RobotForm = () => {

    var robots = useSelector(state => state.robots)

    
    const dispatch = useDispatch()

    const updateRobot = (robot) => {
        dispatch(AllActions.updateRobot(robot))
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
                <Form.Control type="number" placeholder="X" />
                </Col>
                <Col xs="auto">
                <Form.Control type="number" placeholder="Y" />
                </Col>
                <Col xs="auto">
                <Button onClick={() => dispatch(AllActions.resetRobots())}>Reset</Button>
                </Col>
                <Col xs="auto">
                <Button>Submit</Button>
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
                        <Form.Control type="text" placeholder="Orientation" value={robot.orientation} onChange={(event)=> updateRobot({...robot, orientation: event.target.value})}/>
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