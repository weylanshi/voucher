webpackJsonp([12],{"0tA8":function(t,a,e){"use strict";Object.defineProperty(a,"__esModule",{value:!0});var n={render:function(){var t=this,a=t.$createElement,e=t._self._c||a;return e("div",{staticClass:"table"},[e("div",{staticClass:"container"},[e("div",{staticClass:"handle-box"},[e("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"合同执行单编码"},model:{value:t.reqData.cExecID,callback:function(a){t.$set(t.reqData,"cExecID",a)},expression:"reqData.cExecID"}}),t._v(" "),e("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"合同编码"},model:{value:t.reqData.cContractID,callback:function(a){t.$set(t.reqData,"cContractID",a)},expression:"reqData.cContractID"}}),t._v(" "),e("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"合同名称"},model:{value:t.reqData.strContractName,callback:function(a){t.$set(t.reqData,"strContractName",a)},expression:"reqData.strContractName"}}),t._v(" "),e("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"制单日期最小日期"},model:{value:t.reqData.date1,callback:function(a){t.$set(t.reqData,"date1",a)},expression:"reqData.date1"}}),t._v(" "),e("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"制单日期最大日期"},model:{value:t.reqData.date2,callback:function(a){t.$set(t.reqData,"date2",a)},expression:"reqData.date2"}}),t._v(" "),e("el-button",{attrs:{type:"primary",size:"mini",icon:"search"},on:{click:t.search}},[t._v("搜索")]),t._v(" "),e("el-button",{attrs:{type:"primary",size:"mini",icon:"search"},on:{click:t.search}},[t._v("生成凭证")])],1),t._v(" "),e("el-table",{ref:"multipleTable",attrs:{data:t.content,border:""}},[e("el-table-column",{attrs:{prop:"cExecID",label:"合同执行单编码"}}),t._v(" "),e("el-table-column",{attrs:{prop:"cContractID",label:"合同编码"}}),t._v(" "),e("el-table-column",{attrs:{prop:"dtProduceDate",label:"制单日期"}}),t._v(" "),e("el-table-column",{attrs:{prop:"strContractName",label:"合同名称"}}),t._v(" "),e("el-table-column",{attrs:{prop:"strContractKind",label:"合同类型"}}),t._v(" "),e("el-table-column",{attrs:{prop:"decRateMoney",label:"执行单总金额"}})],1),t._v(" "),e("div",{staticClass:"pagination"},[e("el-pagination",{attrs:{layout:"total, sizes, prev, pager, next, jumper","page-count":t.totalPages,"page-size":t.reqData.pageSize},on:{"current-change":t.handleCurrentChange,"size-change":t.handleSizeChange}})],1)],1)])},staticRenderFns:[]};var r=e("VU/8")({name:"basetable",data:function(){return{reqData:{pageNum:1,pageSize:10,cExecID:"",cContractID:"",date1:"",date2:"",strContractName:""},content:[{dblExchange:0,dblTotalCurrency:0,guid:"",cExecID:"",cContractID:"",dtProduceDate:"",strContractName:"",strContractKind:"",decRateMoney:""}],totalPages:0}},created:function(){this.getData()},computed:{},methods:{handleCurrentChange:function(t){this.reqData.pageNum=t,this.getData()},handleSizeChange:function(t){this.reqData.pageSize=t,this.getData()},getData:function(){var t=this;this.$axios.post("/api/ZXD/list",this.$qs.stringify(this.reqData)).then(function(a){t.content=a.data.content,t.totalPages=a.data.totalPages})},search:function(){this.reqData.pageNum=1,this.getData()}}},n,!1,function(t){e("nSNS")},"data-v-5a79f561",null);a.default=r.exports},nSNS:function(t,a){}});