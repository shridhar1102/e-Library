# e-Library
e-Library
This Project contains the basic business logic of Lending Library. Project has concepts like Inheritanc, Interface,Abstract, Polymor
phism. UI is not created 


Angular -6

Session - 1

libraries - Jquery- dom manipulation library, React
frameworks -Angular, Backbone, Ember, EXT-JS, Vue.JS

MPA vs SPA
http://www.eikospartners.com/blog/multi-page-web-applications-vs.-single-page-web-applications

MPA - Multi Page application
  - 3 links -> index.html ->content of link1
SPA - Single Page application
 - MPA vs SPA - 
    MPA is a traditional kind of web application. This means that every time the application needs to display the data or submit data back to server it has to request a new page from the server and then render it in the web browser. Nothing is wrong with this approach for simple applications. But if there is a need to create a rich user interface then the page might become very complex and to be loaded with a lot of data. Generating complex pages on a server and transfer them to the client over the internet and rendering them into the browser takes time and degrade the user experience because of that. In the beginning of 2000s MPA was improved by introducing AJAX, which allowed refreshing only parts of the page and not the whole page. It helped to improve the user experience but added complexity to the page itself

    In SPA
     Client can handle loading all the pages that are required and will send requests to server only for the data and initial loading.

     -we get more fluid experience

    ex: http://www.example.com -> index.html - initial page request
        susequent page rendering requests like below will be taken care by the client
        http://www/example.com/account
        http://www/example.com/about
    Router component in SPA -> listens on URL change events and replace the existing view with a matching template based on URL

Different versions of Angular(1,2,4,5,6)

Angular CLI - dependency is Node-JS(NPM)
  -setting up project
  -npm install -g @angular/cli - npm update -g @angular/cli
  -ng -v
  -ng new myapp
  -ng serve -open -> builds the application and starts dev server and opens the browser
  -ng serve --port=customPortNumber
  -ng g c name -> to generate component
  -ng g s name -> to generate service
  -ng g d name -> to generate directive
  -ng g m name -> to generate module
  -ng build -prod 
  -ng serve -prod
  -ng test -> used to run all the unit tests in our app
  -ng test --code-coverage -> generates code coverage reports for the tests we have
  -ng update -> update older angular version app to newer version
  -ng add libraryname -> used to add a library to our app
  -Editing the app with changes

-Integrated terminal
-Documentation

Project structure
    -e2e -> end to end testing folder
    -node_modules -> contains dependencies
    -src
     app -> contains application related source code
      -shared -> any shared code between components/modules
     assets ->
     environments -> any environement specific properties

Angular concepts

Angular application bootstrapping
 -as a part of compilation and build process, index.html will have the required scripts injected by angular cli
 - inspect the html rendered and we can see those scripts
 -main bundle js contains all the code that we write for our application development
 -vendor bundle.js contains angular framework code and any other library code
 -runtime.js / inline bundle js contains some webpack utilities that are used to load the other files, eventually the code in this file is written directly to index.html
 -pollyfill bundle js contains pollyfills required to run the application in lower browsers
 -style bundle js contains styles defined
 
 -main bundle will start execution from main.ts
 -main.ts bootstraps the App module
 -App module bootstraps the application root component which is AppComponent.ts

