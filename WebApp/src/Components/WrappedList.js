import React, { Component } from 'react'
import { List } from 'antd';
import 'antd/dist/antd.css';

class WrappedList extends Component{
    render(){
        return(
            <div>
            <h3 style={{ marginBottom: 16 }}>DizasterX</h3>
            <List
                      
                style={{ marginLeft: 16 }}
                dataSource={data}
                renderItem={item => (
                    <List.Item>
                        <List.Item.Meta
                        description={
                            <div>
                                {item.title},{item.state},{item.type},{item.startdate},{item.enddate}
                            </div>
                        }
                        />
                    </List.Item>
                )}
                pagination={{
                    onChange: (page) => {
                        console.log(page);
                    },
                    pageSize: 10,
                }}
            />
            </div>
        );
    }
}

export default WrappedList;

//data to be listed
const data = [
        {title: "ICE JAM AND FLOODING", state: "AK", type: "Flood", startdate: "2011-05-08T15:30:00.000Z", enddate: "2011-05-13T00:00:00.000Z"},
        {title: "ICE JAM AND FLOODING", state: "AK", type: "Flood", startdate: "2011-05-08T15:30:00.000Z", enddate: "2011-05-13T00:00:00.000Z"},
        {title: "ICE JAM AND FLOODING", state: "AK", type: "Flood", startdate: "2011-05-08T15:30:00.000Z", enddate: "2011-05-13T00:00:00.000Z"},
        {title: "MOOSE MOUNTAIN FIRE", state: "AK", type: "Fire", startdate: "2011-05-20T15:30:00.000Z", enddate: "2011-06-02T03:59:00.000Z"},
        {title: "SEVERE WINTER STORMS AND FLOODING", state: "AK", type: "Severe Storm(s)", startdate: "2011-11-08T00:01:00.000Z", enddate: "2011-11-13T00:00:00.000Z"},
        {title: "SEVERE WINTER STORMS AND FLOODING", state: "AK", type: "Severe Storm(s)", startdate: "2011-11-08T00:01:00.000Z", enddate: "2011-11-13T00:00:00.000Z"},
        {title: "SEVERE WINTER STORMS AND FLOODING", state: "AK", type: "Severe Storm(s)", startdate: "2011-11-08T00:01:00.000Z", enddate: "2011-11-13T00:00:00.000Z"},
        {title: "SEVERE WINTER STORMS AND FLOODING", state: "AK", type: "Severe Storm(s)", startdate: "2011-11-08T00:01:00.000Z", enddate: "2011-11-13T00:00:00.000Z"},
        {title: "SEVERE STORM", state: "AK", type: "Severe Storm(s)", startdate: "2011-11-15T00:00:00.000Z", enddate: "2011-11-17T23:59:00.000Z"},
        {title: "SEVERE WINTER STORMS AND FLOODING", state: "AK", type: "Severe Storm(s)", startdate: "2011-11-08T00:01:00.000Z", enddate: "2011-11-13T00:00:00.000Z"},
        {title: "SEVERE STORM, STRAIGHT-LINE WINDS, FLOODING, AND LANDSLIDES", state: "AK", type: "Severe Storm(s)", startdate: "2012-09-15T16:00:00.000Z", enddate: "2012-09-30T00:00:00.000Z"},
        {title: "SEVERE STORM, STRAIGHT-LINE WINDS, FLOODING, AND LANDSLIDES", state: "AK", type: "Severe Storm(s)", startdate: "2012-09-15T16:00:00.000Z", enddate: "2012-09-30T00:00:00.000Z"},
        {title: "SEVERE STORM, STRAIGHT-LINE WINDS, FLOODING, AND LANDSLIDES", state: "AK", type: "Severe Storm(s)", startdate: "2012-09-15T16:00:00.000Z", enddate: "2012-09-30T00:00:00.000Z"},
        {title: "SEVERE STORM, STRAIGHT-LINE WINDS, FLOODING, AND LANDSLIDES", state: "AK", type: "Severe Storm(s)", startdate: "2012-09-15T16:00:00.000Z", enddate: "2012-09-30T00:00:00.000Z"},
        {title: "SEVERE STORM, STRAIGHT-LINE WINDS, FLOODING, AND LANDSLIDES", state: "AK", type: "Severe Storm(s)", startdate: "2012-09-15T16:00:00.000Z", enddate: "2012-09-30T00:00:00.000Z"},
        {title: "FLOODING", state: "AK", type: "Flood", startdate: "2013-05-17T18:30:00.000Z", enddate: "2013-06-11T23:59:00.000Z"},
        {title: "FLOODING", state: "AK", type: "Flood", startdate: "2013-05-17T18:30:00.000Z", enddate: "2013-06-11T23:59:00.000Z"},
        {title: "FLOODING", state: "AK", type: "Flood", startdate: "2013-05-17T18:30:00.000Z", enddate: "2013-06-11T23:59:00.000Z"},
        {title: "FLOODING", state: "AK", type: "Flood", startdate: "2013-05-17T18:30:00.000Z", enddate: "2013-06-11T23:59:00.000Z"},
        {title: "FLOODING", state: "AK", type: "Flood", startdate: "2013-05-17T18:30:00.000Z", enddate: "2013-06-11T23:59:00.000Z"},
        {title: "SEVERE STORMS, STRAIGHT-LINE WINDS, AND FLOODING", state: "AK", type: "Severe Storm(s)", startdate: "2013-11-05T00:01:00.000Z", enddate: "2013-11-14T00:00:00.000Z"}

  ];


                    


                    
                      