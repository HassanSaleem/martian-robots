import React, {useState} from 'react';
import {useSelector} from 'react-redux'
import {ReactComponent as RobotLogo} from './SVG/Robot.svg';

function PlanetGrid(){
    var coordinates = useSelector(state => state.robots.coordinates)
    var gridRobots = useSelector(state => state.robots.gridRobots)
    return (
        <div style={{margin: "auto", backgroundColor:"#9D0000", height:(coordinates.yPosition * 110) + "px", width:(coordinates.xPosition * 110) + "px"}}>
            {gridRobots.map((obj) => {
                var gridPosition = {
                    xPosition: obj.gridPosition.endCoordinates.xPosition,
                    yPosition: obj.gridPosition.endCoordinates.yPosition
                }
                if (obj.gridPosition.isLost){
                    gridPosition = {
                        xPosition: obj.gridPosition.lastKnownCoordiantes.xPosition,
                        yPosition: obj.gridPosition.lastKnownCoordiantes.yPosition
                    }
                }
                return(
                <div style={{height: "50px", width:"50px",position:"relative", left:gridPosition.xPosition*100 + "px", top:(coordinates.yPosition * 100 - gridPosition.yPosition*100) + "px"}}>
                    <RobotLogo />
                        <div style={{textAlign: "center"}}>{obj.gridPosition.stringFormat}</div>
                    </div>)
                })}
        </div>
    )
}
 export default PlanetGrid