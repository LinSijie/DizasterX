# DizasterX-WebApp

Front End of DizasterX

## Front End Repo
React + Ant-design
`WebApp` is the directory for local development and local test.
###`WebApp` structure:

```
WebApp/
├── public/
│   ├── favicon.ico
│   ├── index.html
│   ├──manifest.json
│
├── src/
│   ├── Components/
|   |   ├── UrlConcat.js
|   │   ├── WrappedForm.js   
|   │   └── WrappedList.js        
|   │                 
|   ├── index.js
|   ├── index.css
|   ├── logo.svg
|   └── registerServiceWorker.js
|
├── package-lock.json
├── package.json
└── README.md
```
### Function Description

`index.js` describes the layout of the website. The website is divided into 4 parts: Header, Sider, Content, and Footer. The search bars lays in the Sider part. Searching results are listed in the Content part.

`WrappedForm.js` is a component of search bars. It is a form with 4 form items(date picker, state picker, disaster picker and submit buttom). Component `UrlConcat` is called to pass the form values.

`UrlConcat.js` is a component which concatenate URLs and fetch data.  Not finished.

`DataExtract.js` is a component which extract key information from the data. To Do

`WrappedList.js` is a component which display the searching result. It receive data from `DataExtract.js`. To Do