-Session-2

 -Components
   -A component in angular is a class
   -the component is annotated/decorated with @Component annotation/decorator
   -Component properties 
   (https://angular.io/docs/ts/latest/api/core/index/Component-decorator.html)
     -selector :- css selectors - class,[attribute] or a custom element selector
       attribute selector selector:'[attributeNameOfHtmlElement]'
         ex: <div someName>Hello</div>, selector:[someName]
             <div id="someName">Hello</div>,selector:'[id=someName]''
       css class selector  selector:'.cssClass'
         ex: <div class="someName">Hello</div>, selector:'.someName'
       element selector : selector:'app-other'
         ex: <app-root></app-root>, selector:'app-root'
     -template :- define html markup for our component
     -templateUrl :- point to the location where we have the html template file defined
     -styleUrls :- specify the location of css files for the component
     -styles :- inline styles
     -encapsulation:ViewEncapsulation.None,ViewEncapsulation.Emulated,ViewEncapsulation.Native
      -https://blog.thoughtram.io/angular/2015/06/29/shadow-dom-strategies-in-angular2.html
   -Component can have member variables and methods
   -Component members can be accessed in the template using string interpolation({{memberName}})
   -ng generate component nameOftheComponent(ng g c nameofthecomponent)
   -ng g c nameofthecomponent --flat -> dont create a separate folder
   -ng g c nameofthecomponent -t -s -> inline template, iniline styles
   -ng g c nameofthecomponent -t -s --spec=false -> dont generate spec file

Angular modules
   - A module is a collection of services, components,directives and pipes
 -@NgModule decorator tell angular that this a module
  -declarations lists all the components that this module owns
  -import property defines the dependent modules
  -providers section define the application level services
-Creating our own module
Angular built in modules
- Core - decorators/annotations
- forms - form handling
- http - http module for making rest calls
- animations - animation module provides animations in our application
- browser - contains some directives
- router - defined routing configurations in the application

-Zen coding html
-Usage of ng-content directive to create container component
-installing bootstrap css
Include bootstrap css and js
  -npm uninstall bootstrap3
  -npm install bootstrap@3.3.7 jquery --save
  -modify angularcli.json
    "styles": [
        "../node_modules/bootstrap/dist/css/bootstrap.css",
        "styles.css"
      ],
      "scripts": [
        "../node_modules/jquery/dist/jquery.js",        
        "../node_modules/bootstrap/dist/js/bootstrap.js"
      ]

Data binding in angular
 -communication between the component and the template in the form of data and events
 -Different Methods to perfom data binding
   -String Interpolation - {{}}
     - {{variable}}
        //lets say if count is variable defined in component with value set to 200
        {{count}}, {{count + 1}}, {{count * 10}}, {{count /10}}, {{count - 10}} 
         
     -  calling functions in the component 
     	getCount():number{ 
     		return 200;
     	}
     	 {{getCount()}}, {{getCount() + 10}}

     - for objects like below in the component 
         var emp = {fName:"Mike", lName:"Marcel", img:"http://lorempixel.com/200/200/people/", hide:true,
         description:"Employee is a nice employee, he works very hard"};
 	     {{emp.fName}}, {{'hello '+emp.fName}}
         <img src={{emp.img}} alt="{{emp.fName}}">
         
Session - 3

   -Property binding - [] 
     - Assigns a component property to html element attribute/dom props
       <img [src]="emp.img" [alt]=emp.fName>
       //textContent property is a DOM property for the element
         http://www.w3schools.com/jsref/prop_node_textcontent.asp
       <h1 [textContent]="emp.fName"></h1>
       <p [hidden]="emp.hide">hello paragraph</p>
       <p [innerHTML]="emp.description"></p>


   -Event binding - () 
     http://www.w3schools.com/jsref/dom_obj_event.asp
     ex: <input type="text" (input)="captureInput($event)">
         {{enteredInput}}
        In Component
         enteredInput:string;
         captureInput(event){
           console.log(event.target.value);
           this.enteredInput = event.target.value;
         }
         //another way to write captureInput
         //below KeyboardEvent interface is defined in WEB API's
         captureInput(event:KeyboardEvent){
    		this.inputCaptured = (<HTMLInputElement>event.target).value;
  		 }

    ex: <input type="text" (input)="enteredInput = $event.target.value">
         {{enteredInput}}
        In Component
         enteredInput:string;
  	ex: 
  	 <input type="text" (keypress)="captureKeyPress($event)">
     or
     <input type="text" on-keypress="captureKeyPress($event)">
       
      captureKeyPress(event:KeyboardEvent){
    	     console.log(event.code);
    	     console.log(event.key);
  	  }

  	ex:
  	 <button type="button" (click)="handleClick($event)">Submit</button>
  	 handleClick(event:MouseEvent){
    	console.log(event);
     }
  -Event filtering
     <input type="text" (keyup)="handleKeyUp($event)">

     handleKeyup(event){
      if(event.keyCode == 13){console.log('enter is pressed')}
     }

     <input type="text" (keyup.enter)="handleKeyUp()">

     handleKeyup(){
      console.log('enter is pressed');
     }

   -Two way data binding- [(ngModel)] -> property + event binding
     -Add the below to the app module
    import { FormsModule, ReactiveFormsModule } from '@angular/forms';
    -Add FormsModule to import array in app module
   	ex: 
   	  <input type="text" [(ngModel)]="userInput">
      {{userInput}}
      userInput:string = "hello"; //In the component
 
    ex: Two way data binding break down
    	<input type="text" [value]="userInput" (input)="userInput=$event.target.value">
    	{{userInput}}
    	<br/>
    	<input type="text" [ngModel]="userInput1" (ngModelChange)="userInput1=$event">
    	{{userInput1}}
  		userInput:string = "hello"; //In the component
  		userInput1:string = "hello"; //In the component

     -Attribute binding - for non-standard DOM properties
     ex: <p [attr.aria-label]="test">Hello..</p>
        In component
          test:string="Hello..."

Session - 4
   -Include formsmodule in app module
   -Template variables
     ex:   <p #sometemp>{{someVal}}</p>
    	   <p>{{sometemp.textContent}}</p>

     ex: setting html input object to a temp variable phone
        <input type="text" #phone>
    	<button type="button" (click)="handleClick(phone.value)">Submit</button>
        In component 
           handleClick(phoneNumber){
             console.log(phoneNumber);
           }  
     ex: to setup local access to the template variable in component we can define it as viewchild
		 <p #sometemp>{{someVal}}</p>
    	 <p>{{sometemp.textContent}}</p>

    	 @ViewChild ('sometemp')
       sometempProperty:ElementRef;


   - Component interactions
      -Input interaction -> send an input from one component to another component
      -Output interaction ->a component emits an event as an output to let other component know about something
   	- Custom property binding using Input annotation
   		In the component
    	  @Component({
    	    selector:'some-component',
    		template:`
    			<p [style.color]="textColor">
      				{{text}}
    			</p>
    		`    
    	  })
    	  export class SomeComponent{
    	  	text:string="hello custom property binding";
  		  	@Input() textColor:string;
  		  }

  		  @Component({
  		  	selector:'some-othercomponent',
  		  	template:`
  		  		<some-component [textColor]="'red'"></some-component>
  		  		<some-component [textColor]="'green'"></some-component>	  		
  		  	`
  		  })
  		  export class SomeOtherComponent{

  		  }

 - Creating custom events in angular 
 	-we use EventEmitter object to create custom events
 	 ex:
		@Component({
		  selector: 'app-customevent',
		  template: `
		    <p (click)="onClicked()">
		      customevent Works!
		    </p>
		  `
		})
		export class CustomeventComponent{
		  @Output()clicked:EventEmitter<String> = new EventEmitter<String>();

		  onClicked(){
		    this.clicked.emit("My custom event");
		  }
		}
	In App component
	 <app-customevent (clicked)="handleOnClick($event)"></app-customevent>
	 In App component ts add
	 handleOnClick(value){
	 	console.log(value);
	 }
-Aliases for inputs/outputs
- inputs and outputs array in component decorator can be used as alternative to using 
  ex:
  @Input('alias') and @Output('alias')
  @Component({
  	outputs:[clicked:alias]
  })
  export class SomeClass{
    clicked:EventEmitter<String> = new EventEmitter();
  }

Session - 5 - Directives

-Instructions to angular to perform an operation(rendering/iterations)

-Attribute directives -ngStyle ngClass
  -Changes the appearence and behavior of the dom element
Setting CSS style property
     <p [style.background-color]="emp.fName != null ? 'red':'green'">Hello world</p>
   //Add active to class attribute based on a condition
     <p [class.active]="emp.fName != null">Hello Appi..</p>
   //Setting more than one style property using ngStyle and ngClass
     <p [ngStyle]="{'background-color': emp.fName != null ? 'red':'green',
            'color': emp.mName != null ? 'red':'green'}">
        Hello ng style
     </p>
     <p [ngClass]="{'active' : emp.fName != null,
            'bold':emp.lName != null}">
       Hello ng class
     </p>


