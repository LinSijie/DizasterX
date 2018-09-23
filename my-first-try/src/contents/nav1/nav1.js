import React, { Component } from 'react'
import { BrowserRouter as Router, Route, Link } from 'react-router-dom';
import 'antd/dist/antd.css';
import './nav1.css';
import { Layout, Breadcrumb, Icon } from 'antd';
const { Content } = Layout;

class nav1 extends Component {

    render() {
        return (
            <div>
                <Layout>
                    <Layout style={{ padding: '0 24px 24px',margin: 10 }}>
                        <Breadcrumb>
                            <Breadcrumb.Item href="">
                                <Icon type="home" />
                            </Breadcrumb.Item>
                            <Breadcrumb.Item href="">
                                
                                <Icon type="smile" />
                                <span>nav1</span>
                            </Breadcrumb.Item>
                        </Breadcrumb>
                        <Content style={{ background: '#fff', padding: 24, margin: 10, minHeight: 280 }}>
                            Content<br/>
                            Content<br/>
                            Content<br/>
                            Content<br/>
                            Content<br/>
                        </Content>
                    </Layout>
                </Layout>
            </div>
        );
    }
}

export default nav1;

