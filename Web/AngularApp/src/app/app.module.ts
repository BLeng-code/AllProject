import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

@NgModule({ // 元数据
    declarations: [
        // 声明组件、指令、管道
        AppComponent
    ],
    exports:[
        // 导出组件、指令、管道给别的模块使用
    ],
    imports: [
        // 导入其他的模块
        BrowserModule,
        AppRoutingModule
    ],
    providers: [
        // 提供服务
    ],
    bootstrap: [
        // 启动模块，只有根模块才需要
        AppComponent
    ]
})
export class AppModule { }