-Structured directives - *ngFor[ngFor],*ngIf or[ngIf], ngFor with index, ngSwitch-case
  - Changes the dom layout by adding and removing elements
  ngFor
	  ex: ngFor - lets says items is an array in component
	    <ul>
	      <li *ngFor="let item of items">{{item}}</li>
	    </ul>
      <ul>
        <li *ngFor="let item of items; let i=index">{{i + ':' + item}}</li>
      </ul>
	  ex: https://angular.io/docs/ts/latest/guide/template-syntax.html#!#star-template
	  <ul>
	      <ng-template ngFor let-color [ngForOf]="colors">
	        <li>{{color}}</li>
	      </ng-template>
	    </ul>
  ngIf
    ex: In component we have user:User = new User('Mike','Marcel',true);

    	<div *ngIf="user.active">
      		Active user: {{user.fName}}
    	</div>
      //ng if with else 
      <div *ngIf="user.active;then activeUser else inactiveUser">div>
      <ng-template #activeUser>
        Active user: {{user.fName}}
      </ng-template>
      <ng-template #inactiveUser>
        InActive user: {{user.fName}}
      </ng-template>
      <div *ngIf="user.active;else inactiveUser">
        Active user: {{user.fName}}
      </div>
      <ng-template #inactiveUser>
        InActive user: {{user.fName}}
      </ng-template>
      
    ex:
    	<template [ngIf]="user.active">
      		<span>Hello {{user.fName}}</span>    
    	</template>
     you can not apply ngif and ngfor for same element, in this case use ng-template 
     <ul> 
          <ng-template ngFor let-course [ngForOf]="courses">
            <li *ngIf="course.active">      
                {{course.name}}
            </li>   
          </ng-template>    
      </ul>

//show hide using hidden
   <div [hidden]="course.length === 0">List of courses</div>
   <div [hidden]="course.length > 0">No courses</div>
-for small element trees - use hidden
-for large element trees - if sub tree building is costly then use hidden
                         - if sub tree building is not costly then ng-if

Session - 6

   ngSwitch
      ex: In the component create color property with value matching the case
	    <div [ngSwitch]="color">
	      <div *ngSwitchCase="'red'">
	         color is red
	      </div>
	      <div *ngSwitchCase="'blue'">
	         color is blue
	      </div>
	      <div *ngSwitchDefault>
	         no color matched
	      </div>
	    </div>

	   ex:
		<div [ngSwitch]="color">
	      <ng-template [ngSwitchCase]="'red'">
	        <div>
	          color is red
	        </div>
	      </ng-template>
	      <ng-template [ngSwitchCase]="'blue'">
	        <div>
	          color is blue
	        </div>
	      </ng-template>
	      <ng-template ngSwitchDefault>
	        <div>
	          no color matched
	        </div>
	      </ng-template>
	    </div>

-Creating custom attribute directive
   -cd to the folder that you want to create the directive
   - ng g d customAttribute
  
-Creating custom structure directive
  -create unless structure directive which behaves exactly opposite to ngIf
  -ngIf shows content when it gets boolean true
  -unless hides content when it gets boolean false

- Sharing directives with multiple modules

Services and Dependency Injection
 -promotes code re-use
 -share data and functionality across multiple components
 -sharing data can happen from parent to child components
 -or different components
 -Angular creates a new instance if you dont tell that the components share the service
 -Create a services folder to create services under app
 -CD to the services folder from command line
 -To create a service use ng generate service nameOftheservice
   or ng g s nameOfService
   ex: ng g s user
	If more than one component needs to use the same instance of the Userservice
	remove the service declaration from providers section in the component and add it to the module providers section

	One service can also depend on another service
	 -ex:
	  @Injectable()
		export class LoggerService {

		  constructor() { }

		  logMessage(message:any){
		    console.log(message);
		  }
		  
		}
	-Add the loggerservice instance to the constructor to have it injected		
	-Angular also provides some in built services like Http, Renderer

Session - 7

