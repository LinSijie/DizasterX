import React, { Component } from 'react'
import { bindActionCreators } from 'redux';
import * as FetchAction from '../actions/fetchData';
import { connect } from 'react-redux';
import { List } from 'antd';
import 'antd/dist/antd.css';

class WrappedList extends Component{
    constructor(props){
        super(props);
        console.log("in list constructor");
    }

    
    render(){
        console.log("in list render, list.props:",this.props);
        
        //console.log("in List render, this.props:",this.props);
        //console.log("in List render, this.props.fetchData:",this.props.fetchData);
        //console.log("in List render, data:",data);
        return(
            <div>
            <h3 style={{ marginBottom: 16 }}>DizasterX</h3>
            <List
                      
                style={{ marginLeft: 16 }}
                dataSource={this.props.fetchData}
                renderItem={item => (
                    <List.Item>
                        <div>
                        {item.title}, {item.state}, {item.type}, {item.startdate}, {item.enddate}
                        </div>
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

function mapStateToProps(state, prop){
    console.log("in list component mapStateToProps, state=",state);
    return{
        url: state.url,
        fetchData: state.fetchData
    }
  }

function mapDispatchToProps(dispatch){
    return{
        action: bindActionCreators(FetchAction, dispatch)
    }
}
  
export default connect(mapStateToProps,mapDispatchToProps)(WrappedList);

                    

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
                    
                      