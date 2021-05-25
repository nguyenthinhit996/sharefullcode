import { Component } from '@angular/core';
import { AppService, Student } from './app.service'

@Component({
    selector: 'foo-details',
    providers: [AppService],
    template: `<div class="container">
    <h1 class="col-sm-12">Foo Details</h1>
 
   
    <div ngModel="foos" *ngFor="let foo of foos; index as i; first as isFirst" >
        <div class="col-sm-12">
        <label class="col-sm-3">ID</label> <span>{{foo.age}}</span>
        </div>
        <div class="col-sm-12">
            <label class="col-sm-3">Name</label> <span>{{foo.name}}</span>
        </div>
    </div>

   
    <div class="col-sm-12">
        <button class="btn btn-primary" (click)="getFoo()" type="submit">New Foo</button>        
    </div>


    <div class="col-sm-12">
        <button class="btn btn-primary" (click)="addStudent()" type="submit">Add</button>        
    </div>


    <div class="col-sm-12">
        <button class="btn btn-primary" (click)="editStudent()" type="submit">edit</button>        
    </div>

    <h1 ngModel="origanzation"> {{origanzation}} </h1>

    <div class="col-sm-12">
        <button class="btn btn-primary" (click)="getOriganzation()" type="submit">getOriganzation</button>        
    </div>

    <div class="col-sm-12">
        <button class="btn btn-primary" (click)="refreshToken()" type="submit">refreshToken</button>        
    </div>

</div>`
})

export class StudentComponent {
    
    public origanzation:any = "not set";

    public foo = new Student(1, 'sample foo');
    public foos: Array<Student> = Array<Student>();

    private foosUrl = 'http://localhost:8081/resource-server/api/student';
    private origanzationURL = 'http://localhost:8081/resource-server/user/info';

    constructor(private _service: AppService) { }

    getFoo() {
        this.foos.push(this.foo);
        this._service.getResource(this.foosUrl)
            .subscribe(
                data => this.foos = data,
                error => this.foo.name = 'Error');
    }

    addStudent(){
        let foos = new Student(1, 'sample student newwwwwww');
        console.log(foos);
        this._service.addStudent(this.foosUrl,foos)
        .subscribe(
            data => {console.log(data)
                this.foos=data;
            },
            error => this.foo.name = 'Error');
    }

    editStudent(){
        let foo = new Student(66666, 'sample student newwwwwww');
        this._service.editStudent(this.foosUrl,foo)
        .subscribe(
            data => console.log(data),
            error => this.foo.name = 'Error');
    }

    getOriganzation(){
        this._service.getOriganzation(this.origanzationURL)
        .subscribe(
            data => this.origanzation = JSON.stringify(data),
            error => this.foo.name = 'Error');
    }
    refreshToken(){
        this._service.refreshToken()
        .subscribe(
            data => console.log(data),
            error => this.foo.name = 'Error');
    }
}