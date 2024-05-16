# Angular

# Setting up our front-end

This guide explains how to set up your environment for Angular development using the [Angular CLI tool](https://angular.io/cli "CLI command reference"). It includes information about prerequisites, installing the CLI, creating an initial workspace and starter app, and running that app locally to verify your setup.

https://angular.io/guide/setup-local


## Preparing our design

Before getting our hands dirty with creating components and stuff, we have to check some design practices in order our app to follow some standarts and look nice.
The following link shows the magic behind CSS Flexbox -> https://css-tricks.com/snippets/css/a-guide-to-flexbox/

After you've checked it, we will continue by practicing the new knowledge you've already gained by playing a little short game -> https://flexboxfroggy.com/

## Create our brand new component

So now you have to generate a component called racers-component which will visualize all racers form the DB.  
You have to follow each step in order to complete this task:
1.  Navigate to your Angular project directory.
2.  Use Angular CLI to generate the component:

```
ng generate component racers-component
```
This command will create a folder named `racers-component` inside your `src/app/front-end` directory, and it will generate the necessary files for the component, including HTML, CSS, TypeScript, and a test file.

So far, you know how to create a component. Use the same steps to create components for the other important tables of your project.


After creating your application if there is no AppModule, add manually one:

```typescript
import { AppComponent } from './app.component';  
import { BrowserModule } from '@angular/platform-browser';  
import { NgModule } from '@angular/core';  
  
 
@NgModule({  
  declarations: [  
    AppComponent  
  ],  
  imports: [  
    BrowserModule  
  ],  
  providers: [],  
  bootstrap: [AppComponent]  
})  
export class AppModule { }
```

## Make a listing table using flex

So far you have made yourself a nice component. So now lets proceed with some visual stuff. Let me give you and example which you have to complete.

You have this html excerpt:

```html
<div class="main-container">
  <div class="table-container">
    <div class="table-row heading">
      <div class="row-item">Category 1</div>
    </div>
    <div class="table-row">
      <div class="row-item">Item 1</div>
    </div>
  </div>
</div>
```
You have to complete it by making it 4 columns.

You have the following css classes:

```css
/* just a reset of the css */
body {
  position: absolute;
  height: 100%;
  width: 100%;
  margin: 0;
  padding: 0;
  font-family: 'Helvetica';
}
.main-container {
  width: 100%;
  height: 100%;
  display: flex;
  margin: 0;
  justify-content: center;
  align-items: center;
  background-color: #fafafa;
}

.table-container {
  display: flex;
  flex-flow: column nowrap;
  background-color: white;
  width: 80%;
  margin: 0 auto;
  border-radius: 4px;
  border: 1px solid #DADADA;
  box-shadow: 0px 1px 4px rgba(0, 0, 0, .08);
}

.table-row {
  display: flex;
  flex-flow: row nowrap;
  width: 100%;
  border-bottom: 1px solid #dadada;
}

.heading {
  background-color: #ececec;
  color: #3e3e3e;
  font-weight: bold;
}

.row-item {
  display: flex;
  flex: 1;
  font-size: 14px;
  padding: 8px 0;
  justify-content: center;
  align-items: center;
  transition: all 0.15s ease-in-out;
}

.row-item:hover {
  cursor: pointer;
  background-color: #F0F0F0;
/*   box-shadow: 0px 1px 4px rgba(0, 0, 0, .08); */
}

.row-sub-container {
  display: flex;
  flex-flow: column nowrap;
  flex: 1;
}

.row-sub-container .row-item {
  padding: 8px 0;
  border-bottom: 1px solid #dadada;
}

.table-row:last-child,
.row-sub-container .row-item:last-child {
  border-bottom: 0;
}
```

Apply it to the component.


## Creating a model for the racer