-Routing
	-listens to url changes and based on url it identifies the components
	- removes the existing views and replace it with new views or templates
	- so a url is mapped to a component
	    ex: http://localhost:8080/myApp/user -> UserComponent
	        http://localhost:8080/myApp/user/10 -> UserDetailComponent and so on
	Step 1:

	Create three components to link to routing
	ng g c home --it --is
	ng g c page1 --it --is
	ng g c page2 --it --is
	ng g c notfound --flat --it --is

	Step 2:

	 -create app.routing.ts file in the app folder and define routes like below
	  export const routing = RouterModule.forRoot([
	  	{path:'', component: HomeComponent},
	  	{path:'page1', component: Page1Component},
	  	{path:'page2', component: Page2Component}
	  ]);
	  //add relavent imports, the RouterModule comes from @angular/router module
    
    Step 3:
     -Import and add the const routing to the import section in AppModule
     - Add <router-outlet></router-outlet> to app component html file
     - Test the routes if they are working by changing the url in the browser
       http://localhost:4200 -> Home component
       http://localhost:4200/page1 -> Page1 component
	   http://localhost:4200/page12-> Page2 component

  - Navigation with links
  	-Add the anchor elements to app component html file like below
  		<a routerLink="page1">Page1</a>
		<a routerLink="page2">Page2</a>
		<a routerLink="">Home</a>
	- Nesting routes check - From Page1 I want to go to page2
	  add page2 anchor to page1 component html as below
	  <p>
      	page1 Works!
      </p>
      <a routerLink="page2">Page 2</a>
      when we put click on page2 link then browser will try to load a nested route like below
       http://localhost:4200/page1/pag2 which doesn't exist
       but our intention is to go to page2
       so
       change anchor to have <a routerLink="/page2">Page2</a>
       we can also define an anchor like
        <a routerLink="../">Home</a>

  - Imperative navigation(navigation in code)  

  	<button type="button" (click)="navigate()">Go to Page 2</button>
    constructor(private _router:Router) { }
  	navigate(){
    	this._router.navigate(['/page2']);
  	}

  -Route redirection
  	 {path:'pg2', redirectTo:'/page1'},
  
  -Styling active routes
		<a href="" routerLink="" routerLinkActive="active" [routerLinkActiveOptions]={exact:true}>Home</a>
		<a href="" routerLink="page1" routerLinkActive="active">Page 1</a>
		<a href="" routerLink="page2" routerLinkActive="active">Page 2</a>
	-we can also use routerlinkactive on ancestor elements like enclosing div
  
  -Module wide routing
   ng g module my-module --routing
   defining module level routes is a better way

  - Route parameters - passing data to route
     - Create EmployeeList component
       ng g c emplist --is --it
     - Create empDetail component
       ng g c empDetail --flat --is --it
     - Create a new route for empList and empDetail component
     	 {path:'empList',component:EmplistComponent},
    	 {path:'empDetail/:id',component:EmpdetailComponent},
     - Add navigation to emplist component in app component html
     	<a routerLink="empList">Employee List</a>
     - Change emp list component by adding a new emp object like below
        emp = {name:'Peter',id:1};
        add below anchor link to emp list component html
        <a [routerLink]="['/empDetail',emp.id]">Employee 1 Detail</a>
     - Go to home page click on emplist link, then click on emp detail link and see how the navigation happens
  -Accessing route params in the component
     In the emp detail component we can access route params like this, there is a problem with the approach,if we try to load the same route url from the same view, the construtor wont be invoked as routes are intelligent enough to use the same component
     constructor(private acRoute:ActivatedRoute) {
    	this.id = this.acRoute.snapshot.params['id'];
  	 }

  	 solution:
  	   import { Subscription } from 'rxjs'; 
  	   private id:string;
  	   private subscription: Subscription;

	  constructor(private acRoute:ActivatedRoute) {
	    //this.id = this.acRoute.snapshot.params['id'];
      //this.activatedRoute.snapshot.paramMap.get('id')
	    this.subscription = this.acRoute.params.subscribe(param =>{
	      this.id = param['id'];
	    })
	  }
	  ngOnDestroy(){
    	this.subscription.unsubscribe();
  	  }
  Child Routes/Sub view routes
     -child routes are used to define routes for sub views in a main view
     ex: When we have EmpList and EmpDetail components,we know emp detail is a child of emp list component, instead of defining emp detail under main routes, we can create child routes
      -create employee.routes.ts
        -export const EMP_ROUTES:Routes =[
    		{path:'detail/:id', component:EmpdetailComponent}
		 ]
	  -Update app.routing.ts as below, duplicate parent route and set children
	  export const routing = RouterModule.forRoot([
    	{path:'',component:HomeComponent},
    	{path:'page1',component:Page1Component},
    	{path:'page2',component:Page2Component},
    	{path:'empList',component:EmplistComponent, },
    	{path:'empList',component:EmplistComponent, children:EMP_ROUTES},
    	{path:'**', component:NotfoundComponent}
	  ]);
	  -Add <router-outlet> to emp list html where we want employee detail component to appear
 
 Session - 8 

  - Query Params
   - query params are key value pairs that we add to a link ex:?id=1&name=appi
   - we can define query params for a router link like below
   - In order to add query params we dont have to change the app.routing file as the query params are optional params
   ex:
       navigate(){
    	 this._router.navigate(['/page2'],{queryParams:{id:1}});
  	   }
		
	  <a routerLink="/page2" [queryParams]="{id:1}">Page 2</a>

	 Accessing query parameters in the component
	    subscription: Subscription;//import from rxjs
  		id:number;
	 	this.subscription = activatedRoute.queryParams.subscribe(qparams =>{
      		this.id = qparams['id'];     
    	})
    Preserving query params
         <a routerLink="/page2" [queryParams]="{id:1}" preserveQueryParams>Page 2</a>
 		 this._router.navigate(['/page2'],{queryParams:{id:1},preserveQueryParams:true});
    Route fragements
       -starts with a #tag
           this._router.navigate(['/page2'],{fragment:'help', preserveFragemnts:true});
           add an anchor with id page2 some where down
        -Accessing fragment in component
          activatedRoute.fragment.subscribe(fragment =>{
      		this.fragement = fragment;
    	  })
      //add the below to constructor for the page to move to the section
      router.events.subscribe(event => {
        if (event instanceof NavigationEnd) {
            const tree = router.parseUrl(router.url);
            if (tree.fragment) {
              const element = document.querySelector("#" + tree.fragment);
              if (element) { 
                element.scrollIntoView(); 
              }
            }
         }
       });

   Router Gaurds - Router lifecycle hooks
	-gaurds the route activation and de-activation
	-we can show confirm dialogs like are u sure ? for ex: user filled a form and haven't saved it and trying to move to a different page then we can prompt for confirmation..
	-Another example is we can also verify the authorization to check if user has access to the route..

	ex:- create a folder called guards
	   - create a new file auth.guard.ts
	   export class AuthGuard implements CanActivate{

    	 canActivate():boolean{
        	return confirm("Do you really want to visit page 1 ?");
    	 }
	   }

	   activate the guard for the desired route as shown below in the routing file
	   {path:'page1',component:Page1Component, canActivate:[AuthGuard]},
	   
	   -register the guard under providers section in app module

	 CanDeactivate example
	 -create a class called leaving.guard.ts
	 export class LeavingGuard implements CanDeactivate<Page1Component>{
   		canDeactivate():boolean{
        	return confirm("Do you really want leave page 1 ?");
   		}
	 }
	 {path:'page1',component:Page1Component, canActivate:[AuthGuard], canDeactivate:[LeavingGuard]},
	 -register the guard under providers section in app module
	-router location strategies - https://www.tektutorialshub.com/location-strategies-angular/

