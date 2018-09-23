//import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import 'antd/dist/antd.css';
//import App from './App';
import registerServiceWorker from './registerServiceWorker';
//import { Router, Route } from 'react-router';
//import { Link } from 'react-router-dom';
//import { Breadcrumb, Alert } from 'antd';
//import { Form, Input, Icon, Button } from 'antd';

import React, { Component } from 'react';
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';
import Home from './contents/Home/Home';
//import nav1 from './contents/nav1/nav1';
import { Layout, Menu } from 'antd';
const { Header, Footer } = Layout;

class Index extends Component {
  render() {
    return (
      <div className="Index">
        <Router>
          <Layout className = "IndexLayout">
            <Header className = "header">
              <Menu 
                theme="dark"
                mode="horizontal"
                defaultSelectedKeys={['1']}
                style={{ lineHeight: '64px' }}
              >
                <Menu.Item key="1"><Link to='/'>Home</Link ></Menu.Item>
                
              </Menu>
            </Header>

            <div>
              <Route exact path ="/" component={Home}/>
              
            </div>

            <Footer style={{ textAlign: 'center' }}>
              my-fisrt-try©2018 Created by LSJ
            </Footer>
          </Layout>          
        </Router>
      </div>
    );
  }
}
 
  ReactDOM.render(
    <Index />,
    document.getElementById('root')
  );
  
  
registerServiceWorker();
