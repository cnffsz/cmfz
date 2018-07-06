<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {
        $("#datagrid_master").datagrid({
            url : "${pageContext.request.contextPath}/findMaster.do",
            columns : [ [ {
                title : "标识编号",
                field : "masterId",
                width:500,
                align:'center'
            }, {
                title : "法号",
                field : "masterName",
                width:400,
                align:'center'
            }, {
                title : "照片",
                field : "masterPhoto",
                width:400,
                align:'center'
            }, {
                title : "上师简介",
                field : "masterSummary",
                width:700,
                align:'center'
            }, {
                title: "操作",
                field: "operation",
                width:400,
                align:'center',
                formatter: function (value, row, index) {
                    return '<a class="easyui-linkbutton" data-options="iconCls:\'icon-edit\',plain:true" onclick="updateMaster()">修改</a>';
                }
            } ] ],
            height:668,
            fitColumns:true,
            pagination : true,
            pageList : [5,10,15,20],
            pageSize : 5,
            singleSelect:true,
            toolbar: "#tool_master",
            onLoadSuccess:function (data) {
                $.parser.parse();
            },
            remoteSort:false,
            nowrap:false,
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="${pageContext.request.contextPath}/masterPhoto/' + rowData.masterPhoto + '" style="height:200px;"></td>' +
                    '<td style="border:0">' +
                    '</td>' +
                    '</tr></table>';
            }

        });

        $('#ss').searchbox({
            searcher:function(value,name){
                $("#datagrid_master").datagrid({
                    url : "${pageContext.request.contextPath}/findByKey.do?key="+value
                });
            },
            prompt:'请您输入法名关键字'
        });
    });


    function addMaster() {
        $("#d1_master").dialog({
            width:400,
            height:200,
            title:"新增上师",
            iconCls:"icon-add",
            collapsible:true,
            maximizable:true,
            align:'center',
            href:"${pageContext.request.contextPath}/main/addForm_master.jsp",
            modal:true,
            shadow:true,
            buttons:[{
                iconCls:"icon-disk",
                text:"保存",
                handler:function(){
                    $("#form_master").form("submit",{
                        url:"${pageContext.request.contextPath}/addMaster.do",
                        onSubmit:function(){
                            return $("#form_master").form("validate");
                        },
                        success:function(r){
                            if(r=="success"){
                                $("#datagrid_master").datagrid({
                                    url : "${pageContext.request.contextPath}/findMaster.do"
                                });
                                $.messager.show({
                                    title:"通知",
                                    msg:"添加成功",
                                    timeout:3000,
                                    showType:"slider",
                                });
                            }else{
                                $.messager.show({
                                    title:"通知",
                                    msg:"添加失败",
                                    timeout:3000,
                                    showType:"slider",
                                });
                            }
                        }
                    });
                    $("#d1_master").dialog("close");
                }
            },{
                iconCls:"icon-cancel",
                text:"取消",
                handler:function(){
                    $("#d1_master").dialog("close");
                }
            }]
        });
    }

    function updateMaster() {
        $("#d1_master").dialog({
            width:400,
            height:200,
            title:"修改上师信息",
            collapsible:true,
            maximizable:true,
            href:"${pageContext.request.contextPath}/main/updateForm_master.jsp",
            modal:true,
            shadow:true,
            onLoad:function(){
                var rowData = $("#datagrid_master").datagrid("getSelected");
                $("#form1_master").form("load",rowData);
            },
            buttons:[{
                iconCls:"icon-disk",
                text:"保存",
                handler:function(){
                    $("#form1_master").form("submit",{
                        url:"${pageContext.request.contextPath}/modifyMaster.do",
                        onSubmit:function(){
                            return $("#form1_master").form("validate");
                        },
                        success:function(r){
                            if(r=="success"){
                                $("#datagrid_master").datagrid({
                                    url : "${pageContext.request.contextPath}/findMaster.do"
                                });
                                $.messager.show({
                                    title:"通知",
                                    msg:"修改成功",
                                    timeout:3000,
                                    showType:"slider",
                                });
                            }else{
                                 $.messager.show({
                                    title:"通知",
                                    msg:"修改失败",
                                    timeout:3000,
                                    showType:"slider",
                                });
                            }
                        }
                    });
                    $("#d1_master").dialog("close");
                }
            },{
                iconCls:"icon-cancel",
                text:"取消",
                handler:function(){
                    $("#d1_master").dialog("close");
                }
            }]
        });
    }
</script>

<table id="datagrid_master"></table>

<div id="tool_master">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增上师'" onclick="addMaster()"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true,text:'帮助'"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-page_add',plain:true,text:'批量添加'" ></a>
    <input id="ss"/>
</div>

<div id="d1_master"></div>

