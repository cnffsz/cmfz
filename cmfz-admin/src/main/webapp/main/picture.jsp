<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<script type="text/javascript">
    $(function() {
        $("#datagrid").datagrid({
            url : "${pageContext.request.contextPath}/findPicture.do",
            columns : [ [ {
                title : "标识编号",
                field : "pictureId",
                width:400,
                align:'center'
            }, {
                title : "文件名",
                field : "picturePath",
                width:400,
                align:'center'
            }, {
                title : "描述信息",
                field : "pictureDescription",
                width:500,
                align:'center'
            }, {
                title : "轮播图状态",
                field : "pictureStatus",
                width:300,
                align:'center',
                formatter: function (value, row, index) {
                    if(value==0)
                        return "未展示";
                    else
                        return "展示中";
                }
            }, {
                title : "轮播图创建时间",
                field : "pictureDate",
                width:400,
                align:'center'
            }, {
                title: "操作",
                field: "operation",
                width:400,
                align:'center',
                formatter: function (value, row, index) {
                    return '<a class="easyui-linkbutton" data-options="iconCls:\'icon-edit\',plain:true" onclick="update()">修改</a>';
                }
            } ] ],
            height:668,
            fitColumns:true,
            pagination : true,
            pageList : [5,10,15,20],
            pageSize : 5,
            singleSelect:true,
            toolbar: "#tool",
            onLoadSuccess:function (data) {
                $.parser.parse();
            },
            remoteSort:false,
            nowrap:false,
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="images/' + rowData.picturePath + '" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '</td>' +
                    '</tr></table>';
            }

        });
    });
    function add() {
        $("#d1").dialog({
            width:400,
            height:200,
            title:"新增轮播图",
            iconCls:"icon-add",
            collapsible:true,
            maximizable:true,
            align:'center',
            href:"${pageContext.request.contextPath}/main/addForm.jsp",
            modal:true,
            shadow:true,
            buttons:[{
                iconCls:"icon-disk",
                text:"保存",
                handler:function(){
                    $("#form").form("submit",{
                        url:"${pageContext.request.contextPath}/add.do",
                        onSubmit:function(){
                            return $("#form").form("validate");
                        },
                        success:function(r){
                            if(r=="success"){
                                $("#datagrid").datagrid({
                                    url : "${pageContext.request.contextPath}/findPicture.do"
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
                    $("#d1").dialog("close");
                }
            },{
                iconCls:"icon-cancel",
                text:"取消",
                handler:function(){
                    $("#d1").dialog("close");
                }
            }]
        });
    }

    function update() {
        $("#d1").dialog({
            width:400,
            height:200,
            title:"修改用户",
            collapsible:true,
            maximizable:true,
            href:"${pageContext.request.contextPath}/main/updateForm.jsp",
            modal:true,
            shadow:true,
            onLoad:function(){
                var rowData = $("#datagrid").datagrid("getSelected");
                $("#form1").form("load",rowData);
            },
            buttons:[{
                iconCls:"icon-save",
                text:"保存",
                handler:function(){
                    $("#form1").form("submit",{
                        url:"${pageContext.request.contextPath}/update.do",
                        onSubmit:function(){
                            return $("#form1").form("validate");
                        },
                        success:function(r){
                            if(r=="success"){
                                $("#datagrid").datagrid({
                                    url : "${pageContext.request.contextPath}/findPicture.do"
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
                    $("#d1").dialog("close");
                }
            },{
                iconCls:"icon-cancel",
                text:"取消",
                handler:function(){
                    $("#d1").dialog("close");
                }
            }]
        });
    }
</script>

<table id="datagrid"></table>

<div id="tool">
    <a class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:true,text:'新增轮播图'" onclick="add()"></a>
    <a class="easyui-linkbutton" data-options="iconCls:'icon-help',plain:true,text:'帮助'"></a>
</div>

<div id="d1"></div>