Session - 9

 -Forms
 	Angular provides FormGroup, FormBuilder classes which can be used to build form controls, handle validations and submissions
 	-Two types of form handling
 	 - Template driven forms
 	      -Add ngModel to every form input and make sure you have name attribute set for the i/p
 	        ex:<input type="text" name="courseId" ngModel>
 	      -On the form create a template variable and assign it to ngForm
 	        ex: <form #f="ngForm">
 	      -Add the ngSubmit to the form element
 	        ex: <form (ngSubmit)="handleSubmit(f)" #f="ngForm">
 	      -Try consoling the form to see the controls and other form properties
 	    -Validation
 	      -We can add required html5 attribute for any required fields
 	      -We can add pattern to bind an input to a regex pattern like email, ssn etc..
 	      -By default angular adds various css classes on inputs depending up on the state of the input control(some classes like ng-invalid, ng-pristine, ng-touched, ng-untouched)
 	      -We can use these classes to style the inputs for any validation errors
 	        ex: .ng-invalid{border-color:red}
 	    -Prepopulate forms with component values
 	      -lets say if we have a course object like course={cname:'Java',courseId:"cb102"}
 	         we can bind these properties to the form using property binding like below
 	         <input type="text" name="courseId" [ngModel]="course.courseId">
			 <input type="text" name="cname" [ngModel]="course.cname">
			imp note: if u change the values it wont effect the component properties as it is one way binding
		-Two way binding
		    It binds the component properties to the inputs, if something changes on either side, the change will reflect on the other side
			<input type="text" name="courseId" [(ngModel)]="course.courseId">
		 	<input type="text" name="cname" [(ngModel)]="course.cname">
		  imp note: even if the form input has invalid data, the component will still be updated.
		
		-Nesting Form controls
		   If there is any nested objects we can group them using FormGroups
		   ex:
		   <form>
		     <div ngModelGroup="address">
		        <div>
		          <input type="text" [ngModel]="user.address.city">
		        </div>
		        <div>
		          <input type="text" [ngModel]="user.address.state">
		        </div>        
		     </div>
		   </form>
		-Handling radio button controls
		  we can not directly set the value of radio button by just setting ngModel on input as there will be more than one radio button with the same name
		  ex: we need to set the value attribute as well
	        <div class="radio" *ngFor="let g of genders">
          		<label>
              		<input type="radio" [value]="g" [(ngModel)]="user.gender" name="gender">{{g}}
          		</label>
        	</div>
	-Showing error messages under input controls
		    ex:
               <input type="text" class="form-control" name="courseId" 
                    ngModel required #courseId="ngModel">
                <div class="alert alert-danger" *ngIf="courseId.touched && courseId.invalid">
                    <div *ngIf="courseId.errors.required">
                        course id is required field
                    </div>
                </div>
 		-Disable submit button when form is invalid
		  -f below here is the template variable we created in the form
		  <form #f="ngForm">
		  	<button type="submit" [disabled]="f.invalid">Submit</button>
		  </form>



 	 - Data driven forms
 	 	-Gives more control on form handling
 	 	-we create the form and form controls in the component
 	 	-We need to import  ReactiveFormModule to app module ts file
 	 	-built in validators
 	 	  https://angular.io/docs/ts/latest/api/forms/index/Validators-class.html
 	 	ex: 
 	 		export class SomeComponent{
 	 			userForm:FormGroup;
 	 			genders:['male','female'];
 	 			constructor(){
 	 				this.userForm = new FormGroup({
 	 					'userName': new FormControl('defaultValue',Validators.required),
 	 					'password': new FormControl('defaultValue',[Validators.required,
 	 						Validators.pattern('')]),
 	 					'address': new FormGroup({
 	 						'city':new FormControl('',Validators.required),
 	 						'state': new FormControl()
 	 					}),
 	 					'gender':new FormControl('male'),
 	 					'interests': new FormArray([
 	 						new FormControl()
 	 					])

 	 				});
 	 			}	
 	 			handleSubmit(){
 	 				console.log(this.userForm);
 	 			}

 	 			addNewInterest(){
 	 				(<FormArray>this.userForm.controls['interests']).push(new FormControl());
 	 			}
 	 		}
      Better way to Avoid the userForm.controls[]call
      -create a getter method
        get userName(){
          return this.userForm.controls['userName'];//or this.userForm.get('userName');
        }
        -replace userForm.controls['userName'].touched to userName.touched
 	 		<form [formGroup]="userForm" (ngFormSubmit)="handleSubmit()">
 	 			Username: <input type="text" formControlName="userName">
 	 			<div *ngIf="userForm.controls['userName'].touched && userForm.controls['userName'].invalid">
 	 				userName is invalid
 	 			</div>
 	 			Password: <input type="password" formControlName="password">
 	 			<div formGroupName="address">
 	 				City: <input type="text" formControlName="city">
 	 				<div *ngIf="userForm.controls['address'].controls['city'].touched &&
 	 				userForm.controls['address'].controls['city'].invalid]">
 	 					City field is invalid
 	 				</div>
 	 				State:<input type="text" formControlName="state">
 	 			</div>
 	 			<div class="radio" *ngFor="let g of genders">
 	 				<label>
 	 					<input type="radio" formControlName="gender" [value]="g">
 	 					{{g}}
 	 				</label>
 	 			</div>
 	 			<button type="button" [disabled]="userForm.invalid">Submit</button>
 	 		</form>
 	 	-Creating form array to the above form
 	 		<div formArrayName="interests">
 	 			<h3>interests</h3>
 	 			<div class="form-group" *ngFor="let interest of userForm.controls['interests'].controls;let i=index">
 	 				<input type="text" class="form-control" formControlName="{{i}}">
 	 			</div>
 	 		</div>
 	 	-Creating a form using FormBuilder
 	 		constructor(fb:FormBuilder){
 	 			this.userForm = fb.group({
 	 				'userName': ['defaultValue',Validators.required, this.cutomerUserNameValidator, this.customAsyncUserNameValidator],
 	 				'password': ['defaultValue',[Validators.required,
 	 						Validators.pattern('')]],
 	 				'address': fb.group({
 	 						'city':['',Validators.required],
 	 						'state': ['']
 	 				}),
 	 				'gender':['male'],
 	 				'interests': fb.array([''])
 	 			});
 	 		}
 	 	-Creating custom validator

 	 		customNameValidator(fc:FormControl){
        console.log(fc.value);
        if((<string>fc.value).startsWith('admin')){
            return null;
        }
        return {needsAdmin:true};
    }
    <div *ngIf="aName.errors?.needsAdmin">
          Name should start with admin
    </div>

 	 	-Creating async validator
 	 	 customNameAsyncValidator(fc:FormControl){
        let v = (<string>fc.value);
        return new Promise((resolve,reject)=>{
            setTimeout(()=>{
                if(v === 'adminAppi'){
                    return resolve({userNameTaken:true});
                }else{
                    return resolve(null);
                }
            },3000);
        });
    }
 	 	-Subscribing to value/status changes
 	 	  this.userForm.valueChanges.subscribe(
 	 	  	(data:any) => console.log(data);
 	 	  );

 	 	  this.userForm.statusChanges.subscribe(
 	 	  	(data:any) => console.log(data);
 	 	  );
 	 	-reset forms
 	 	  this.userForm.reset();

