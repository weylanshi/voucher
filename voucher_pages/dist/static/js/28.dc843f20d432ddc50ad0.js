webpackJsonp([28],{"405r":function(t,n,e){"use strict";var i=Object.assign||function(t){for(var n=1;n<arguments.length;n++){var e=arguments[n];for(var i in e)Object.prototype.hasOwnProperty.call(e,i)&&(t[i]=e[i])}return t};function o(t){if(Array.isArray(t)){for(var n=0,e=Array(t.length);n<t.length;n++)e[n]=t[n];return e}return Array.from(t)}!function(){function n(t){function n(t){t.parentElement.removeChild(t)}function e(t,n,e){var i=0===e?t.children[0]:t.children[e-1].nextSibling;t.insertBefore(n,i)}function r(t,n){var e=this;this.$nextTick(function(){return e.$emit(t.toLowerCase(),n)})}var s=["Start","Add","Remove","Update","End"],a=["Choose","Sort","Filter","Clone"],l=["Move"].concat(s,a).map(function(t){return"on"+t}),d=null;return{name:"draggable",props:{options:Object,list:{type:Array,required:!1,default:null},value:{type:Array,required:!1,default:null},noTransitionOnDrag:{type:Boolean,default:!1},clone:{type:Function,default:function(t){return t}},element:{type:String,default:"div"},move:{type:Function,default:null},componentData:{type:Object,required:!1,default:null}},data:function(){return{transitionMode:!1,noneFunctionalComponentMode:!1,init:!1}},render:function(t){var n=this.$slots.default;if(n&&1===n.length){var e=n[0];e.componentOptions&&"transition-group"===e.componentOptions.tag&&(this.transitionMode=!0)}var i=n,r=this.$slots.footer;r&&(i=n?[].concat(o(n),o(r)):[].concat(o(r)));var s=null,a=function(t,n){s=function(t,n,e){return void 0==e?t:((t=null==t?{}:t)[n]=e,t)}(s,t,n)};if(a("attrs",this.$attrs),this.componentData){var l=this.componentData,d=l.on,c=l.props;a("on",d),a("props",c)}return t(this.element,s,i)},mounted:function(){var n=this;if(this.noneFunctionalComponentMode=this.element.toLowerCase()!==this.$el.nodeName.toLowerCase(),this.noneFunctionalComponentMode&&this.transitionMode)throw new Error("Transition-group inside component is not supported. Please alter element value or remove transition-group. Current element value: "+this.element);var e={};s.forEach(function(t){e["on"+t]=function(t){var n=this;return function(e){null!==n.realList&&n["onDrag"+t](e),r.call(n,t,e)}}.call(n,t)}),a.forEach(function(t){e["on"+t]=r.bind(n,t)});var o=i({},this.options,e,{onMove:function(t,e){return n.onDragMove(t,e)}});!("draggable"in o)&&(o.draggable=">*"),this._sortable=new t(this.rootContainer,o),this.computeIndexes()},beforeDestroy:function(){this._sortable.destroy()},computed:{rootContainer:function(){return this.transitionMode?this.$el.children[0]:this.$el},isCloning:function(){return!!this.options&&!!this.options.group&&"clone"===this.options.group.pull},realList:function(){return this.list?this.list:this.value}},watch:{options:{handler:function(t){for(var n in t)-1==l.indexOf(n)&&this._sortable.option(n,t[n])},deep:!0},realList:function(){this.computeIndexes()}},methods:{getChildrenNodes:function(){if(this.init||(this.noneFunctionalComponentMode=this.noneFunctionalComponentMode&&1==this.$children.length,this.init=!0),this.noneFunctionalComponentMode)return this.$children[0].$slots.default;var t=this.$slots.default;return this.transitionMode?t[0].child.$slots.default:t},computeIndexes:function(){var t=this;this.$nextTick(function(){t.visibleIndexes=function(t,n,e){if(!t)return[];var i=t.map(function(t){return t.elm}),r=[].concat(o(n)).map(function(t){return i.indexOf(t)});return e?r.filter(function(t){return-1!==t}):r}(t.getChildrenNodes(),t.rootContainer.children,t.transitionMode)})},getUnderlyingVm:function(t){var n=function(t,n){return t.map(function(t){return t.elm}).indexOf(n)}(this.getChildrenNodes()||[],t);return-1===n?null:{index:n,element:this.realList[n]}},getUnderlyingPotencialDraggableComponent:function(t){var n=t.__vue__;return n&&n.$options&&"transition-group"===n.$options._componentTag?n.$parent:n},emitChanges:function(t){var n=this;this.$nextTick(function(){n.$emit("change",t)})},alterList:function(t){if(this.list)t(this.list);else{var n=[].concat(o(this.value));t(n),this.$emit("input",n)}},spliceList:function(){var t=arguments,n=function(n){return n.splice.apply(n,t)};this.alterList(n)},updatePosition:function(t,n){var e=function(e){return e.splice(n,0,e.splice(t,1)[0])};this.alterList(e)},getRelatedContextFromMoveEvent:function(t){var n=t.to,e=t.related,o=this.getUnderlyingPotencialDraggableComponent(n);if(!o)return{component:o};var r=o.realList,s={list:r,component:o};if(n!==e&&r&&o.getUnderlyingVm){var a=o.getUnderlyingVm(e);if(a)return i(a,s)}return s},getVmIndex:function(t){var n=this.visibleIndexes,e=n.length;return t>e-1?e:n[t]},getComponent:function(){return this.$slots.default[0].componentInstance},resetTransitionData:function(t){if(this.noTransitionOnDrag&&this.transitionMode){this.getChildrenNodes()[t].data=null;var n=this.getComponent();n.children=[],n.kept=void 0}},onDragStart:function(t){this.context=this.getUnderlyingVm(t.item),t.item._underlying_vm_=this.clone(this.context.element),d=t.item},onDragAdd:function(t){var e=t.item._underlying_vm_;if(void 0!==e){n(t.item);var i=this.getVmIndex(t.newIndex);this.spliceList(i,0,e),this.computeIndexes();var o={element:e,newIndex:i};this.emitChanges({added:o})}},onDragRemove:function(t){if(e(this.rootContainer,t.item,t.oldIndex),this.isCloning)n(t.clone);else{var i=this.context.index;this.spliceList(i,1);var o={element:this.context.element,oldIndex:i};this.resetTransitionData(i),this.emitChanges({removed:o})}},onDragUpdate:function(t){n(t.item),e(t.from,t.item,t.oldIndex);var i=this.context.index,o=this.getVmIndex(t.newIndex);this.updatePosition(i,o);var r={element:this.context.element,oldIndex:i,newIndex:o};this.emitChanges({moved:r})},computeFutureIndex:function(t,n){if(!t.element)return 0;var e=[].concat(o(n.to.children)).filter(function(t){return"none"!==t.style.display}),i=e.indexOf(n.related),r=t.component.getVmIndex(i);return-1!=e.indexOf(d)||!n.willInsertAfter?r:r+1},onDragMove:function(t,n){var e=this.move;if(!e||!this.realList)return!0;var o=this.getRelatedContextFromMoveEvent(t),r=this.context,s=this.computeFutureIndex(o,t);return i(r,{futureIndex:s}),i(t,{relatedContext:o,draggedContext:r}),e(t,n)},onDragEnd:function(t){this.computeIndexes(),d=null}}}}Array.from||(Array.from=function(t){return[].slice.call(t)});var r=e("HOBB");t.exports=n(r)}()},"4mrK":function(t,n,e){"use strict";Object.defineProperty(n,"__esModule",{value:!0});var i=e("HzJ8"),o=e.n(i),r=e("405r"),s={name:"DndList",components:{draggable:e.n(r).a},computed:{filterList2:function(){var t=this;return this.list2.filter(function(n){return!!t.isNotInList1(n)&&n})}},props:{list1:{type:Array,default:function(){return[]}},list2:{type:Array,default:function(){return[]}},list1Title:{type:String,default:"list1"},list2Title:{type:String,default:"list2"},width1:{type:String,default:"48%"},width2:{type:String,default:"48%"}},methods:{isNotInList1:function(t){return this.list1.every(function(n){return t.id!==n.id})},isNotInList2:function(t){return this.list2.every(function(n){return t.id!==n.id})},deleteEle:function(t){var n=!0,e=!1,i=void 0;try{for(var r,s=o()(this.list1);!(n=(r=s.next()).done);n=!0){var a=r.value;if(a.id===t.id){var l=this.list1.indexOf(a);this.list1.splice(l,1);break}}}catch(t){e=!0,i=t}finally{try{!n&&s.return&&s.return()}finally{if(e)throw i}}this.isNotInList2(t)&&this.list2.unshift(t)},pushEle:function(t){this.list1.push(t)}}},a={render:function(){var t=this,n=t.$createElement,e=t._self._c||n;return e("div",{staticClass:"dndList"},[e("div",{staticClass:"dndList-list",style:{width:t.width1}},[e("h3",[t._v(t._s(t.list1Title))]),t._v(" "),e("draggable",{staticClass:"dragArea",attrs:{list:t.list1,options:{group:"article"}}},t._l(t.list1,function(n){return e("div",{key:n.id,staticClass:"list-complete-item"},[e("div",{staticClass:"list-complete-item-handle"},[t._v("["+t._s(n.author)+"] "+t._s(n.title))]),t._v(" "),e("div",{staticStyle:{position:"absolute",right:"0px"}},[e("span",{staticStyle:{float:"right","margin-top":"-20px","margin-right":"5px"},on:{click:function(e){t.deleteEle(n)}}},[e("i",{staticClass:"el-icon-delete",staticStyle:{color:"#ff4949"}})])])])}))],1),t._v(" "),e("div",{staticClass:"dndList-list",style:{width:t.width2}},[e("h3",[t._v(t._s(t.list2Title))]),t._v(" "),e("draggable",{staticClass:"dragArea",attrs:{list:t.filterList2,options:{group:"article"}}},t._l(t.filterList2,function(n){return e("div",{key:n.id,staticClass:"list-complete-item"},[e("div",{staticClass:"list-complete-item-handle2",on:{click:function(e){t.pushEle(n)}}},[t._v(" ["+t._s(n.author)+"] "+t._s(n.title))])])}))],1)])},staticRenderFns:[]};var l=e("vSla")(s,a,!1,function(t){e("jfa4")},"data-v-5a0e7220",null).exports,d=e("viA7"),c={name:"dndList-demo",components:{DndList:l},data:function(){return{list1:[],list2:[]}},created:function(){this.getData()},methods:{getData:function(){var t=this;this.listLoading=!0,Object(d.c)().then(function(n){t.list1=n.data.items.splice(0,5),t.list2=n.data.items})}}},u={render:function(){var t=this.$createElement,n=this._self._c||t;return n("div",{staticClass:"components-container"},[this._m(0),this._v(" "),n("div",{staticClass:"editor-container"},[n("dnd-list",{attrs:{list1:this.list1,list2:this.list2,list1Title:"List",list2Title:"Article pool"}})],1)])},staticRenderFns:[function(){var t=this.$createElement,n=this._self._c||t;return n("code",[this._v("drag-list base on\n    "),n("a",{attrs:{href:"https://github.com/SortableJS/Vue.Draggable",target:"_blank"}},[this._v("Vue.Draggable")])])}]},h=e("vSla")(c,u,!1,null,null,null);n.default=h.exports},jfa4:function(t,n,e){var i=e("paI6");"string"==typeof i&&(i=[[t.i,i,""]]),i.locals&&(t.exports=i.locals);e("8bSs")("1908f755",i,!0)},paI6:function(t,n,e){(t.exports=e("BkJT")(!1)).push([t.i,'\n.dndList[data-v-5a0e7220] {\n  background: #fff;\n  padding-bottom: 40px;\n}\n.dndList[data-v-5a0e7220]:after {\n    content: "";\n    display: table;\n    clear: both;\n}\n.dndList .dndList-list[data-v-5a0e7220] {\n    float: left;\n    padding-bottom: 30px;\n}\n.dndList .dndList-list[data-v-5a0e7220]:first-of-type {\n      margin-right: 2%;\n}\n.dndList .dndList-list .dragArea[data-v-5a0e7220] {\n      margin-top: 15px;\n      min-height: 50px;\n      padding-bottom: 30px;\n}\n.list-complete-item[data-v-5a0e7220] {\n  cursor: pointer;\n  position: relative;\n  font-size: 14px;\n  padding: 5px 12px;\n  margin-top: 4px;\n  border: 1px solid #bfcbd9;\n  -webkit-transition: all 1s;\n  transition: all 1s;\n}\n.list-complete-item-handle[data-v-5a0e7220] {\n  overflow: hidden;\n  text-overflow: ellipsis;\n  white-space: nowrap;\n  margin-right: 50px;\n}\n.list-complete-item-handle2[data-v-5a0e7220] {\n  overflow: hidden;\n  text-overflow: ellipsis;\n  white-space: nowrap;\n  margin-right: 20px;\n}\n.list-complete-item.sortable-chosen[data-v-5a0e7220] {\n  background: #4AB7BD;\n}\n.list-complete-item.sortable-ghost[data-v-5a0e7220] {\n  background: #30B08F;\n}\n.list-complete-enter[data-v-5a0e7220],\n.list-complete-leave-active[data-v-5a0e7220] {\n  opacity: 0;\n}\n',""])}});