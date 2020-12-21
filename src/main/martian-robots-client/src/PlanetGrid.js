import React, {useState} from 'react';
import {useSelector} from 'react-redux'
import {ReactComponent as RobotLogo} from './SVG/Robot.svg';

function PlanetGrid(){
    var coordinates = useSelector(state => state.robots.coordinates)
    var gridRobots = useSelector(state => state.robots.gridRobots)
    return (
        <div style={{margin: "auto", backgroundColor:"#9D0000", height:coordinates.yPosition * 100, width:coordinates.xPosition * 100}}>
            {gridRobots.map((obj) => {
                console.log(obj)
                return(
                <div style={{height: "40px", width:"40px",position:"relative", left:obj.gridPosition.endCoordinates.xPosition*100 + "px", top:(coordinates.yPosition * 100 - obj.gridPosition.endCoordinates.yPosition*100) + "px"}}>
                    <RobotLogo />
                    </div>)
                })}
        </div>
    )
}
 export default PlanetGrid