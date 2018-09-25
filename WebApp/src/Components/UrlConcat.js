import React, { Component } from 'react';


class UrlConcat extends Component {

    constructor(props) {
        super(props);
        console.log(props);
        // In ES6, need binding
        this.setState = this.setState.bind(this)
    }
    
    /*
    componentDidMount() {
        fetch("http://localhost:8080/getEncounter/?")
            .then(res => {
                if (JSON.stringify(res.ok)){console.log("Response success");return res.json();}
            })
            .then(data => {
                // console.log(data);
                let Encounters = [];
                if (data.entry === undefined) {
                    this.setState({
                        encounters: [],
                    });
                    return;
                }
                for (let i = 0; i < 10; ++i) {
                    if (data.entry[i] === undefined) break;
                    let entry = data.entry[i].resource;
                    // get data
                    console.log(entry);
                    let Name = entry.patient.display;
                    let ID = entry.id;
                    let startDate = entry.period.start;
                    let endDate = entry.period.end;
                    let PatientID = entry.patient.reference;
                    Encounters[i] = {name: Name, id: ID, patientID: PatientID, startdate: startDate, enddate: endDate };
                }
                this.setState({
                    encounters: Encounters,
                });

            });
    }
    
    */


    render(){
        console.log('In Url render')
        return(
            <div><h1>URL Component</h1></div>
        );
    }

    componentWillReceiveProps(newProps) {
        console.log('In Url ReceiveProps');
        console.log(newProps);
        console.log(this.props);
        
        if (this.props.values === newProps.values){
            return;
        } else {
            let values = newProps.values;
            if (values.statePicker[0] === undefined && values.datePicker === undefined && values.disasterPicker === undefined) {
                return;
            }
        }
        
        let values = newProps.values;
        let state = values.statePicker === undefined ? '':values.statePicker;
        let date = values.datePicker === undefined ? '':values.datePicker;
        let type = values.disasterPicker === undefined ? '':values.disasterPicker;

        console.log(state);
        console.log(date);
        console.log(type);
        
        let url = "http://czy-kasakun.com:8080/DizasterX/webapi/data/";
        let len = url.length;
        if (state !== '')
            url = url + 'state?value=' + state;

        /*if (type !== '') {
            let temp = len === url.length? ('type?value=' + type):('&type?value='+ type);
            url += temp;
        }

        if (date !== '') {
            let temp = len === url.length? ('date?value=' + date):('&date?value='+ date);
            url += temp;
        }
        */
        console.log(url);
        
        fetch(url)
            .then(res => {
                if (JSON.stringify(res.ok)){console.log("Response success");return res.json();}
            })
            /*
            .then(data => {
                let Encounters = [];
                if (data.entry === undefined) {
                    this.setState({
                        encounters: [],
                    });
                    return;
                }
                for (let i = 0; i < 10; ++i) {
                    if (data.entry[i] === undefined) break;
                    let entry = data.entry[i].resource;
                    // get data
                    console.log(entry);
                    let Name = entry.patient.display;
                    let ID = entry.id;
                    let startDate = entry.period.start;
                    let endDate = entry.period.end;
                    let PatientID = entry.patient.reference;
                    Encounters[i] = {name: Name, id: ID, patientID: PatientID, startdate: startDate, enddate: endDate };
                }
                // console.log(Encounters);
                this.setState({
                    encounters: Encounters,
                });
                // console.log(this.state.encounters);
            });*/
    }

}

export default UrlConcat;