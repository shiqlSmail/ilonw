webpackJsonp([18],{"T+/8":function(t,o,i){"use strict";Object.defineProperty(o,"__esModule",{value:!0});var e=i("lbHh"),n=i.n(e),s="supportKey";function a(t){return n.a.set(s,t,{expires:3})}var l=i("hNpR"),r=i.n(l),c={name:"login",data:function(){return{loginForm:{username:"admin",password:"123456"},loginRules:{username:[{required:!0,trigger:"blur",validator:function(t,o,i){["admin","test"].indexOf(o.trim())>=0?i():i(new Error("请输入正确的用户名"))}}],password:[{required:!0,trigger:"blur",validator:function(t,o,i){o.length<3?i(new Error("密码不能小于3位")):i()}}]},loading:!1,pwdType:"password",login_center_bg:r.a,dialogVisible:!1,supportDialogVisible:!1}},methods:{showPwd:function(){"password"===this.pwdType?this.pwdType="":this.pwdType="password"},handleLogin:function(){var t=this;this.$refs.loginForm.validate(function(o){if(!o)return console.log("参数验证不合法！"),!1;var i=n.a.get(s);void 0!==i&&null!=i?(t.loading=!0,t.$store.dispatch("Login",t.loginForm).then(function(){t.loading=!1,t.$router.push({path:"/"})}).catch(function(){t.loading=!1})):t.dialogVisible=!0})},dialogConfirm:function(){this.dialogVisible=!1,a(!0)},dialogCancel:function(){this.dialogVisible=!1,a(!1)}}},p={render:function(){var t=this,o=t.$createElement,i=t._self._c||o;return i("div",[i("el-card",{staticClass:"login-form-layout"},[i("el-form",{ref:"loginForm",attrs:{autoComplete:"on",model:t.loginForm,rules:t.loginRules,"label-position":"left"}},[i("div",{staticStyle:{"text-align":"center"}},[i("svg-icon",{staticStyle:{width:"56px",height:"56px",color:"#409EFF"},attrs:{"icon-class":"login-mall"}})],1),t._v(" "),i("h2",{staticClass:"login-title color-main"},[t._v("mall-admin-web")]),t._v(" "),i("el-form-item",{attrs:{prop:"username"}},[i("el-input",{attrs:{name:"username",type:"text",autoComplete:"on",placeholder:"请输入用户名"},model:{value:t.loginForm.username,callback:function(o){t.$set(t.loginForm,"username",o)},expression:"loginForm.username"}},[i("span",{attrs:{slot:"prefix"},slot:"prefix"},[i("svg-icon",{staticClass:"color-main",attrs:{"icon-class":"user"}})],1)])],1),t._v(" "),i("el-form-item",{attrs:{prop:"password"}},[i("el-input",{attrs:{name:"password",type:t.pwdType,autoComplete:"on",placeholder:"请输入密码"},nativeOn:{keyup:function(o){return"button"in o||!t._k(o.keyCode,"enter",13,o.key,"Enter")?t.handleLogin(o):null}},model:{value:t.loginForm.password,callback:function(o){t.$set(t.loginForm,"password",o)},expression:"loginForm.password"}},[i("span",{attrs:{slot:"prefix"},slot:"prefix"},[i("svg-icon",{staticClass:"color-main",attrs:{"icon-class":"password"}})],1),t._v(" "),i("span",{attrs:{slot:"suffix"},on:{click:t.showPwd},slot:"suffix"},[i("svg-icon",{staticClass:"color-main",attrs:{"icon-class":"eye"}})],1)])],1),t._v(" "),i("el-form-item",{staticStyle:{"margin-bottom":"60px"}},[i("el-button",{staticStyle:{width:"100%"},attrs:{type:"primary",loading:t.loading},nativeOn:{click:function(o){return o.preventDefault(),t.handleLogin(o)}}},[t._v("\n          登录\n        ")])],1)],1)],1),t._v(" "),i("img",{staticClass:"login-center-layout",attrs:{src:t.login_center_bg}}),t._v(" "),i("el-dialog",{attrs:{title:"特别赞助",visible:t.supportDialogVisible,width:"30%"},on:{"update:visible":function(o){t.supportDialogVisible=o}}},[i("span",[t._v("mall项目已由CODING特别赞助，点击去支持，页面加载完后点击"),i("span",{staticClass:"color-main font-medium"},[t._v("免费体验")]),t._v("按钮即可完成支持，谢谢！")]),t._v(" "),i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{on:{click:t.dialogCancel}},[t._v("残忍拒绝")]),t._v(" "),i("el-button",{attrs:{type:"primary"},on:{click:t.dialogConfirm}},[t._v("去支持")])],1)]),t._v(" "),i("el-dialog",{attrs:{title:"公众号二维码",visible:t.dialogVisible,"show-close":!1,center:!0,width:"30%"},on:{"update:visible":function(o){t.dialogVisible=o}}},[i("div",{staticStyle:{"text-align":"center"}},[i("span",[t._v("mall全套学习教程连载中"),i("span",{staticClass:"color-main font-medium"},[t._v("关注公众号")]),t._v("第一时间获取")]),t._v(" "),i("img",{staticStyle:{"margin-top":"10px"},attrs:{src:"http://macro-oss.oss-cn-shenzhen.aliyuncs.com/mall/banner/qrcode_for_macrozheng_258.jpg",width:"150",height:"150"}})]),t._v(" "),i("span",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[i("el-button",{attrs:{type:"primary"},on:{click:t.dialogConfirm}},[t._v("确定")])],1)])],1)},staticRenderFns:[]};var d=i("VU/8")(c,p,!1,function(t){i("sKgd")},"data-v-39ce8b4c",null);o.default=d.exports},hNpR:function(t,o,i){t.exports=i.p+"static/img/login_center_bg.5307896.png"},sKgd:function(t,o){}});
//# sourceMappingURL=18.dc9bd5d673ac6e17fa9d.js.map