import React, {useState} from 'react';
import {useSelector} from 'react-redux'
import {ReactComponent as RobotLogo} from './SVG/Robot.svg';

function PlanetGrid(){
    var coordinates = useSelector(state => state.robots.coordinates)
    var gridRobots = useSelector(state => state.robots.gridRobots)
    console.log(coordinates)
    return (
        <div style={{postion: "absolute", margin: "auto", backgroundColor:"#9D0000", height:((coordinates.yPosition * 100) + 70) + "px", width:((coordinates.xPosition *100) + 70) + "px"}}>
            {gridRobots.map((obj) => {
                var colour = "#FFD700"
                var gridPosition = {
                    xPosition: obj.gridPosition.endCoordinates.xPosition,
                    yPosition: obj.gridPosition.endCoordinates.yPosition
                }
                if (obj.gridPosition.isLost){
                    
                    colour = "#000000"
                    gridPosition = {
                        xPosition: obj.gridPosition.lastKnownCoordiantes.xPosition,
                        yPosition: obj.gridPosition.lastKnownCoordiantes.yPosition
                    }
                }
                return(
                <div style={{height: "50px", width:"50px",position:"relative", left:gridPosition.xPosition*100 + "px", top:(coordinates.yPosition * 100 - gridPosition.yPosition*100) + "px"}}>
                    <RobotLogo style={{fill: colour}}/>
                        <div style={{textAlign: "center", fontSize: "10px", color:colour}}>{obj.gridPosition.stringFormat}</div>
                    </div>)
                })}
        </div>
    )
}
 export default PlanetGrid