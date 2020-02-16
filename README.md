# Easy Exchange

[![N|Solid](https://www.exchangerate-api.com/img/logo-medium.png)](https://https://www.exchangerate-api.com/)



Easy Exchange is a currency converter android application. It contains are

  - Converter
  - Calculator


### Tech

Easy exchange use exchangerate api to fetch current rates of currencies:
* [Exchange Rate API](https://www.exchangerate-api.com/) 

### Installation

Clone the repo and run in android studio.
For best result, Use Pixel 2 API 29

### JSON 

www.exchangerate-api.com return json format on calling the api.
Sample calling:
```sh
https://api.exchangerate-api.com/v4/latest/USD
```

It wil return the bellow format of JSON
```sh
{
	"base": "USD",
	"date": "2019-03-20",
	"time_last_updated": 1553092232,
	"rates": {
		"USD": 1,
		"AUD": 1.408403,
		"CAD": 1.329501,
		"CHF": 0.999398,
		"CNY": 6.711962,
		"EUR": 0.880807,
		"GBP": 0.755043
		"HKD": 7.850285,
		"...": 1.311357,
		"...": 7.4731, etc. etc.
	}
}
```

Upon Error the following is the response

```sh
{
	"result": "error",
	"error": "unknown-code"
}
```

### Screenshot



<img width="274" alt="ss1" src="https://user-images.githubusercontent.com/17185722/74599327-ec934600-504d-11ea-9ab5-b2e117b81a2c.png">

<img width="278" alt="ss2" src="https://user-images.githubusercontent.com/17185722/74599334-07fe5100-504e-11ea-9bac-7451423d002b.PNG">

<img width="282" alt="ss3" src="https://user-images.githubusercontent.com/17185722/74599339-19dff400-504e-11ea-8d04-d8c9e6cd0963.PNG">

<img width="281" alt="ss4" src="https://user-images.githubusercontent.com/17185722/74599340-219f9880-504e-11ea-90f1-bc2f3e112452.PNG">

<img width="284" alt="ss5" src="https://user-images.githubusercontent.com/17185722/74599342-29f7d380-504e-11ea-80e2-4433b7b8450d.PNG">

<img width="282" alt="ss6" src="https://user-images.githubusercontent.com/17185722/74599344-30864b00-504e-11ea-805d-3d2321a658b9.PNG">


### License

sonym3@gmail.com


**Free Software, Hell Yeah!**

[//]: # (These are reference links used in the body of this note and get stripped out when the markdown processor does its job. There is no need to format nicely because it shouldn't be seen. Thanks SO - http://stackoverflow.com/questions/4823468/store-comments-in-markdown-syntax)


   [dill]: <https://github.com/joemccann/dillinger>
   [git-repo-url]: <https://github.com/joemccann/dillinger.git>
   [john gruber]: <http://daringfireball.net>
   [df1]: <http://daringfireball.net/projects/markdown/>
   [markdown-it]: <https://github.com/markdown-it/markdown-it>
   [Ace Editor]: <http://ace.ajax.org>
   [node.js]: <http://nodejs.org>
   [Twitter Bootstrap]: <http://twitter.github.com/bootstrap/>
   [jQuery]: <http://jquery.com>
   [@tjholowaychuk]: <http://twitter.com/tjholowaychuk>
   [express]: <http://expressjs.com>
   [AngularJS]: <http://angularjs.org>
   [Gulp]: <http://gulpjs.com>

   [PlDb]: <https://github.com/joemccann/dillinger/tree/master/plugins/dropbox/README.md>
   [PlGh]: <https://github.com/joemccann/dillinger/tree/master/plugins/github/README.md>
   [PlGd]: <https://github.com/joemccann/dillinger/tree/master/plugins/googledrive/README.md>
   [PlOd]: <https://github.com/joemccann/dillinger/tree/master/plugins/onedrive/README.md>
   [PlMe]: <https://github.com/joemccann/dillinger/tree/master/plugins/medium/README.md>
   [PlGa]: <https://github.com/RahulHP/dillinger/blob/master/plugins/googleanalytics/README.md>
