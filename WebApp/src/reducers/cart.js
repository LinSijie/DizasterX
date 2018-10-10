console.log("in cart reducer");

export default(state = [], payload) => {
    //console.log("in cart reducer,payload=",payload);
    //console.log("in cart reducer,state=",state);
    switch(payload.type){
        case 'add':
            //console.log("in cart reducer add,state=",state);
            return [...state, payload.item];
        default:
            //console.log("in cart reducer default,state=",state);
            return state;
    }
};