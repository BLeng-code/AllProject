import { Component } from '@angular/core';

@Component({ // 元数据
    selector: 'app-root',  // 组件的标签名，可以在html中直接使用，比如<app-root></app-root>
    templateUrl: './app.component.html',  // 模板路径
    styleUrls: ['./app.component.css'], // 样式表
    animations:[
    ]
})
export class AppComponent {
    title = 'AngularApp';
}
