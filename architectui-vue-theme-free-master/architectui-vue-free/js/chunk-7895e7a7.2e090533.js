(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-7895e7a7"],{"1a01":function(t,s,i){"use strict";var e=function(){var t=this,s=t.$createElement,i=t._self._c||s;return i("div",{staticClass:"app-page-title"},[i("div",{staticClass:"page-title-wrapper"},[i("div",{staticClass:"page-title-heading"},[i("div",{staticClass:"page-title-icon"},[i("i",{class:t.icon})]),i("div",[t._v("\n                "+t._s(t.heading)+"\n                "),i("div",{staticClass:"page-title-subheading"},[t._v("\n                    "+t._s(t.subheading)+"\n                ")])])]),i("div",{staticClass:"page-title-actions"},[i("button",{staticClass:"btn-shadow mr-3 btn btn-dark",attrs:{type:"button"}},[i("font-awesome-icon",{attrs:{icon:"star"}})],1),i("button",{staticClass:"btn-shadow d-inline-flex align-items-center btn btn-success",attrs:{type:"button"}},[i("font-awesome-icon",{staticClass:"mr-2",attrs:{icon:"plus"}}),t._v("\n                Create New\n            ")],1)])])])},a=[],n=i("ecee"),l=i("c074"),o=i("ad3d");n["c"].add(l["J"],l["F"]);var c={components:{"font-awesome-icon":o["a"]},props:{icon:String,heading:String,subheading:String}},r=c,d=i("2877"),u=Object(d["a"])(r,e,a,!1,null,null,null);s["a"]=u.exports},"46c4":function(t,s,i){"use strict";i.r(s);var e=function(){var t=this,s=t.$createElement,i=t._self._c||s;return i("div",[i("page-title",{attrs:{heading:t.heading,subheading:t.subheading,icon:t.icon}}),i("div",{staticClass:"content"},[i("b-card",{staticClass:"main-card mb-3",attrs:{title:"Bootstrap 4 Carousel"}},[i("b-carousel",{staticStyle:{"text-shadow":"1px 1px 2px #333"},attrs:{id:"carousel1",controls:"",indicators:"",background:"#ababab",interval:4e3,"img-width":"1024","img-height":"480"},on:{"sliding-start":t.onSlideStart,"sliding-end":t.onSlideEnd},model:{value:t.slide,callback:function(s){t.slide=s},expression:"slide"}},[i("b-carousel-slide",{attrs:{caption:"First slide",text:"Nulla vitae elit libero, a pharetra augue mollis interdum.","img-src":"https://picsum.photos/1024/480/?image=52"}}),i("b-carousel-slide",{attrs:{"img-src":"https://picsum.photos/1024/480/?image=54"}},[i("h1",[t._v("Hello world!")])]),i("b-carousel-slide",{attrs:{"img-src":"https://picsum.photos/1024/480/?image=58"}}),i("b-carousel-slide",[i("img",{staticClass:"d-block img-fluid w-100",attrs:{slot:"img",width:"1024",height:"480",src:"https://picsum.photos/1024/480/?image=55",alt:"image slot"},slot:"img"})]),i("b-carousel-slide",{attrs:{caption:"Blank Image","img-blank":"","img-alt":"Blank image"}},[i("p",[t._v("\n              Lorem ipsum dolor sit amet, consectetur adipiscing elit. Suspendisse\n              eros felis, tincidunt a tincidunt eget, convallis vel est. Ut pellentesque\n              ut lacus vel interdum.\n            ")])])],1),i("div",{staticClass:"divider"}),i("p",{staticClass:"mt-4"},[t._v("\n          Slide #: "+t._s(t.slide)),i("br"),t._v("\n          Sliding: "+t._s(t.sliding)+"\n        ")])],1)],1)],1)},a=[],n=i("1a01"),l={components:{PageTitle:n["a"]},data:function(){return{heading:"Carousels & Slideshows",subheading:"Create easy and beautiful slideshows with these Vue components.",icon:"pe-7s-album icon-gradient bg-sunny-morning"}}},o=l,c=i("2877"),r=Object(c["a"])(o,e,a,!1,null,null,null);s["default"]=r.exports}}]);