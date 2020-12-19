import React, { useState } from 'react';
import {Form, Col, Button} from 'react-bootstrap'
import {useSelector} from 'react-redux'

const RobotForm = () => {

    var robots = useSelector(state => state.robots)
    console.log(robots)
    return (
        <div style={{margin:"auto", padding:"10px"}}>
            <Form>
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
                <Button>Reset</Button>
                </Col>
                <Col xs="auto">
                <Button>Submit</Button>
                </Col>
            </Form.Row>
            <br/>
            {robots.map((robot) =>
                (            <div>
                    <Form.Row>
                        <Form.Label>Robot-1</Form.Label>
                    </Form.Row>
                    <Form.Row>
                        <Form.Group as={Col} controlId="formGridX">
                        <Form.Control type="number" placeholder="X" />
                        </Form.Group>
                        <Form.Group as={Col} controlId="formGridY">
                        <Form.Control type="number" placeholder="Y" />
                        </Form.Group>
                    </Form.Row>
                    <Form.Row>
                        <Form.Control type="text" placeholder="Instructions" />
                    </Form.Row>
                </div>))}
            <br/>
            <Form.Row>
                <Button>Add Robot</Button>
            </Form.Row>
            </Form>
        </div>
    )
}

RobotForm.defaultProps = {

}

export default RobotForm