Session - 10

 -Pipes
 	-pipes are used in combination with string interpolation -{{}}
 	-Inbuilt pipes- uppercase,lowercase etc..
 		ex:
 		   {{helloStr | uppercase | lowercase}}
           DOB: {{dob | date:'yy-MM-dd'}} {{dob | date:'fullDate'}}
           
           helloStr:string = "Hello to pipes";
  		   dob:Date = new Date(2015,10,22);

  	-Generating custom pipes
  		ng g p nameofthepipe ex: ng g p doublethevalue
  		  Doubled Numbers
		    <ul>
		      <li *ngFor="let num of nums">
		          {{num | doublethevalue }}
		      </li>
		    </ul>
		   @Pipe({
			  name: 'doublethevalue'
		   })
		   export class DoublethevaluePipe implements PipeTransform {
			  transform(value: any, args?: any): any {
			    return 2 * value;
			  }

			}
		Filtering pipe - filters a list based on condition
		Even Numbers
	    <ul>
	      <li *ngFor="let number of numbers | filter:'even'">
	          {{number}}
	      </li>
	    </ul>
		ng g p filter

		@Pipe({
		  name: 'filter'
		})
		export class FilterPipe implements PipeTransform {

		  transform(value: any, args: string): any {
		    if(args == null || args.length === 0){
		      return value;
		    }
		    let filterArg = args;
		    console.log(filterArg);
		    let result = [];
		   if(filterArg === 'even'){
		      for(let item of value){
		        if(item % 2 === 0){
		          result.push(item);
		        }
		      }
		    }
		   if(filterArg === 'odd'){
		      for(let item of value){
		        if(item % 2 !== 0){
		          result.push(item);
		        }
		      }
		    }
		    
		    return result;
		  }

		}
	-Adding new item to the list dynamically
	 - when there is a new item added to the list, angular doesn't run the filter again eventhough we have the item in the list
	 - angular change detection cycle runs only on primitive changes and reference changes and doen't run when a object behind the reference changes

	 we can tackle the problem by creating a new reference or create an impure pipe
	   ex:  this.numbers = this.numbers.slice();
	 an impure pipe is a pipe which gets updated on each change detection
	 //impure pipes are not good for performance
	  just add pure=false for our pipe as shown below
	  @Pipe({
		  name: 'filter',
		  pure:false
	  })

	-Async pipe - inbuilt pipe
	  {{asyncValue | async}}
	  asyncValue = new Promise((resolve,reject) =>{
      	setTimeout(()=>{
       	 resolve("data is here..");
      	},2000)
  	  });
 
 -issue with the form builder
 -Creating backend for the application using hapi js and mongodb

 -Http and Observables
   -Connecting to server to perform HTTP operations
   -Angular provides http service that we can use to perform server interactions
   -Using Observables we can subscribe for the response that get generated from the http call and perform something in the callback function of the subscription
   ex:
    import { Observable } from 'rxjs';
    import 'rxjs/Rx';

    public getCourses():Observable<any>{
	    return this.http.get(this.url)
	    .map((response)=>response.json())
	    .catch((error) =>{
	      return Observable.of(error.json());
	    });
	}

    this.courseService.getCourses().subscribe((response)=>{
      this.courses = response;
    },(error)=>{console.log(error)})
