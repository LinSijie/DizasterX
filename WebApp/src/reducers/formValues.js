console.log("in formValues reducer");

export default(state = [], payload) => {
    //console.log("in formItem reducer,payload=",payload);
    //console.log("in formItem reducer,state=",state);
    switch(payload.type){
        case 'update':
            //console.log("in formItem reducer add,state=",state);
            return payload.values;
        default:
            //console.log("in formItem reducer default,state=",state);
            return state;
    }
};