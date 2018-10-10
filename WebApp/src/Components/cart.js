import React, { Component } from 'react';
import { bindActionCreators } from 'redux';
import { connect } from 'react-redux';
import * as CartAction from '../actions/cart';
import Shelf from './shelf';

console.log("in cart component");

class Cart extends Component{
    constructor(props) {
        super(props);
    }

    render(){
        const CartItems = this.props.cart.map((item, idx) => {
            return <li key={idx}>{item}</li>
        });
        console.log("in cart component, this ", this);
        return(
            <div className = "Cart">
                <Shelf addItem={this.props.action.addToCart}/>
                <h2>Shopping Bag</h2>
                <ol>
                    {CartItems}
                </ol>

            </div>
        );
    }
}

function mapStateToProps(state, prop){
    console.log("in cart component mapStateToProps, state=",state);
    return{
        cart: state.cart
    }
}

function mapDispatchToProps(dispatch){
    return{
        action: bindActionCreators(CartAction, dispatch)
    }
}

export default connect(mapStateToProps, mapDispatchToProps)(Cart);