-To remove the test file during component create we can do
  ng g c nameofthecomponent --flat --is --it --spec false
-unsubscribing observables in ondestroy
-Perfoming async calls with promises
  public getCoursesWithPromise():Promise<Course[]>{
    return this.http.get(this.url).toPromise().then( (response)=>{
      this.courses = response.json();
      return this.courses;
    }).catch((err)=>{
      return Promise.reject(err);  
    });
  }

-Component lifecycle
  -lifecycle hooks
   -Constructor invocation happens
   -ngOnChanges - when data bound input property value changes(when @Input()value changes)
     -ngOnChanges(changes:SimpleChanges)-> oldValue, newValue, firstChange:boolean
   -ngOnInit - called when component and its properties are initialized, executed only once
   -ngDoCheck - executed during every angular change detection cycle (when ever something changes in the component, angular runs a change detection cycle to see what needs to be updated..)
   -ngAfterContentInit - After inserting content with <ng-content>
   -ngAfterContentChecked - Change detection for content changes in ng-content
   -ngAfterViewInit - After initializing the component views/child views
   -ngAfterViewChecked - change detection in views and child views
   -ngOnDestroy - executed when a component is destroyed

Debugging 
 - Using chrome developer tools we can debug the generated JS code or typescript code as well
 - Augery is a nice chrome extension that we can use as well

-Angular 2 best practices
	-creating feature specific modules
	-creating re-usable modules like the directives module
	-create module wide routing so we can lazy load the components
	-define unit tests for the code
	-keep modules small
	-run prod build with ng build --prod and ng build --prod --aot(ahead of time compilation)

-Unit testing angular 2 code
 --Jasmine - unit testing framework 
 --Karma - test runner
 --protractor - for end to end testing angular application(selenium like testing)

 ng test

 https://github.com/angular/angular-cli/blob/master/README.md

 -Handle errors
 - Unexpected - server is offline, network is down, unhandled exceptions
 - Expected - Not found(404), Bad request(400)

 -Add error functions for all subscribe methods, add a generic error first for unexpected errors
   ex: this.as.getAuthors().subscribe(response =>{
      //do something with the response
      },error =>{
        alert('An unexpected error occured');
        console.log(error.json());
      })
 -for create and delete, in error subscribe check for 400 for create(this.form.setErrors(errors.json())) and 404 for delete and alert a message to the user
  ex:
     this.as.save(author).subscribe(response =>{
      //do something with the response
      },(error:Response) =>{
        if(error.status === 400){
          //Bad request set form errors
        }else{
          alert('An unexpected error occured');
          console.log(error.json());
        }
      })
 -Seperation of concerns.. refactor the code to move the error handling to the service
  -create a AppError class which takes the error object in the constructor
  -create a NotFoundError class which handles not found error
   export class AppError{
     constructor(public originalError:any){}
   }
   export class NotFoundError extends AppError{}
   export class BadInput extends AppError{}
  -for the delete method in service add a catch for http.delete in the service
   import 'rxjs/add/operator/catch'; -> catch is an instance method
   import 'rxjs/add/observable/throw'; ->throw is a static method
   import {Observable} from 'rxjs';
   delete(authodId:number){
    return this.http.delete(this.URL+'/'+authorId).catch((error:Response)=>{
      if(error.status === 404){
        return Observable.throw(new NotFoundError())
      }
      return Observable.throw(new AppError(error))
    }};
   }
  -After creating this in the component error method we can change the error response type to AppError and use error instanceof NotFoundError instead of checking for 404, same thing for bad request
-Global Error Handler
 -instead of repeating the code in the error block in the component, we can create a global error handler
  export class AppErrorHandler implements ErrorHandler{
     handleError(error){
       alert('An unexpected error occurred');
       console.log(error)
     }
  }
  -after defining the class register this error handler in the providers section of the module
   providers:[{provide:ErrorHandler,useClass:AppErrorHandler}]
  -We can remove the error blocks where we dont have special cases other than delete and create
    for delete and create in the else block we can just write else throw error;
-Reusable error handler
 create a handleError function that handles all errors and pass that as the second parameter to the service subscribe method
-Extracting a data service
-Using map operator
-Using new httpclient instead of http
  -advantages of http client
    1. incterceptors
    2. we dont have to call .json() on the response
    3. better error handling
  -Replace where ever we use Http to HttpClient(import { HttpClient, HttpHeaders } from '@angular/common/http');
  -Remove all the .json() calls in component or in service whereever we have it
  -Change Headers to HttpHeaders
  -Using Http Interceptor
    -create a class like below
      export class HttpClientInterceptor implements HttpInterceptor{
        intercept(req: HttpRequest<any>, next: HttpHandler): 
            Observable<HttpSentEvent | HttpHeaderResponse | HttpProgressEvent 
            | HttpResponse<any> | HttpUserEvent<any>> {
          let method:string = req.method;
          if( method === 'POST' || method === 'PUT' || method === 'PATCH'){
              const jsonReq = req.clone({
                headers: req.headers.set('content-type', 'application/json')
              });
              return next.handle(jsonReq);
          }
          return next.handle(req);
      }
    }
    -register the interceptor at the module level like below under providers section
     {  provide: HTTP_INTERCEPTORS, useClass: HttpClientInterceptor, multi: true },
     {  provide: HTTP_INTERCEPTORS, useClass: AnotherInterceptor, multi: true }
 Observables vs Promises
 -Observables follow pub/sub model where the component subscribed will get responses once they are published/available
 -Observables can be cancellable
 -Observables can return multiple values over time where as promise returns a single value
 -We can use debouncing feature in observables to postpone the request execution after some time
 -Observables also has some useful operators such as map, flatmap, filter etc..
 -We can use fork/join to make multiple asyn calls and subscribe to the responses
  ex: Observable.forkJoin(results).subscribe()
