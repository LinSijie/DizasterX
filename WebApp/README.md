# DizasterX-WebApp

Front End of DizasterX

## Front End Repo

React + Ant-design
`WebApp` is the directory for local development and local test.

### Structure

```bash
WebApp/
├── public/
│   ├── favicon.ico
│   ├── index.html
│   ├──manifest.json
│
├── src/
|   │
│   ├── actions/
|   │   ├── fetchData.js
|   │   ├── updateForm.js
|   │   └── urlConcat.js
|   │
│   ├── Components/
|   │   ├── WrappedForm.js
|   │   └── WrappedList.js
|   │
│   ├── reducers/
|   │   ├── fetchData.js
|   │   ├── formValues.js
|   │   ├── index.js
|   │   └── url.js
|   │
|   ├── App.js
|   ├── App.css
|   ├── index.js
|   ├── index.css
|   ├── logo.svg
|   ├── registerServiceWorker.js
|   └── store.js
|
├── package-lock.json
├── package.json
└── README.md
```

### Function Description


`WrappedForm.js` is a component of search bars. It is a form with 4 form items(date picker, state picker, disaster picker and submit buttom). Component `UrlConcat` is called to pass the form values.


`WrappedList.js` is a component which display the searching result. To Do


###Notes

`cart.js` and `shelf.js` are test files.