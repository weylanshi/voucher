webpackJsonp([2],{Ylmc:function(t,e,a){"use strict";Object.defineProperty(e,"__esModule",{value:!0});var n={render:function(){var t=this,e=t.$createElement,a=t._self._c||e;return a("div",{staticClass:"table"},[a("div",{staticClass:"container"},[a("div",{staticClass:"handle-box"},[a("el-input",{staticClass:"handle-input mr10",attrs:{placeholder:"合同结算单编码"},model:{value:t.reqData.cBalanceID,callback:function(e){t.$set(t.reqData,"cBalanceID",e)},expression:"reqData.cBalanceID"}}),t._v(" "),a("el-date-picker",{attrs:{align:"right",type:"date","value-format":"yyyy-MM-dd",placeholder:"执行单日期1"},model:{value:t.reqData.date1,callback:function(e){t.$set(t.reqData,"date1",e)},expression:"reqData.date1"}}),t._v(" "),a("el-date-picker",{attrs:{align:"right",type:"date","value-format":"yyyy-MM-dd",placeholder:"执行单日期2"},model:{value:t.reqData.date2,callback:function(e){t.$set(t.reqData,"date2",e)},expression:"reqData.date2"}}),t._v(" "),a("el-button",{attrs:{type:"primary",size:"mini",icon:"search"},on:{click:t.search}},[t._v("搜索")])],1),t._v(" "),a("el-table",{ref:"multipleTable",attrs:{data:t.content,border:""}},[a("el-table-column",{attrs:{prop:"cBalanceID",label:"结算单编码"}}),t._v(" "),a("el-table-column",{attrs:{prop:"strContractId",label:"合同编码"}}),t._v(" "),a("el-table-column",{attrs:{prop:"strContractKind",label:"合同类型分类"}}),t._v(" "),a("el-table-column",{attrs:{prop:"strContractName",label:"合同名称",width:"220"}}),t._v(" "),a("el-table-column",{attrs:{prop:"cTypeName",label:"合同类型"}}),t._v(" "),a("el-table-column",{attrs:{prop:"strWay",label:"收支方向"}}),t._v(" "),a("el-table-column",{attrs:{prop:"strBisectionUnit",label:"对方单位编码"}}),t._v(" "),a("el-table-column",{attrs:{prop:"cCusName",label:"对方单位名称"}}),t._v(" "),a("el-table-column",{attrs:{prop:"strCurrency",label:"币种"}}),t._v(" "),a("el-table-column",{attrs:{prop:"dblExchange",label:"汇率"}}),t._v(" "),a("el-table-column",{attrs:{prop:"dblTotalCurrency",label:"结算单总金额"}}),t._v(" "),a("el-table-column",{attrs:{prop:"dtCreateTime",label:"制单日期"}}),t._v(" "),a("el-table-column",{attrs:{label:"操作",width:"100"},scopedSlots:t._u([{key:"default",fn:function(e){return[a("el-button",{attrs:{size:"small",type:"primary",disabled:t.checkDefine(t.content[e.$index].cDefine10)},on:{click:function(a){t.pzadd(t.content[e.$index].guid)}}},[t._v("生成凭证")])]}}])})],1),t._v(" "),a("div",{staticClass:"pagination"},[a("el-pagination",{attrs:{layout:"total, sizes, prev, pager, next, jumper","page-count":t.totalPages,"page-size":t.reqData.pageSize},on:{"current-change":t.handleCurrentChange,"size-change":t.handleSizeChange}})],1)],1)])},staticRenderFns:[]};var l=a("VU/8")({name:"basetable",data:function(){return{reqData:{pageNum:1,pageSize:10,cBalanceID:"",date1:"",date2:""},content:[{cBalanceID:"",strContractId:"",strContractKind:"",strContractName:"",cTypeName:"",strWay:"",cCusName:"",strCurrency:"",dblExchange:"",dblTotalCurrency:"",dtCreateTime:""}],totalPages:0}},created:function(){this.getData()},computed:{},methods:{handleCurrentChange:function(t){this.reqData.pageNum=t,this.getData()},handleSizeChange:function(t){this.reqData.pageSize=t,this.getData()},getData:function(){var t=this;this.$axios.post("/api/JSD/inList",this.$qs.stringify(this.reqData)).then(function(e){t.content=e.data.content,t.totalPages=e.data.totalPages})},search:function(){this.reqData.pageNum=1,this.getData()},checkDefine:function(t){return!!t},pzadd:function(t){var e=this,a={guid:t,type:1};this.$axios.post("/api/PZ/pzAdd",this.$qs.stringify(a)).then(function(t){t.pzId,t.pzId?(e.$message.success("生成凭证成功"),e.getData()):e.$message.error("生成凭证失败")})}}},n,!1,function(t){a("ucCT")},"data-v-ce95c040",null);e.default=l.exports},ucCT:function(t,e){}});