-Observable can be retried with the retry/retrywhen operator which can not be done in promises

Observable cons
-In ES7 Promises have an async and await functions,with them we can write asyn ccode like it would be a sync function call, the only way to do this to convert an observable to promise
 ex: async function getData(){
  const data =await observable.first().toPromise()
  //work with data
 }

-Using retry

-Using Nodemon - npm install -g nodemon and nodemon server.js
----------Implementing Authentication------------
1.Creating the Signup and Login components
2.Defining routes for the components
3.Define User service that does handle both user create and login
4.Define users collection that stores user info
5.Define REST API that supports the new operations user creation and user login
6.Add required validation for login and signup components
7.Hide the navbar main menu options when user is on login or signup page
8.Add Logout link and route that takes userback to login page
9.Add JWT token support for the backend, so up on successfull login we receive a token from the server
10.Add the received token to the local storage
11.Up on logout clear the local storage
12.Enable the authorization guard on the routes other than login and signup to check the presence of token before activating the route, if the token is not present, route the user back to login page(for this you need to inject router into the guard so mark it with @Injectable() and add router to constructor)
13.Add a new interceptor that send the token as an Authorization header to the server for every request after log in and add it to the authormodule
14.Add functionality in the backend to check for the presence of the authorization header and valid token before processing the request, if the authorization header is not found or if the token is not found, send 401 unauthorized
15. finally use bcrypt library to encrypt and decrypt your password


-Password credential grant type is used when working with SPA with REST API
-Client credential grant type is used for only REST API

A server-side web app: use authorization code.
A client-side web app (or mobile app): use implicit.
An integration with an OAuth service you built yourself, use password credentials.
An application that doesn’t interact with user data: use client credentials.



Unit -> Jasmine,
Integration -> Jasmine
End to End -> Protractor, Selenium

const httpOptions = {
            headers: new HttpHeaders({
                'Content-Type':  'application/json'
            })
        };
this._httpClient.delete(`${this.url}/${id}`,
        {observe: 'response'})
        .catch(this.handleError);

-----Running Angular and Spring on one server---------------------
Add maven resources plugin to spring boot pom file
-the plugin will copy all the files in angular project dist folder to static folder under resources in spring boot project
-then run mvn clean install and mvn spring-boot:run

----------------------------------NGRX-----------------------------
-state management
-one central store to keep the state
-components and services can dispath action to the reducers
-reducers take an action and payload and returns immutable state to the store
-store lets the components know about the new data

-npm install --save @ngrx/store
-----------------course-reducer.ts---------------
import { Action } from '@ngrx/store';
import  { CourseActions } from './course-actions';

const initialState = {
  courses:[]
}

export function CourseListReducer(state=initialState, action:CourseActions){
  switch(action.type){
    case CourseActions.ADD_COURSE:
      return {
        ...state,
        courses: [...state.courses,action.payload]
      };
    case CourseActions.UPDATED_COURSE:
      const course = state.courses[action.payload.index];
      const updatedCourse = {...course,...action.payload.course};
      const courses = [...state.courses];
      courses[action.payload.index] = updatedCourse;
      return {
        ...state,
        courses:courses
      };
    case CourseActions.DELETE_COURSE:
      const oldCourses = [...state.courses];
      oldCourses.splice(action.payload, 1);
      return {
        ...state,
        courses: oldCourses
      };
    default:
      return state;
  }
  
}
-----------------course-actions.ts--------------
import { Action } from '@ngrx/store';
export const ADD_COURSE = 'ADD_COURSE';
export const UPDATE_COURSE = 'UPDATE_COURSE';
export class AddCourse implements Action{
  readonly type = ADD_COURSE;
  constructor(public payload:Course){

  }
}
export class UpdateCourse implements Action{
  readonly type = UPDATE_COURSE;
  constructor(public payload:{index:number, course:Course}){

  }
}

export type CourseActions = AddCourse | UpdateCourse;
-----------course.module.ts----------

import {StoreModule} from '@ngrx/store';
//import CourseListReducer
under imports of ngmodule decorator add  below 
  StoreModule.forRoot({courseList:CourseListReducer })
-----course-list.component.ts---------
import { Store }from '@ngrx/store';
@Component({
  template:`
    <ul>
      <li *ngFor="let course of (courseListState | async).courses">
        {{course.name}}
      </li>
    </ul>
  `
})
export class CourseListComponent{
  courseListState:Observable<{courses:Course[]}>;
  constructor(private store:Store<{courseList:{courses:Course[]}}>){

  }

  ngOnInit(){
    this.courseListState = this.store.select('courseList');
  }
}
----------course-form.component.ts-----------
import { Store }from '@ngrx/store';
import * as CourseActions from '../course-actions';

export class CourseFormComponent{
  constructor(private store:Store<{courseList:{courses:Course[]}}>){

  }

  handleSubmit(){
    if(add){
      this.store.dispatch({new CourseActions.AddCourse(newCourseToBeAdded)})
    }else{
      this.store.dispatch({new CourseActions.UpdateCourse({index:1,updatedCourse})})
    }
    
  }
}

http://localhost/cards/10 - Path parameters
