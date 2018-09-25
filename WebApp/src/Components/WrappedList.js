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
                renderItem={item => (<List.Item>{item}</List.Item>)}
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
    'Racing car sprays burning fuel into crowd.',
    'Japanese princess to wed commoner.',
    'Australian walks 100km after outback crash.',
    'Man charged over missing wedding girl.',
    'Los Angeles battles huge wildfires.',
    'Racing car sprays burning fuel into crowd.',
    'Japanese princess to wed commoner.',
    'Australian walks 100km after outback crash.',
    'Man charged over missing wedding girl.',
    'Los Angeles battles huge wildfires.',
    'Racing car sprays burning fuel into crowd.',
    'Japanese princess to wed commoner.',
    'Australian walks 100km after outback crash.',
    'Man charged over missing wedding girl.',
    'Los Angeles battles huge wildfires.',
  ];


                    


                    
                      