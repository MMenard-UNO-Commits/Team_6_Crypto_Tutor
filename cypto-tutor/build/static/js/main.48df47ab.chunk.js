(this["webpackJsonpcrypto-tutor"]=this["webpackJsonpcrypto-tutor"]||[]).push([[0],{12:function(t,e,n){},13:function(t,e,n){},16:function(t,e,n){"use strict";n.r(e);var s=n(1),a=n.n(s),c=n(3),o=n.n(c),r=(n(12),n(4)),l=n(5),i=n(7),u=n(6),b=(n(13),n(0)),d=function(t){Object(i.a)(n,t);var e=Object(u.a)(n);function n(){var t;Object(r.a)(this,n);for(var s=arguments.length,a=new Array(s),c=0;c<s;c++)a[c]=arguments[c];return(t=e.call.apply(e,[this].concat(a))).state={studentName:"",studentID:"",question:"",description:""},t.handleSubmit=function(e){e.preventDefault(),alert("Forms submitted successfully"),window.location="http://localhost:80/learnphp/Pull.php",console.log(t.state.studentName),console.log(t.state.studentID),console.log(t.state.question),console.log(t.state.description)},t}return Object(l.a)(n,[{key:"render",value:function(){var t=this;return Object(b.jsxs)("div",{className:"p-3 mb-2 bg-light bg-opacity-50 text-dark",children:[Object(b.jsx)("h1",{children:"Submit Question"}),Object(b.jsxs)("form",{className:"forms",children:[Object(b.jsxs)("fieldset",{children:[Object(b.jsx)("label",{children:"Student Name"}),Object(b.jsx)("br",{}),Object(b.jsx)("input",{className:".form-control-sm",name:"name",value:this.state.studentName,onChange:function(e){return t.setState({studentName:e.target.value})},placeholder:"Your name"}),Object(b.jsx)("br",{}),Object(b.jsx)("label",{children:"Student ID"}),Object(b.jsx)("br",{}),Object(b.jsx)("input",{className:".form-control-sm m-1",name:"id",value:this.state.studentID,onChange:function(e){return t.setState({studentID:e.target.value})},placeholder:"Your ID"}),Object(b.jsx)("br",{}),Object(b.jsx)("label",{children:"Question"}),Object(b.jsx)("textarea",{className:"form-control",rows:"7",name:"question",value:this.state.question,onChange:function(e){return t.setState({question:e.target.value})},placeholder:"Type a Question"}),Object(b.jsx)("br",{}),Object(b.jsx)("label",{children:"Description"}),Object(b.jsx)("textarea",{className:"form-control",name:"description",rows:"7",value:this.state.description,onChange:function(e){return t.setState({description:e.target.value})},placeholder:"Type a code fragments"})]}),Object(b.jsx)("button",{onClick:this.handleSubmit,type:"submit",className:"btn btn-outline-success m-3",children:"Submit"})]})]})}}]),n}(s.Component),j=d,h=function(t){t&&t instanceof Function&&n.e(3).then(n.bind(null,17)).then((function(e){var n=e.getCLS,s=e.getFID,a=e.getFCP,c=e.getLCP,o=e.getTTFB;n(t),s(t),a(t),c(t),o(t)}))};n(15);o.a.render(Object(b.jsxs)(a.a.StrictMode,{children:[Object(b.jsx)(j,{}),","]}),document.getElementById("root")),h()}},[[16,1,2]]]);
//# sourceMappingURL=main.48df47ab.chunk.js.map