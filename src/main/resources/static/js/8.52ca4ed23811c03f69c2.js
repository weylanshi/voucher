webpackJsonp([8],{"0tA8":function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var n={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"table"},[a("div",{staticClass:"container"},[a("div",{staticClass:"handle-box"},[a("el-input",{staticClass:"handle-input mr10",staticStyle:{width:"260px"},attrs:{placeholder:"合同执行单编码"},model:{value:t.reqData.cExecID,callback:function(e){t.$set(t.reqData,"cExecID",e)},expression:"reqData.cExecID"}}),t._v(" "),a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"合同编码"},model:{value:t.reqData.cContractID,callback:function(e){t.$set(t.reqData,"cContractID",e)},expression:"reqData.cContractID"}}),t._v(" "),a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"合同名称"},model:{value:t.reqData.strContractName,callback:function(e){t.$set(t.reqData,"strContractName",e)},expression:"reqData.strContractName"}}),t._v(" "),a("el-date-picker",{attrs:{align:"right",type:"date","value-format":"yyyy-MM-dd",placeholder:"制单日期最小日期"},model:{value:t.reqData.date1,callback:function(e){t.$set(t.reqData,"date1",e)},expression:"reqData.date1"}}),t._v(" "),a("el-date-picker",{attrs:{align:"right",type:"date","value-format":"yyyy-MM-dd",placeholder:"制单日期最大日期"},model:{value:t.reqData.date2,callback:function(e){t.$set(t.reqData,"date2",e)},expression:"reqData.date2"}}),t._v(" "),a("el-button",{attrs:{type:"primary",size:"mini",icon:"search"},on:{click:t.search}},[t._v("搜索")])],1),t._v(" "),a("el-table",{ref:"multipleTable",attrs:{data:t.content,border:""}},[a("el-table-column",{attrs:{prop:"cExecID",label:"合同执行单编码"}}),t._v(" "),a("el-table-column",{attrs:{prop:"cContractID",label:"合同编码"}}),t._v(" "),a("el-table-column",{attrs:{prop:"dtProduceDate",label:"制单日期"}}),t._v(" "),a("el-table-column",{attrs:{prop:"strContractName",label:"合同名称"}}),t._v(" "),a("el-table-column",{attrs:{prop:"strContractKind",label:"合同类型"}}),t._v(" "),a("el-table-column",{attrs:{prop:"decRateMoney",label:"执行单总金额"}}),t._v(" "),a("el-table-column",{attrs:{label:"操作",width:"100"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"small",type:"primary",disabled:t.checkDefine(t.content[e.$index].cDefine10)},on:{click:function(a){t.pzadd(t.content[e.$index].guid)}}},[t._v("生成凭证")])]}}])})],1),t._v(" "),a("div",{directives:[{name:"show",rawName:"v-show",value:t.content.length<=0,expression:"content.length <= 0"}],staticClass:"noData"},[t._v("暂无数据")]),t._v(" "),a("div",{staticClass:"pagination"},[a("el-pagination",{attrs:{layout:"total, sizes, prev, pager, next, jumper","page-count":t.totalPages,"page-size":t.reqData.pageSize},on:{"current-change":t.handleCurrentChange,"size-change":t.handleSizeChange}})],1)],1)])},staticRenderFns:[]};var r=a("VU/8")({name:"basetable",data:function(){return{reqData:{pageNum:1,pageSize:10,cExecID:"",cContractID:"",date1:"",date2:"",strContractName:""},content:[{dblExchange:0,dblTotalCurrency:0,guid:"",cExecID:"",cContractID:"",dtProduceDate:"",strContractName:"",strContractKind:"",decRateMoney:""}],totalPages:0}},created:function(){this.getData()},computed:{},methods:{handleCurrentChange:function(t){this.reqData.pageNum=t,this.getData()},handleSizeChange:function(t){this.reqData.pageSize=t,this.getData()},getData:function(){var t=this;this.$axios.post("/api/ZXD/outList",this.$qs.stringify(this.reqData)).then(function(e){t.content=e.data.content,t.totalPages=e.data.totalPages})},checkDefine:function(t){return!!t},pzadd:function(t){var e=this,a={guid:t,type:2};this.$axios.post("/api/PZ/pzAdd",this.$qs.stringify(a)).then(function(t){t.pzId,t.pzId?(e.$message.success("生成凭证成功"),e.getData()):e.$message.error("生成凭证失败")})},search:function(){this.reqData.pageNum=1,this.getData()}}},n,!1,function(t){a("fu9q")},"data-v-25173893",null);e.default=r.exports},fu9q:function(t,e){}});